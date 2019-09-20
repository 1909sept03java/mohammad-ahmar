package beans;

public class AccountTable {
	private int id;
	private int bankId;
	private double balance;
	private double deposit;
	private double withdraw;
	
	
	public AccountTable(int id, int bankid, double balance, double deposit, double withdraw) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.bankId = bankid;
		this.balance = balance;
		this.deposit = deposit;
		this.withdraw = withdraw;
	}

	public AccountTable(int id2, int bid,double balnce) {
		// TODO Auto-generated constructor stub
		this.id = id2;
		this.bankId = bid;
		this.balance = balnce;
		
	}

	public AccountTable(int id2, int bid, float balnce, float dep) {
		// TODO Auto-generated constructor stub
		this.id = id2;
		this.bankId = bid;
		this.balance = balnce;
		this.deposit = dep;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", bankid=" + bankId + ", balance=" + balance + " +"
				+ "deposit= " + deposit +  " withdraw=" + withdraw + " ]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
}
