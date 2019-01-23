package bank.account;

import java.util.ArrayList;

import bank.transaction.Transaction;

public abstract class Account {
	private int accId;
	private double accBalance;
	ArrayList<Transaction> transactions;
	
	public void createAccount(int accId, double accBalance) {
		this.accId = accId;
		this.accBalance = accBalance;
		transactions = new ArrayList<Transaction>();
	}
	
	public void printAccountDetails() {
		System.out.println("Account ID: " + accId);
		System.out.println("Account Balance: " + accBalance);
	}
	
	public void listAccount() {
		System.out.println(accId + ": " + getAccType());
	}
	
	public abstract String getAccType();
	
	public void updateBalance() {
		
	}
	
	public void updateAccountDetails() {
	}

	public int getAccId() {
		return accId;
	}
	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	
	public Transaction getTransaction(int transId) {
		for(Transaction t : transactions)
			if(t.getTransId() == transId)
				return t;
		return null;
	}
	
	public void addTransaction(Transaction t) {
		transactions.add(t);
	}
	
}
