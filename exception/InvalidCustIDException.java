package bank.exception;

public class InvalidCustIDException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Customer ID must be non-negative integer.";
	}
}
