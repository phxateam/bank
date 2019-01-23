package bank.transaction;

import java.util.Date;

import bank.account.Account;

public class TransactionServices {
//aspect oriented programming
	public Account cashDeposit(Account account, double amountToDeposit) {
		Transaction deposit = new Transaction(++Transaction.currId, amountToDeposit, new Date(), "CD");
		account.addTransaction(deposit);
		double balance = account.getAccBalance();
		balance += amountToDeposit;
		account.setAccBalance(balance);
		return account;
	}
	
	public Account cashWithdrawal(Account account, double amountToWithdraw) {
		Transaction withdrawal = new Transaction(++Transaction.currId, amountToWithdraw, new Date(), "CW");
		account.addTransaction(withdrawal);
		double balance = account.getAccBalance();
		balance -= amountToWithdraw;
		account.setAccBalance(balance);
		return account;
	}

}
