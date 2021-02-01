package com.myfarm.flashsale.core.modules.production.service;

import com.myfarm.flashsale.core.modules.production.dto.BandDto;
import com.myfarm.flashsale.core.modules.production.exception.BandBusinessException;
import com.myfarm.flashsale.core.modules.production.exception.BandNotFoundException;
import com.myfarm.flashsale.core.modules.production.exception.BandParameterException;

import java.util.List;

public interface BandService {
    /**
     * return all bands
     * by default, sort result by band_id in ascending order
     * @return
     */
    List<BandDto> getAllBands() throws BandParameterException, BandBusinessException, BandNotFoundException;
    BandDto getBandById(String bandId) throws BandParameterException, BandBusinessException, BandNotFoundException;
    BandDto addBand(String band) throws BandParameterException, BandBusinessException, BandNotFoundException;
    void deleteBandById(String bandId) throws BandParameterException, BandBusinessException, BandNotFoundException;
}
