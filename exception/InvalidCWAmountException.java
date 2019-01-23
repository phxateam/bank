package bank.exception;

public class InvalidCWAmountException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "CW must be a multiple of 20 between 0 and 800";
	}
}
