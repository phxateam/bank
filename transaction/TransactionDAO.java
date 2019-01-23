package bank.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pkg1.PWGet;

public class TransactionDAO {
	public Connection getConnection() throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", PWGet.password);
		return con;
	}
	
	public void insertTransaction(Transaction t, String type, int accId) {
		try(PreparedStatement stat = getConnection().prepareStatement("INSERT INTO transaction VALUES(?, ?, ?, ?, ?)");
		){
			stat.setInt(1, t.getTransId());
			stat.setString(2, type);
			stat.setInt(3, accId);
			stat.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			stat.setDouble(5, t.getTransAmount());
			
			int updates = stat.executeUpdate();
			
			if(updates > 0)
				System.out.println(updates + " transaction record(s) updated");
			else
				System.out.println("No records updated");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int generateId() {
		int id = 1;
		
		try(Statement stat = getConnection().createStatement();
			ResultSet rs = stat.executeQuery("SELECT MAX(trans_id) FROM transaction");	
			){
			
			while(rs.next()) {
				id = rs.getInt(1);
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error connecting to database. Transactions cannot be created");
		}
		
		return id;
	}
}
