package com.myfarm.flashsale.core.security.service.imp;

import com.myfarm.flashsale.core.modules.common.Constants;
import com.myfarm.flashsale.core.security.domain.Token;
import com.myfarm.flashsale.core.security.exception.TokenException;
import com.myfarm.flashsale.core.security.service.TokenManager;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component("auth2TokenManager")
public class Auth2TokenManager implements TokenManager {
    @Value("${server.servlet.contextPath}")
    private String contextPath;
    private final Logger logger  = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private RestTemplate restTemplate;

    private String getAuth2ServerURL(){
        return String.format("http://127.0.0.1:8080%s/oauth/token", contextPath);
    }

    @Override
    public Token createToken(String name, String password) throws TokenException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String credentials = Constants.CLIENT_ID + ":" + Constants.CLIENT_SECRET;
        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
        headers.add(Constants.HEADER_KEY_AUTHORIZATION, Constants.PREFIX_AUTHORIZATION + encodedCredentials);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add(Constants.GRANT_TYPE_KEY, Constants.GRANT_TYPE[0]);
        map.add(Constants.USERNAME, name);
        map.add(Constants.PASSWORD, password);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<Token> response = null;
        try{
            String url = getAuth2ServerURL();
            logger.info(String.format("auth2 server token url: %s", url));
            response = restTemplate.exchange(url, HttpMethod.POST,entity,Token.class);
        }catch (HttpClientErrorException ex){
            throw new TokenException(ex.getMessage(), ex);
        }catch (RestClientException ex){
            throw new TokenException(ex.getMessage(), ex);
        }catch (Exception ex){
            throw new TokenException(ex.getMessage(), ex);
        }
        return response.getBody();
    }

    @Override
    public Token refreshToken(Token token) throws TokenException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String credentials = Constants.CLIENT_ID + ":" + Constants.CLIENT_SECRET;
        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
        headers.add(Constants.HEADER_KEY_AUTHORIZATION, Constants.PREFIX_AUTHORIZATION + encodedCredentials);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add(Constants.GRANT_TYPE_KEY, Constants.GRANT_TYPE[1]);
        map.add(Constants.REFRESH_TOKEN, token.getRefresh_token());
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<Token> response = null;
        try{
            response = restTemplate.exchange(Constants.AUTH2_TOKEN_URL, HttpMethod.POST,entity,Token.class);
        }catch (HttpClientErrorException ex){
            throw new TokenException(ex.getMessage(), ex);
        }catch (RestClientException ex){
            throw new TokenException(ex.getMessage(), ex);
        }catch (Exception ex){
            throw new TokenException(ex.getMessage(), ex);
        }
        return response.getBody();
    }

    @Override
    public void deleteToken(Token token) throws TokenException {

    }
}
