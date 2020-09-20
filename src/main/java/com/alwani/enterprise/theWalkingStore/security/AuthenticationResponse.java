package com.alwani.enterprise.theWalkingStore.security;

public class AuthenticationResponse {

	private final String jwt;
	
	

	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}



	public String getJwt() {
		return jwt;
	}
	
	
}
