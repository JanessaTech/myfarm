package com.myfarm.flashsale.core.modules.provider.service;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.provider.dto.ProviderDto;
import com.myfarm.flashsale.core.modules.provider.dto.filter.ProviderFilter;
import com.myfarm.flashsale.core.modules.provider.exception.ProviderBusinessException;
import com.myfarm.flashsale.core.modules.provider.exception.ProviderNotFoundException;
import com.myfarm.flashsale.core.modules.provider.exception.ProviderParameterException;

import java.util.List;

public interface ProviderService {
    PageInfo<ProviderDto> getProvidersByFilter(ProviderFilter providerFilter, int page, int pageSize) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException;
    ProviderDto getProviderById(String providerId) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException;
    void addProvider(ProviderDto providerDto) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException;
    ProviderDto updateProvider(ProviderDto providerDto) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException;
    ProviderDto setProviderStatus(String providerId, String status) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException;
    void deleteProviderByIds(List<String> providerIds) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException;
}
