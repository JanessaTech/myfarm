package com.myfarm.flashsale.core.modules.site.service;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.site.dto.SiteDto;
import com.myfarm.flashsale.core.modules.site.dto.filter.SiteFilter;
import com.myfarm.flashsale.core.modules.site.exception.SiteException;

import java.util.List;

public interface SiteService {
    PageInfo<SiteDto> getSitesByFilter(SiteFilter siteFilter, int page, int pageSize) throws SiteException;
    SiteDto getSiteById(String siteId) throws SiteException;
    void addSite(SiteDto siteDto) throws SiteException;
    SiteDto updateSite(SiteDto siteDto) throws SiteException;
    SiteDto setSiteOnLine(String siteId) throws SiteException;
    SiteDto setSiteOffLine(String siteId) throws SiteException;
    void deleteSiteById(String siteId) throws SiteException;
    void deleteSiteByIds(List<String> siteIds) throws SiteException;

}
