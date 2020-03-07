package com.kalwador.security.commons;

import com.kalwador.security.commons.account.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

@Configuration
@Component
public class CustomTokenEnhancer extends JwtAccessTokenConverter {

    @Value("${authentication.oauth.tokenValidity.access}")
    private String accessTokenValidity;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        var additionalInfo = new HashMap<String, Object>();
        var account = (Account) authentication.getPrincipal();
        additionalInfo.put("userId", account.getId());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        ((DefaultOAuth2AccessToken) accessToken).setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(accessTokenValidity)));
        return super.enhance(accessToken, authentication);
    }
}
