package com.revature.service;

import java.util.List;

import com.revature.beans.Reim;

import Dao.ReimDAO;
import Dao.ReimDAOImpl;

public class ReimService {
	
	private ReimDAO rd = new ReimDAOImpl();

	public ReimService() {
		
	}
	
	public List<Reim> viewPendingReim(int eid, int status) {
		return rd.viewPendingReim(eid, status);
	}
	
	public boolean approveOrDeny(int value, int manid, int reimid) {
		return rd.approveOrDeny(value,manid,reimid);
	}
	
	public List<Reim> myPendingReim(int empid) {
		return rd.myPendingReim(empid);
	}
	
	public List<Reim> myResolvedEmployee() {
		return rd.myResolvedEmployee();
	}
	
	public List<Reim> resolvedRequest(int eid, int status) {
		return rd.resolvedRequest(eid, status);
	}
	
	public boolean submitReim(int eid,int balance, String details) {
		return rd.submitReim(eid, balance, details);
	}
	
	public List<Reim> singleEmp(int eid) {
		return rd.singleEmp(eid);
	}
	
}
