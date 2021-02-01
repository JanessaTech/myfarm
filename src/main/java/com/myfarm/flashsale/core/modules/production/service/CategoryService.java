package com.myfarm.flashsale.core.modules.production.service;

import com.myfarm.flashsale.core.modules.production.dto.CategoryDto;
import com.myfarm.flashsale.core.modules.production.exception.CategoryBusinessException;
import com.myfarm.flashsale.core.modules.production.exception.CategoryNotFoundException;
import com.myfarm.flashsale.core.modules.production.exception.CategoryParameterException;

import java.util.List;

public interface CategoryService {
    /**
     * return all bands
     * by default, sort result by category_id in ascending order
     * @return
     */
    List<CategoryDto> getAllCategories() throws CategoryParameterException, CategoryBusinessException, CategoryNotFoundException;
    CategoryDto getCategoryById(String categoryId) throws CategoryParameterException, CategoryBusinessException, CategoryNotFoundException;
    CategoryDto addCategory(String category) throws CategoryParameterException, CategoryBusinessException, CategoryNotFoundException;
    void deleteCategoryById(String categoryId) throws CategoryParameterException, CategoryBusinessException, CategoryNotFoundException;
}
