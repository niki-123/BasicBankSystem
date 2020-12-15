package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pojos.Account;
import pojos.Customer;

import static utils.DBUtils.*;

public class TransactionDaoImpl implements TransactionDao {

	private Connection cn;
	private PreparedStatement pst1, pst2;

	public TransactionDaoImpl() {
		try {
			cn = getConnection();
			pst1 = cn.prepareStatement("INSERT INTO transactions VALUES(default,?,?,?,?)");
			pst2 = cn.prepareStatement("UPDATE ACCOUNT SET current_balance = ? WHERE customer_id = ?");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cleanup() {

		try {
			if (pst1 != null)
				pst1.close();

			if (pst2 != null)
				pst2.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public String addTransaction(int from_cust, List<String> toCust, int amount) {
		try {
			String toCustomer = Arrays.asList(toCust).toString();

			// Add transactions in transfer table
			java.util.Date utilDate = new java.util.Date();
			java.sql.Timestamp sqlTS = new java.sql.Timestamp(utilDate.getTime());

			pst1.setInt(1, from_cust);
			pst1.setString(2, toCustomer);
			pst1.setInt(3, amount);
			pst1.setTimestamp(4, sqlTS);

			int i = pst1.executeUpdate();
			
			doTransfer(from_cust,toCust,amount);
			
			
			if (i == 0)
				return "Transfer failed. Please try Again!!";
			else
				return "Amount transferred successfully!!!";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Exit";
	}

	public void doTransfer(int from_cust, List<String> toCust, int amount) {
		
		try {
		AccountDaoImpl acc = new AccountDaoImpl();
		int ids;
		int currbal2,currbal1 ;
		List<Integer> idd = new ArrayList<Integer>();
		for (String s : toCust) {
			ids = Integer.parseInt(s);
			
			//deduct money to_cust
			Account a2 = acc.getAccountDetailsByCustId(from_cust);
			currbal2 = a2.getCurrBal();
			
			System.out.println(currbal2);
			currbal2 = currbal2 - amount;
			System.out.println(currbal2);
			
			pst2.setInt(1, currbal2);
			pst2.setInt(2, from_cust);
			
			
			pst2.executeUpdate();
			
			
			//add money from_cust
			Account a1 = acc.getAccountDetailsByCustId(ids);
			currbal1= a1.getCurrBal();
			
			System.out.println(currbal1);
			currbal1 = currbal1 + amount;
			System.out.println(currbal1);

			pst2.setInt(1, currbal1);
			pst2.setInt(2, ids);
			
			
			pst2.executeUpdate();
			
		}

		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
