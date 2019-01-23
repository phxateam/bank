package bank.account;

import java.util.ArrayList;

public class AccountServices {
	
	AccountDAO dao = new AccountDAO();
	
	public ArrayList<Account> getAllAccounts(){
		return dao.getAllAccounts();
	}
	
	public Account getCustAccount(int acc_id) {
		return dao.getCustAccount(acc_id);
	}
	
	public ArrayList<Account> getCustAccounts(int cust_id) {
		return dao.getCustAccounts(cust_id);
	}
		
	public void insertAccount(Account a, int custId) {
		dao.insertAccount(a, custId);
	}
}
