package com.myfarm.flashsale.core.config;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Optional;
import com.myfarm.flashsale.core.modules.common.validation.ApiIgp;
import io.micrometer.core.instrument.util.StringUtils;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtField;
import org.apache.ibatis.javassist.NotFoundException;
import org.apache.ibatis.javassist.bytecode.AnnotationsAttribute;
import org.apache.ibatis.javassist.bytecode.ConstPool;
import org.apache.ibatis.javassist.bytecode.annotation.Annotation;
import org.apache.ibatis.javassist.bytecode.annotation.StringMemberValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResolvedMethodParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ParameterBuilderPlugin;
import springfox.documentation.spi.service.contexts.ParameterContext;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
@Order
public class SwaggerApiConfig implements ParameterBuilderPlugin {
    @Autowired
    private TypeResolver typeResolver;

    @Override
    public void apply(ParameterContext parameterContext) {
        ResolvedMethodParameter methodParameter = parameterContext.resolvedMethodParameter();
        Class originClass = parameterContext.resolvedMethodParameter().getParameterType().getErasedType();


        Optional<ApiIgp> optional = methodParameter.findAnnotation(ApiIgp.class);
        if (optional.isPresent()) {
            Random random = new Random();
            String name = originClass.getSimpleName() + "Model" + random.nextInt(100);  //model 名称
            String[] properties = optional.get().value();
            try {
                parameterContext.getDocumentationContext()
                        .getAdditionalModels()
                        .add(typeResolver.resolve(createRefModelIgp(properties, originClass.getPackage()+"."+name, originClass)));  //像documentContext的Models中添加我们新生成的Class
            } catch (Exception e) {
                e.printStackTrace();
            }
            parameterContext.parameterBuilder()  //修改Map参数的ModelRef为我们动态生成的class
                    .parameterType("body")
                    .modelRef(new ModelRef(name))
                    .name(name);
        }

    }

    private Class createRefModelIgp(String[] propertys, String name, Class origin) throws NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass( name);
        try {
            Field[] fields = origin.getDeclaredFields();
            List<Field> fieldList = Arrays.asList(fields);
            List<String> ignorePropertys = Arrays.asList(propertys);
            List<Field> dealFileds = fieldList.stream().filter(s -> !ignorePropertys.contains(s.getName())).collect(Collectors.toList());
            for (Field field : dealFileds) {
                CtField ctField = new CtField(ClassPool.getDefault().get(field.getType().getName()), field.getName(), ctClass);
                ctField.setModifiers(Modifier.PUBLIC);
                ApiModelProperty ampAnno = origin.getDeclaredField(field.getName()).getAnnotation(ApiModelProperty.class);
                String attributes = java.util.Optional.ofNullable(ampAnno).map(s->s.value()).orElse("");
                if (StringUtils.isNotBlank(attributes) ){ //添加model属性说明
                    ConstPool constPool = ctClass.getClassFile().getConstPool();
                    AnnotationsAttribute attr = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
                    Annotation ann = new Annotation(ApiModelProperty.class.getName(), constPool);
                    ann.addMemberValue("value", new StringMemberValue(attributes, constPool));
                    attr.addAnnotation(ann);
                    ctField.getFieldInfo().addAttribute(attr);
                }
                ctClass.addField(ctField);
            }
            return ctClass.toClass();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




    @Override
    public boolean supports(DocumentationType documentationType) {
        return true;
    }

}
