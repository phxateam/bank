package bank.exception;

public class InvalidCWAmountException extends RuntimeException {
	public String getMessage() {
		return "CW must be a multiple of 20 between 0 and 800";
	}
}
