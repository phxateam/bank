package bank.exception;

public class CDAmountException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Cash deposit must be greater than $0.00 and no larger than $5000.00";
	}
}
