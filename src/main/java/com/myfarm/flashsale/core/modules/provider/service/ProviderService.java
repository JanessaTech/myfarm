package com.myfarm.flashsale.core.modules.provider.service;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.provider.dto.ProviderDto;
import com.myfarm.flashsale.core.modules.provider.dto.filter.ProviderFilter;
import com.myfarm.flashsale.core.modules.provider.exception.ProviderException;

import java.util.List;

public interface ProviderService {
    PageInfo<ProviderDto> getProvidersByFilter(ProviderFilter providerFilter, int page, int pageSize) throws ProviderException;
    ProviderDto getProviderById(String providerId) throws ProviderException;
    void addProvider(ProviderDto providerDto) throws ProviderException;
    ProviderDto updateProvider(ProviderDto providerDto) throws ProviderException;
    ProviderDto setProviderOnLine(String providerId) throws ProviderException;
    ProviderDto setProviderOffLine(String providerId) throws ProviderException;
    void deleteProviderById(String providerId) throws ProviderException;
    void deleteProviderByIds(List<String> providerIds);
}
