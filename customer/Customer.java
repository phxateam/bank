package bank.customer;

import java.util.ArrayList;
import java.util.List;

import bank.account.Account;

public class Customer {
	private int custId;
	private String custName;
	private String custPhone;
	private String custEmail;
	private Address custAddress;
	ArrayList<Account> custAccounts;

	public void createCustomer(int custId, String custName, String custPhone, 
								String custEmail, Account custAccount, Address custAddress) {
		this.custAccounts = new ArrayList<Account>();
		
		this.custId = custId;
		this.custName = custName;
		this.custPhone = custPhone;
		this.custEmail = custEmail;
		this.custAccounts.add(custAccount);
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

	public Account getCustAccount(int accId) {
		for(Account acc: custAccounts)
			if(acc.getAccId() == accId)
				return acc;
		
		return null;
	}
	
	public ArrayList<Account> getCustAccounts() {
		return custAccounts;
	}

	public void addCustAccount(Account custAccount) {
		this.custAccounts.add(custAccount);
	}

	public Address getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(Address custAddress) {
		this.custAddress = custAddress;
	}
	
}
