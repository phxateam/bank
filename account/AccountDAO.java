package bank.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pkg1.PWGet;

public class AccountDAO {
	public Connection getConnection() throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", PWGet.password);
		return con;
	}
	
	public ArrayList<Account> getAllAccounts(){
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		try(
				Statement stat = getConnection().createStatement();
				ResultSet rs = stat.executeQuery("SELECT * FROM ACCOUNT");
			)
		{
	
			while(rs.next()) {
				Account acc = null;
				char accType = rs.getString(3).toUpperCase().charAt(0);
				if(accType == 'S')
					acc = new SavingAccount();
				else
					acc = new CheckingAccount();
				
				acc.createAccount(rs.getInt(1), rs.getDouble(2));
				accounts.add(acc);
			}
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		return accounts;
	}
	
	public Account getCustAccount(int acc_id) {
		Account acc = null;;
		try(
				PreparedStatement stat = getConnection().prepareStatement("SELECT * FROM ACCOUNT WHERE ACCOUNT_ID = ?");
			)
		{
			stat.setInt(1, acc_id);
			ResultSet rs = stat.executeQuery();
			
			
			while(rs.next()) {
				char accType = rs.getString(3).toUpperCase().charAt(0);
				if(accType == 'S')
					acc = new SavingAccount();
				else
					acc = new CheckingAccount();
				
				acc.createAccount(rs.getInt(1), rs.getDouble(2));
			}
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		return acc;
	}
	
	public ArrayList<Account> getCustAccounts(int cust_id) {
		ArrayList<Account> custAccounts = new ArrayList<Account>();
		try(
				PreparedStatement stat = getConnection().prepareStatement("SELECT * FROM ACCOUNT WHERE CUST_ID = ?");
			)
		{
			stat.setInt(1, cust_id);
			ResultSet rs = stat.executeQuery();
			
			
			while(rs.next()) {
				char accType = rs.getString(3).toUpperCase().charAt(0);
				Account acc = new CheckingAccount();
				if(accType == 'S')
					acc = new SavingAccount();
				
				acc.createAccount(rs.getInt(1), rs.getDouble(2));
				custAccounts.add(acc);
			}
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		return custAccounts;
	}
		
	public void insertAccount(Account a, int custId) {
		try(
				PreparedStatement stat =  getConnection().prepareStatement("INSERT INTO account VALUES(?, ?, ?, ?, ?)");
			)
		{
			
			int interest = a.getAccType().equals("C") ? 2 : 5;
				
			stat.setInt(1, a.getAccId());
			stat.setDouble(2, a.getAccBalance());
			stat.setString(3, a.getAccType());
			stat.setInt(4, custId);
			stat.setInt(5,  interest);
			
			int updates = stat.executeUpdate();
			
			if(updates > 0)
				System.out.println(updates + " account record(s) updated");
			else
				System.out.println("No records updated");
			stat.close();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
