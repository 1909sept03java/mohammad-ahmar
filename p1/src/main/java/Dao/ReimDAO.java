package Dao;

import java.util.List;

import com.revature.beans.Reim;

public interface ReimDAO {

	public List<Reim> getEmpId(int id);
	public List<Reim> viewPendingReim(int eid, int status);
	//--------------------
	public List<Reim> resolvedRequest(int eid, int status);
	public boolean approveOrDeny(int value, int manid, int reimid);
	public List<Reim> myPendingReim(int empid);
	public List<Reim> myResolvedEmployee(); 
	public boolean submitReim(int eid,int balance, String details);
	public List<Reim> singleEmp(int eid);
}
