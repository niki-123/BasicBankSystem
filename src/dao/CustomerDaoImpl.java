package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Customer;


import static utils.DBUtils.*;

public class CustomerDaoImpl implements CustomerDao {

	private Connection cn;
	private PreparedStatement pst1, pst2;

	public CustomerDaoImpl() {
		try {
			cn = getConnection();
			pst1 = cn.prepareStatement("select * from CUSTOMER");
			pst2 = cn.prepareStatement("select * from CUSTOMER where customer_id=?");

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
	public List<Customer> displayCustomers() {
		System.out.println("in display customers");
		List<Customer> l1 = new ArrayList<Customer>();
		try {

			ResultSet rst = pst1.executeQuery();

			while (rst.next()) {
				l1.add(new Customer(rst.getInt(1), rst.getString(7), rst.getString(2), rst.getString(3),
						rst.getString(4), rst.getString(5), rst.getString(6)));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return l1;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer c = null;
		try {

			pst2.setInt(1, id);
			
			ResultSet rst = pst2.executeQuery();

			if (rst.next()) {
				c = new Customer(rst.getInt(1),rst.getString(7), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getString(6));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return c;
	}
}
