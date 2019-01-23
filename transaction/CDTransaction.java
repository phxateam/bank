package bank.transaction;

import bank.account.Account;

public class CDTransaction{
	
	public Account cashDeposit(Account account, int amountToDeposit) {
		double balance = account.getAccBalance();
		balance += amountToDeposit;
		account.setAccBalance(balance);
		return account;
	}
}
