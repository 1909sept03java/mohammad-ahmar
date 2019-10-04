package com.revature.beans;

public class Employee {
	private int eID;
	private String eUser;
	private String ePass;
	private int mID;
	
	
	public Employee(int eID, String eUser, String ePass, int mID) {
		super();
		this.eID = eID;
		this.eUser = eUser;
		this.ePass = ePass;
		this.mID = mID;
	}
	
	public Employee(String user, String pass) {
		// TODO Auto-generated constructor stub
		this.eUser = user;
		this.ePass = pass;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return eID;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + eID + ", username=" + eUser + ", password=" + ePass + ", managerid=" + mID + "]";
	}


	public void setID(int eID) {
		this.eID = eID;
	}
	public String getUser() {
		return eUser;
	}
	public void setUser(String eUser) {
		this.eUser = eUser;
	}
	public String getPass() {
		return ePass;
	}
	public void setPass(String ePass) {
		this.ePass = ePass;
	}
	public int getMid() {
		return mID;
	}
	public void setMid(int mID) {
		this.mID = mID;
	}
	
}
