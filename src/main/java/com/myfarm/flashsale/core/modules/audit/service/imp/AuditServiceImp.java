package com.myfarm.flashsale.core.modules.audit.service.imp;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.audit.dto.AuditDto;
import com.myfarm.flashsale.core.modules.audit.dto.filter.AuditFilter;
import com.myfarm.flashsale.core.modules.audit.exception.AuditBusinessException;
import com.myfarm.flashsale.core.modules.audit.exception.AuditNotFoundException;
import com.myfarm.flashsale.core.modules.audit.exception.AuditParameterException;
import com.myfarm.flashsale.core.modules.audit.service.AuditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImp implements AuditService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;
    //which mapper we need to refer?

    @Override
    public PageInfo<AuditDto> getAuditByFilter(AuditFilter auditFilter, int page, int pageSize) throws AuditParameterException, AuditBusinessException, AuditNotFoundException {
        return null;
    }

    @Override
    public AuditDto getAuditById(String auditId) throws AuditParameterException, AuditBusinessException, AuditNotFoundException {
        return null;
    }

    @Override
    public AuditDto updateAudit(AuditDto auditDto) throws AuditParameterException, AuditBusinessException, AuditNotFoundException {
        return null;
    }

    @Override
    public void deleteAudit(String auditId) throws AuditParameterException, AuditBusinessException, AuditNotFoundException {

    }
}
