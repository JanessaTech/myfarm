package com.myfarm.flashsale.core.modules.id.service.imp;

import com.myfarm.flashsale.core.modules.id.exception.IdException;
import com.myfarm.flashsale.core.modules.id.service.IdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class IdGeneratorImp implements IdGenerator {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;

    @Override
    public UUID getIDFromString(String id) throws IdException {
        UUID uuid = null;
        try{
            uuid = UUID.fromString(id);
        }catch(IllegalArgumentException ex){
            throw new IdException(this.messageSource.getMessage("uuid.invalid", new Object[]{id}, Locale.getDefault()));
        }
        return uuid;
    }

    @Override
    public List<Object> getIDsFromString(String ids) throws IdException {
        String[] ids_arr = ids.split(",");
        List<Object> uuids = new ArrayList<Object>();
        for(String id : ids_arr){
            try{
                uuids.add(UUID.fromString(id));
            }catch (IllegalArgumentException ex){
                throw new IdException(this.messageSource.getMessage("uuid.multiple.invalid", new Object[]{ids, id}, Locale.getDefault()));
            }
        }
        return uuids;
    }

    @Override
    public UUID getNextID() throws IdException {
        return null;
    }
}
