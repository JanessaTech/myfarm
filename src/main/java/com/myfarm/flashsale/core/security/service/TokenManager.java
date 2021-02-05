package com.myfarm.flashsale.core.security.service;

import com.myfarm.flashsale.core.security.domain.Token;
import com.myfarm.flashsale.core.security.exception.TokenException;

public interface TokenManager {
    /**
     * generate a token object iif name and password are matched
     * @param name which is actually a telPhone
     * @param password
     * @return
     * @throws TokenException
     */
    Token createToken(String name, String password) throws TokenException;

    /**
     * update TTL of the token to the access time
     * @param token old token
     * @return new token
     * @throws TokenException
     */
    Token refreshToken(Token token) throws TokenException;

    /**
     * remove a token from the in-memory store(redis)
     * @param token
     * @throws TokenException
     */
    void deleteToken(Token token) throws TokenException;
}
