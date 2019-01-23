package bank.customer;

import java.util.ArrayList;

import bank.account.Account;
import bank.account.AccountServices;
public class Customer {
	private int custId;
	private String custName;
	private String custPhone;
	private String custEmail;
	private Address custAddress;
	private AccountServices accServ = new AccountServices();

	public void createCustomer(int custId, String custName, String custPhone, 
								String custEmail, Account custAccount, Address custAddress) {
		//this.custAccounts = new ArrayList<Account>();
		
		this.custId = custId;
		this.custName = custName;
		this.custPhone = custPhone;
		this.custEmail = custEmail;
		//this.custAccounts.add(custAccount);
		this.custAddress = custAddress;
	}
	
	public void createCustomer(int custId, String custName, String custPhone, 
			String custEmail, ArrayList<Account> custAccounts, Address custAddress) {
		
		this.custId = custId;
		this.custName = custName;
		this.custPhone = custPhone;
		this.custEmail = custEmail;
		//this.custAccounts = custAccounts;
		this.custAddress = custAddress;
	}
	
	public void updateCustomerDetails() {
		
	}
	
	public void updateCustomerAddress() {
		
	}
	
	public void updateCustomerAccountDetails() {
		
	}
	
	public void printCustomerDetails() {
		System.out.println("Customer ID: " + custId);
		System.out.println("Customer Name: " + custName);
		System.out.println("Customer Phone: " + custPhone);
		System.out.println("Customer Email: " + custEmail);
		custAddress.printAddress();
		
		ArrayList<Account> custAccounts = accServ.getCustAccounts(custId);
		
		for(Account acc: custAccounts)
			acc.printAccountDetails();
	}
	
	public int getCustID() {
		return custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public Address getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(Address custAddress) {
		this.custAddress = custAddress;
	}
	
}
