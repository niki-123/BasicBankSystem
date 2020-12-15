package dao;

import java.util.List;

import pojos.Customer;

public interface TransactionDao {
	
	public String addTransaction(int from_cust,List<String> toCust,int amount);
	
	
	
}
