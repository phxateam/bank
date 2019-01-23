package bank.exception;

public class DuplicateCustomerException extends RuntimeException {
	public String getMessage() {
		return "Customer ID is already in use";
	}
}
