package dao;

import static utils.DBUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.Account;


public class AccountDaoImpl implements AccountDao{
	private Connection cn;
	private PreparedStatement pst1, pst2;

	public AccountDaoImpl() {
		try {
			cn = getConnection();
			pst1 = cn.prepareStatement("select * from account where account_id=?");
			pst2 = cn.prepareStatement("select * from account where customer_id=?");

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
	public Account getAccountDetailsByAccId(int id) {
		Account a = null;
		try {

			pst1.setInt(1, id);
			
			ResultSet rst = pst2.executeQuery();

			if (rst.next()) {
				a = new Account(rst.getInt(1), rst.getInt(4), rst.getString(2), rst.getString(3));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return a;
	}

	@Override
	public Account getAccountDetailsByCustId(int id) {
		Account a = null;
		try {

			pst2.setInt(1, id);
		
			ResultSet rst = pst2.executeQuery();
		
			if (rst.next()) {
				System.out.println(rst.getInt(1));
				a = new Account(rst.getInt(1), rst.getInt(4), rst.getString(2), rst.getString(3));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return a;
	}

}
