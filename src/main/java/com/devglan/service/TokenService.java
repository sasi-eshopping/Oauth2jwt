package com.devglan.service;

import java.util.List;

import com.devglan.model.Token;
import com.devglan.model.User;

public interface TokenService {
	
	    Token save(Token token);
	    List<Token> findAll();
	    Token findByAccessToken(String accessToken);
	    Token findByRefreshToken(String refreshToken);

}
