package bank.transaction;

import java.util.Date;

public class Transaction {
	
	public static int currId = new TransactionServices().generateId();
	int transId;
	double transAmount;
	Date transDate;
	String transType;
	
	public Transaction(int transId, double transAmount, Date transDate, String transType) {
		this.transId = transId;
		this.transAmount = transAmount;
		this.transDate = transDate;
		this.transType = transType;
	}
	
	public Transaction() {
		
	}

	public int getTransId() {
		return transId;
	}

	public double getTransAmount() {
		return transAmount;
	}

	public Date getTransDate() {
		return transDate;
	}

	public String getTransType() {
		return transType;
	}
}
