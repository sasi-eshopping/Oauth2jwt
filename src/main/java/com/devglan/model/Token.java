package com.devglan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Token {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
	@Column
	private String accessToken;
	@Column
	private String refreshToken;
	@Column
	private long expiration;
	@Column
    private long invalidtime;

	public long getInvalidtime() {
		return invalidtime;
	}

	public void setInvalidtime(long invalidtime) {
		this.invalidtime = invalidtime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Long getExpiration() {
		return expiration;
	}

	public void setExpiration(Long expiration) {
		this.expiration = expiration;
	}

	
    
	
}
