package bank.transaction;

import bank.customer.Customer;

public class CDTransaction extends Transaction{
	
	public void CD(Customer objCustomer,int amountToDeposit)
	{
		objCustomer.getCustAccount().setAccBalance(objCustomer.getCustAccount().getAccBalance() + amountToDeposit);		 
	}
}
