package com.myfarm.flashsale.core.modules.site.service.Imp;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.site.dto.SiteDto;
import com.myfarm.flashsale.core.modules.site.dto.filter.SiteFilter;
import com.myfarm.flashsale.core.modules.site.exception.SiteException;
import com.myfarm.flashsale.core.modules.site.repository.mappers.SiteMapper;
import com.myfarm.flashsale.core.modules.site.service.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SiteServiceImp implements SiteService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;
    @Resource
    private SiteMapper siteMapper;

    @Override
    public PageInfo<SiteDto> getSitesByFilter(SiteFilter siteFilter, int page, int pageSize) throws SiteException {
        return null;
    }

    @Override
    public SiteDto getSiteById(String siteId) throws SiteException {
        return null;
    }

    @Override
    public void addSite(SiteDto siteDto) throws SiteException {

    }

    @Override
    public SiteDto updateSite(SiteDto siteDto) throws SiteException {
        return null;
    }

    @Override
    public SiteDto setSiteOnLine(String siteId) throws SiteException {
        return null;
    }

    @Override
    public SiteDto setSiteOffLine(String siteId) throws SiteException {
        return null;
    }

    @Override
    public void deleteSiteById(String siteId) throws SiteException {

    }

    @Override
    public void deleteSiteByIds(List<String> siteIds) throws SiteException {

    }
}
