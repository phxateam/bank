package bank;

import bank.customer.Customer;

public class TransactionServices 
{
	public void CW(Customer objCustomer,int amountToWithdraw)
	{
		//objCustomer.custAccount.accBalance = objCustomer.custAccount.accBalance - amountToWithdraw;
		
		objCustomer.getCustAccount().setAccBalance(objCustomer.getCustAccount().getAccBalance() - amountToWithdraw);
	}
	public void CD(Customer objCustomer,int amountToDeposit)
	{
		objCustomer.getCustAccount().setAccBalance(objCustomer.getCustAccount().getAccBalance() + amountToDeposit);		 
	}
}