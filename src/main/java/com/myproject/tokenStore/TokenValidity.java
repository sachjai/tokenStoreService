package com.myproject.tokenStore;

public class TokenValidity {
	private Boolean tokenValid;

	public Boolean getTokenValid() {
		return tokenValid;
	}

	public void setTokenValid(Boolean tokenValid) {
		this.tokenValid = tokenValid;
	}

	@Override
	public String toString() {
		return "TokenValidity [tokenValid=" + tokenValid + "]";
	}

	public TokenValidity(Boolean tokenValid) {
		super();
		this.tokenValid = tokenValid;
	}

	public TokenValidity() {
	}
	

}
