package dao;

import java.util.List;

import pojos.Customer;


public interface CustomerDao {

	public List<Customer> displayCustomers();
	public Customer getCustomerById(int id);
}
