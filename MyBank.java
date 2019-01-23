package bank;

import bank.account.SavingAccount;
import bank.customer.Address;
import bank.customer.Customer;

import java.util.*;

public class MyBank {

	public static void main(String s[])
	{
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Customer ID, Name , Phone and Email...");
		int custId = scanner.nextInt();
		String custName = scanner.next();
		String custPhone =scanner.next();
		String custEmail = scanner.next();
		
		System.out.println("Enter Customer Address Details ...");
		String street = scanner.next();
		String state = scanner.next();
		String city = scanner.next();
		String pincode = scanner.next();
		
		System.out.println("Enter Customer Account Details ...");
		int accId = scanner.nextInt();
		double accBalance = scanner.nextDouble();
		
		
		Address custAddress = new Address();
		custAddress.createAddress(street, state, city, pincode);
		
		SavingAccount custAccount = new SavingAccount();
		custAccount.createAccount(accId, accBalance);
		
		Customer objCustomer = new Customer();
		objCustomer.createCustomer(custId, custName, custPhone, custEmail, custAddress, custAccount);
		
		objCustomer.printCustomerDetails();

		TransactionServices objTransactionService = new TransactionServices();

		while(true)
		{
			System.out.println("------------Welcome to My Bank-------------------");
			System.out.println("-------------------------------------------------");
			System.out.println("---------1.CW----------");
			System.out.println("---------2.CD----------");
			System.out.println("-------------------------------------------------");
			
			System.out.println("Enter your choice of transaction....");
			int choice = scanner.nextInt();
			
			switch(choice)
			{
				case 1:
					System.out.println("Enter amount to withdraw..");
					int amountToWithdraw = scanner.nextInt();
					objTransactionService.CW(objCustomer, amountToWithdraw);
					objCustomer.printCustomerDetails();
					break;
				case 2:
					System.out.println("Enter amount to deposit..");
					int amountToDeposit = scanner.nextInt();
					objTransactionService.CD(objCustomer, amountToDeposit);
					objCustomer.printCustomerDetails();
					break;
				default:
					System.out.println("No service for this choice available...");
			}
			
			System.out.println("Do you want to do continue...(Y/N)");
			String yn = scanner.next();
			
			if(yn.equalsIgnoreCase("N"))
				break;
	
		}		
		System.out.println("Thank you for banking with us....");
	}
}