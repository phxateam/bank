package bank.exception;

public class DuplicateCustomerException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Customer ID is already in use";
	}
}
