package com.appframe.http.entity;

public class HttpResult{
	private int state;
	private String message;

	private String publicKey;
    private String sign;
    private String token;

    public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	@Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("sign=" + sign + " publicKey=" + publicKey + "token=" + token);
      
        return sb.toString();
    }
}
