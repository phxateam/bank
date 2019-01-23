package bank.customer;

import java.util.HashMap;
import bank.account.AccountServices;


public class CustomerServices {
	AccountServices accServ = new AccountServices();
	CustomerDAO dao = new CustomerDAO();
	
	public void insertCustomer(Customer c) {
		dao.insertCustomer(c);
	}	
	
	public Customer getCust(int cust_id) {
		return dao.getCust(cust_id);
	}
	
	public HashMap<Integer, Customer> getAllCustomers() {
		return dao.getAllCustomers();
		
	}
}
