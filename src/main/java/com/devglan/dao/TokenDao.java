package com.devglan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devglan.model.Token;
import com.devglan.model.User;

@Repository
public interface TokenDao extends CrudRepository <Token, Long> {
	
	Token findByAccessToken(String accessToken);
	Token findByRefreshToken(String refreshToken);

}
