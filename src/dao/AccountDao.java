package dao;

import pojos.Account;


public interface AccountDao {
	
	public Account getAccountDetailsByAccId(int id);
	public Account getAccountDetailsByCustId(int id);
	
}
