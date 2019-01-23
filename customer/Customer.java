package bank.customer;

import bank.account.Account;

public class Customer {

	private int custId;
	private String custName;
	private String custPhone;
	private String custEmail;
	private Account custAccount;
	private Address custAddress;
		
	public void createCustomer(int custId,String custName,String custPhone,
			String custEmail,Address custAddress,Account custAccount)
	{
		this.custId = custId;
		this.custName = custName;
		this.custPhone=custPhone;
		this.custEmail = custEmail;
		this.custAccount = custAccount;
		this.custAddress = custAddress;
	}

	public void printCustomerDetails()
	{
		System.out.println("Customer ID : " + custId);
		System.out.println("Customer Name : " + custName);
		System.out.println("Customer Email : " + custEmail);
		System.out.println("Customer Phone : " + custPhone);
		
		custAddress.printAddress();
		custAccount.printAccountDetails();
	}
	public void updateCustomerDetails()
	{
		
	}
	public void updateCustomerAddress()
	{
		
	}
	public void updateCustomerAccountDetails()
	{
		
	}

	public Account getCustAccount() {
		return custAccount;
	}

	public void setCustAccount(Account custAccount) {
		this.custAccount = custAccount;
	}

	public Address getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(Address custAddress) {
		this.custAddress = custAddress;
	}
}