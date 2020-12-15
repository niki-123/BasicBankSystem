package pojos;

public class Account {
	public int accid;
	public int currBal;
	public String accnum, bankName;
	public Account(int accid, int currBal, String accname, String bankName) {
		super();
		this.accid = accid;
		this.currBal = currBal;
		this.accnum = accname;
		this.bankName = bankName;
	}
	public int getAccid() {
		return accid;
	}
	public void setAccid(int accid) {
		this.accid = accid;
	}
	public int getCurrBal() {
		return currBal;
	}
	public void setCurrBal(int currBal) {
		this.currBal = currBal;
	}
	public String getAccname() {
		return accnum;
	}
	public void setAccname(String accname) {
		this.accnum = accname;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Override
	public String toString() {
		return "Account [accid=" + accid + ", currBal=" + currBal + ", accnum=" + accnum + ", bankName=" + bankName
				+ "]";
	}
	
	
}
