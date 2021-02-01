package com.myfarm.flashsale.core.modules.audit.service;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.audit.dto.AuditDto;
import com.myfarm.flashsale.core.modules.audit.dto.filter.AuditFilter;
import com.myfarm.flashsale.core.modules.audit.exception.AuditBusinessException;
import com.myfarm.flashsale.core.modules.audit.exception.AuditNotFoundException;
import com.myfarm.flashsale.core.modules.audit.exception.AuditParameterException;

public interface AuditService {
    PageInfo<AuditDto> getAuditByFilter(AuditFilter auditFilter, int page, int pageSize) throws AuditParameterException, AuditBusinessException, AuditNotFoundException;
    AuditDto getAuditById(String auditId) throws AuditParameterException, AuditBusinessException, AuditNotFoundException;
    AuditDto updateAudit(AuditDto auditDto) throws AuditParameterException, AuditBusinessException, AuditNotFoundException;
    void deleteAudit(String auditId) throws AuditParameterException, AuditBusinessException, AuditNotFoundException;
}
