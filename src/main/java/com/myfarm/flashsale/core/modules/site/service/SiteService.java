package com.myfarm.flashsale.core.modules.site.service;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.site.dto.SiteDto;
import com.myfarm.flashsale.core.modules.site.dto.filter.SiteFilter;
import com.myfarm.flashsale.core.modules.site.exception.SiteBusinessException;
import com.myfarm.flashsale.core.modules.site.exception.SiteNotFoundException;
import com.myfarm.flashsale.core.modules.site.exception.SiteParameterException;

import java.util.List;

public interface SiteService {
    PageInfo<SiteDto> getSitesByFilter(SiteFilter siteFilter, int page, int pageSize) throws SiteParameterException, SiteBusinessException, SiteNotFoundException;
    SiteDto getSiteById(String siteId) throws SiteParameterException, SiteBusinessException, SiteNotFoundException;
    void addSite(SiteDto siteDto) throws SiteParameterException, SiteBusinessException, SiteNotFoundException;
    SiteDto updateSite(SiteDto siteDto) throws SiteParameterException, SiteBusinessException, SiteNotFoundException;
    SiteDto setSiteStatus(String siteId, String status) throws SiteParameterException, SiteBusinessException, SiteNotFoundException;
    void deleteSiteByIds(List<String> siteIds) throws SiteParameterException, SiteBusinessException, SiteNotFoundException;
}
