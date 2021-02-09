package com.myfarm.flashsale.core.modules.production.service.imp;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.production.dto.ProductionDto;
import com.myfarm.flashsale.core.modules.production.vo.filter.ProductionFilter;
import com.myfarm.flashsale.core.modules.production.exception.ProductionBusinessException;
import com.myfarm.flashsale.core.modules.production.exception.ProductionNotFoundException;
import com.myfarm.flashsale.core.modules.production.exception.ProductionParameterException;
import com.myfarm.flashsale.core.modules.production.repository.mappers.ProductionMapper;
import com.myfarm.flashsale.core.modules.production.service.ProductionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductionServiceImp implements ProductionService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;
    @Resource
    private ProductionMapper productionMapper;

    @Override
    public PageInfo<ProductionDto> getProductionsByFilter(ProductionFilter productionFilter, int page, int pageSize) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException {
        return null;
    }

    @Override
    public ProductionDto getProductionById(String productionId) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException {
        return null;
    }

    @Override
    public void addProduction(ProductionDto productionDto) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException {

    }

    @Override
    public ProductionDto updateProduction(ProductionDto productionDto) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException {
        return null;
    }

    @Override
    public ProductionDto setProductionStatus(String productionId, String status) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException {
        return null;
    }

    @Override
    public void deleteProductionByIds(List<String> productionIds) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException {

    }
}
