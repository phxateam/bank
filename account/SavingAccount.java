package bank.account;

public class SavingAccount extends Account {
	private final float ir = 5; //interest rate
	
	/*public void createAccount(int accId, double accBalance) {
		super.createAccount(accId, accBalance);
		
	}*/
	
	public void printAccountDetails() {
		super.printAccountDetails();
		System.out.println("Interest Rate: " + ir);
	}
	
	public String getAccType() {
		return "Savings";
	}
}
