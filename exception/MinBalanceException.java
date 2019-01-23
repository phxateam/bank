package bank.exception;

public class MinBalanceException extends RuntimeException {
	public String getMessage() {
		return "Balance must be at least $500.00 after withdrawal";
	}
}
