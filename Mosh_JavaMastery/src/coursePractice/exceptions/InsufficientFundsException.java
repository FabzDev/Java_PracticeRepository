package coursePractice.exceptions;

//Exception (checked)
//Runtime (unchecked)

public class InsufficientFundsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientFundsException() {
		super("Insufficient Funds");
	}
	
}

