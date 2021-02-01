package com.myfarm.flashsale.core.modules.production.service.imp;

import com.myfarm.flashsale.core.modules.production.dto.BandDto;
import com.myfarm.flashsale.core.modules.production.exception.BandBusinessException;
import com.myfarm.flashsale.core.modules.production.exception.BandNotFoundException;
import com.myfarm.flashsale.core.modules.production.exception.BandParameterException;
import com.myfarm.flashsale.core.modules.production.repository.mappers.BandMapper;
import com.myfarm.flashsale.core.modules.production.service.BandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BandServiceImp implements BandService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;
    @Resource
    private BandMapper bandMapper;

    @Override
    public List<BandDto> getAllBands() throws BandParameterException, BandBusinessException, BandNotFoundException {
        return null;
    }

    @Override
    public BandDto getBandById(String bandId) throws BandParameterException, BandBusinessException, BandNotFoundException {
        return null;
    }

    @Override
    public BandDto addBand(String band) throws BandParameterException, BandBusinessException, BandNotFoundException {
        return null;
    }

    @Override
    public void deleteBandById(String bandId) throws BandParameterException, BandBusinessException, BandNotFoundException {

    }
}
