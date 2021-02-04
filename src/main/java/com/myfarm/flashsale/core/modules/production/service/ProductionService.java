package com.myfarm.flashsale.core.modules.production.service;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.production.dto.ProductionDto;
import com.myfarm.flashsale.core.modules.production.dto.filter.ProductionFilter;
import com.myfarm.flashsale.core.modules.production.exception.ProductionBusinessException;
import com.myfarm.flashsale.core.modules.production.exception.ProductionNotFoundException;
import com.myfarm.flashsale.core.modules.production.exception.ProductionParameterException;

import java.util.List;

public interface ProductionService {
    PageInfo<ProductionDto> getProductionsByFilter(ProductionFilter productionFilter, int page, int pageSize) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException;
    ProductionDto getProductionById(String productionId) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException;
    void addProduction(ProductionDto productionDto) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException;
    ProductionDto updateProduction(ProductionDto productionDto) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException;
    ProductionDto setProductionStatus(String productionId, String status) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException;
    void deleteProductionByIds(List<String> productionIds) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException;
}
