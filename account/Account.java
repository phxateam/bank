package bank.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pkg1.PWGet;

public abstract class Account {
	private int accId;
	private double accBalance;
	//ArrayList<Transaction> transactions;
	
	public void createAccount(int accId, double accBalance) {
		this.accId = accId;
		this.accBalance = accBalance;
		//transactions = new ArrayList<Transaction>();
	}
	public Connection getConnection() throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", PWGet.password);
		return con;
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
	
	public void updateAccBalance(double accBalance) {		
		try(
				PreparedStatement stat = getConnection().prepareStatement("UPDATE account SET balance = ? WHERE account_id = ?");
			){
				stat.setDouble(1, accBalance);
				stat.setInt(2, accId);
				
				int updates = stat.executeUpdate();
				
				if(updates > 0)
					System.out.println(updates + " account record(s) updated");
				else
					System.out.println("No records updated");
			}
		catch(SQLException e) {
				System.out.println(e.getMessage());
		}
		
		setAccBalance(accBalance);
	}
/*	
	public Transaction getTransaction(int transId) {
		for(Transaction t : transactions)
			if(t.getTransId() == transId)
				return t;
		return null;
	}
	
	public void addTransaction(Transaction t) {
		transactions.add(t);
	}*/
	
}
