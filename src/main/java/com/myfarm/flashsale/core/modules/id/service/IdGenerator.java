package com.myfarm.flashsale.core.modules.id.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.myfarm.flashsale.core.modules.id.exception.IdException;

import java.util.List;
import java.util.UUID;

public interface IdGenerator {
    /**
     * create UUID using id
     * @param id
     * @return
     */
    UUID getIDFromString(String id) throws IdException;

    /**
     * Generate a list of UUID using ids
     * ids consists at least one UUID string using "," as a splitter
     * @param ids
     * @return
     */
    List<Object> getIDsFromString(String ids) throws IdException;

    /**
     * generate a new UUID
     * @return
     */
    UUID getNextID() throws IdException;
}
