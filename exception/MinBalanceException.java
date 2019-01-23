package bank.exception;

public class MinBalanceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Balance must be at least $500.00 after withdrawal";
	}
}
