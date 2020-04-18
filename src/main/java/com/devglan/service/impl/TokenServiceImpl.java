package com.devglan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.devglan.dao.TokenDao;
import com.devglan.dao.UserDao;
import com.devglan.model.Token;
import com.devglan.service.TokenService;


@Service(value = "tokenService")
public class TokenServiceImpl implements TokenService{

	@Autowired
	private TokenDao tokenDao;
	
	
	
	public Token save (Token token)
	{
		
		return tokenDao.save(token);
	}



	@Override
	public List<Token> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Token findByAccessToken(String accessToken) {
		// TODO Auto-generated method stub
		//return null;
		return tokenDao.findByAccessToken(accessToken);
	}



	@Override
	public Token findByRefreshToken(String refreshToken) {
		// TODO Auto-generated method stub
		//return null;
		return tokenDao.findByRefreshToken(refreshToken);
	}

	
}
