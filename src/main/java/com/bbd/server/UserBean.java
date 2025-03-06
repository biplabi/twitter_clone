package com.bbd.server;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable
{
	private String uName, email, pWord;
	private int uId;
	private byte[] profilePic;
	
	public UserBean() {}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

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
	
	public byte[] getProfilePic()
	{
		return profilePic;
	}
	
	public void setProfilePic(byte[] profilePic)
	{
		this.profilePic = profilePic;
	}
	
	
}
