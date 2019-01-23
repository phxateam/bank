package bank.transaction;

import java.util.Date;
import bank.account.Account;

public class TransactionServices {
//aspect oriented programming
	TransactionDAO dao = new TransactionDAO();
	
	public Account cashDeposit(Account account, double amountToDeposit) {
		Transaction deposit = new Transaction(++Transaction.currId, amountToDeposit, new Date(), "CD");
		double balance = account.getAccBalance();
		balance += amountToDeposit;
		insertTransaction(deposit, "CD", account.getAccId());
		account.updateAccBalance(balance);
		return account;
	}
	
	public Account cashWithdrawal(Account account, double amountToWithdraw) {
		Transaction withdrawal = new Transaction(++Transaction.currId, amountToWithdraw, new Date(), "CW");
		double balance = account.getAccBalance();
		balance -= amountToWithdraw;
		insertTransaction(withdrawal, "CD", account.getAccId());
		account.updateAccBalance(balance);
		return account;
	}
	
	public void insertTransaction(Transaction t, String type, int accId) {
		dao.insertTransaction(t, type, accId);
	}
	
	public int generateId() {
		return dao.generateId();
	}

}
