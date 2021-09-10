package com.pack;

public class User {
	private String uname,password,ctype,bal;

	public User() {
		super();
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getBal() {
		return bal;
	}

	public void setBal(String bal) {
		this.bal = bal;
	}

	public User(String uname, String password, String ctype, String bal) {
		super();
		this.uname = uname;
		this.password = password;
		this.ctype = ctype;
		this.bal = bal;
	}

}
