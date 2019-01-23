package bank.transaction;

import bank.customer.Customer;

public class CWTransaction extends Transaction 
{
	public void CW(Customer objCustomer,int amountToWithdraw)
	{
		objCustomer.getCustAccount().setAccBalance(objCustomer.getCustAccount().getAccBalance() - amountToWithdraw);
	}
}