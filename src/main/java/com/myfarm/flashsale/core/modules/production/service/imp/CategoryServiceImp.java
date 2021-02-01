package com.myfarm.flashsale.core.modules.production.service.imp;

import com.myfarm.flashsale.core.modules.production.dto.CategoryDto;
import com.myfarm.flashsale.core.modules.production.exception.CategoryBusinessException;
import com.myfarm.flashsale.core.modules.production.exception.CategoryNotFoundException;
import com.myfarm.flashsale.core.modules.production.exception.CategoryParameterException;
import com.myfarm.flashsale.core.modules.production.repository.mappers.CategoryMapper;
import com.myfarm.flashsale.core.modules.production.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;
    @Resource
    private CategoryMapper categoryMapper;
    @Override
    public List<CategoryDto> getAllCategories() throws CategoryParameterException, CategoryBusinessException, CategoryNotFoundException {
        return null;
    }

    @Override
    public CategoryDto getCategoryById(String categoryId) throws CategoryParameterException, CategoryBusinessException, CategoryNotFoundException {
        return null;
    }

    @Override
    public CategoryDto addCategory(String category) throws CategoryParameterException, CategoryBusinessException, CategoryNotFoundException {
        return null;
    }

    @Override
    public void deleteCategoryById(String categoryId) throws CategoryParameterException, CategoryBusinessException, CategoryNotFoundException {

    }
}
