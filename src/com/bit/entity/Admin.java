package com.bit.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class Admin {
	@NotEmpty
	private String userName;
	@NotEmpty
	private String passWord;
	private String name;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String userName, String passWord, String name) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
