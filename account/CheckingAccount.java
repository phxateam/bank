package bank.account;

public class CheckingAccount extends Account {
	private final float ir = 2; //interest rate
	private final float creditLimit = 2000; //credit limit
	
/*	public void createAccount(int accId, double accBalance) {
		super.createAccount(accId, accBalance);
		
	}
*/
	
	public void printAccountDetails() {
		super.printAccountDetails();
		System.out.println("Interest Rate: " + ir);
		System.out.println("Credit Limit: " + creditLimit);
	}
	
	public String getAccType() {
		return "C";
		
	}
}
