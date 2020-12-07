package com.demo.bean;

public class User {
	
	
	private String pname;
	private String pass;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String pname, String pass) {
		super();
		this.pname = pname;
		this.pass = pass;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "User [pname=" + pname + ", pass=" + pass + "]";
	}
	
	
	
}
