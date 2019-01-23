package bank.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import bank.account.Account;
import bank.account.AccountServices;
import pkg1.PWGet;

public class CustomerDAO {
	AccountServices accServ = new AccountServices();
	
	public Connection getConnection() throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", PWGet.password);
		return con;
	}
	
	public void insertCustomer(Customer c) {
		try(
				PreparedStatement stat = getConnection().prepareStatement("INSERT INTO customer VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
			)
		{
			stat.setInt(1, c.getCustID());
			stat.setString(2, c.getCustName());
			stat.setString(3, c.getCustPhone());
			stat.setString(4, c.getCustAddress().getStreet());
			stat.setString(5,  c.getCustAddress().getCity());
			stat.setString(6, c.getCustAddress().getState());
			stat.setString(7, c.getCustAddress().getPincode());
			stat.setString(8, c.getCustEmail());
			
			int updates = stat.executeUpdate();
			
			if(updates > 0)
				System.out.println(updates + " customer record(s) updated");
			else
				System.out.println("No records updated");
			stat.close();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}	
	
	public Customer getCust(int cust_id) {
		Customer cust = null;
		try(
				PreparedStatement stat = getConnection().prepareStatement("SELECT * FROM CUSTOMER WHERE CUST_ID = ?");
			)
		{
			stat.setInt(1, cust_id);
			ResultSet rs = stat.executeQuery();
			
			
			while(rs.next()) {
				cust = new Customer();
				Address add = new Address();
				add.createAddress(rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				
				ArrayList<Account> custAccs = accServ.getCustAccounts(cust_id);
				
				cust.createCustomer(cust_id, rs.getString(2), rs.getString(3), rs.getString(8), custAccs, add);
			}
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		return cust;
	}
	
	public HashMap<Integer, Customer> getAllCustomers() {
		HashMap<Integer, Customer> customers = new HashMap<Integer, Customer>();
		try(
				Statement stat = getConnection().createStatement();
				ResultSet rs = stat.executeQuery("SELECT * FROM CUSTOMER");
			)
		{
			
			while(rs.next()) {
				Address add = new Address();
				add.createAddress(rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				
				int cust_id = rs.getInt(1);
				ArrayList<Account> custAccs = accServ.getCustAccounts(cust_id);
				
				Customer cust = new Customer();
				cust.createCustomer(cust_id, rs.getString(2), rs.getString(3), rs.getString(8), custAccs, add);
				customers.put(cust.getCustID(), cust);
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return customers;
	}
}
