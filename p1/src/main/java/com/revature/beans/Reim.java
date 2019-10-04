package com.revature.beans;

public class Reim {

	private int rId;
	private int eId;
	private double balance;
	private String details;
	private int check;
	private int manageId;
	private int mangerResId;
	
	public Reim(int rid,int eId,double balance2, String details2, int check2,int manageId,int resid) {
		// TODO Auto-generated constructor stub
		this.rId = rid;
		this.eId = eId;
		this.balance = balance2;
		this.details = details2;
		this.check = check2;
		this.manageId = manageId;
		this.mangerResId = resid;
	}
	

	@Override
	public String toString() {
		return "Reim [rid=" + rId + ", eid=" + eId + ", balance=" + balance + ", details=" + details + ", check=" + check
				+ ", manageeId=" + manageId + "mangerResId="+ mangerResId +"]";
	}
	
	public Reim() {
		// TODO Auto-generated constructor stub
		super();
	}

	

	public Reim(int reimId,double balance2, String details2, int check2) {
		// TODO Auto-generated constructor stub
		this.rId = reimId;
		this.balance = balance2;
		this.details = details2;
		this.check = check2;
	}


	public Reim(double balance2, String details2, int check2) {
		// TODO Auto-generated constructor stub
		this.balance = balance2;
		this.details = details2;
		this.check = check2;
	}

	public Reim(int reimId, int eId2, double balance2, String details2, int check2) {
		// TODO Auto-generated constructor stub
		this.rId = reimId;
		this.eId = eId2;
		this.balance = balance2;
		this.details = details2;
		this.check = check2;
	}

	public int getManageId() {
		return manageId;
	}

	public void setManageId(int manageId) {
		this.manageId = manageId;
	}

	public int getMangerResId() {
		return mangerResId;
	}

	public void setMangerResId(int mangerResId) {
		this.mangerResId = mangerResId;
	}

	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	
	
}
