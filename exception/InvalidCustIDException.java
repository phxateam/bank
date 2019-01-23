package bank.exception;

public class InvalidCustIDException extends RuntimeException {

	public String getMessage() {
		return "Customer ID must be non-negative integer.";
	}
}
