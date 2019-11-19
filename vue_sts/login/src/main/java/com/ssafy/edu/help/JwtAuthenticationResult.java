package com.ssafy.edu.help;


public class JwtAuthenticationResult {
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationResult(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

	@Override
	public String toString() {
		return "JwtAuthenticationResult [accessToken=" + accessToken + ", tokenType=" + tokenType + "]";
	}
    
}
