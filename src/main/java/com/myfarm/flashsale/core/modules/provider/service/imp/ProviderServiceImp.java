package com.myfarm.flashsale.core.modules.provider.service.imp;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.provider.dto.ProviderDto;
import com.myfarm.flashsale.core.modules.provider.dto.filter.ProviderFilter;
import com.myfarm.flashsale.core.modules.provider.exception.ProviderBusinessException;
import com.myfarm.flashsale.core.modules.provider.exception.ProviderNotFoundException;
import com.myfarm.flashsale.core.modules.provider.exception.ProviderParameterException;
import com.myfarm.flashsale.core.modules.provider.repository.mappers.ProviderMapper;
import com.myfarm.flashsale.core.modules.provider.service.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProviderServiceImp implements ProviderService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;
    @Resource
    private ProviderMapper providerMapper;

    @Override
    public PageInfo<ProviderDto> getProvidersByFilter(ProviderFilter providerFilter, int page, int pageSize) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException {
        return null;
    }

    @Override
    public ProviderDto getProviderById(String providerId) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException {
        return null;
    }

    @Override
    public void addProvider(ProviderDto providerDto) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException {

    }

    @Override
    public ProviderDto updateProvider(ProviderDto providerDto) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException {
        return null;
    }

    @Override
    public ProviderDto setProviderOnLine(String providerId) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException {
        return null;
    }

    @Override
    public ProviderDto setProviderOffLine(String providerId) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException {
        return null;
    }

    @Override
    public void deleteProviderByIds(List<String> providerIds) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException {

    }
}
