package bank.transaction;

import bank.account.Account;

public class CWTransaction{
	public Account cashWithdrawal(Account account, int amountToWithdraw) {
		double balance = account.getAccBalance();
		balance -= amountToWithdraw;
		account.setAccBalance(balance);
		return account;
	}
}
