package com.bbd.server;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable
{
	private String uName, email, pWord;
	
	public UserBean() {}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getpWord() {
		return pWord;
	}

	public void setpWord(String pWord) {
		this.pWord = pWord;
	}
	
	
}
