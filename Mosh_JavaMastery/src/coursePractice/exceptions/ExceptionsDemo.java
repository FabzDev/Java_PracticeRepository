package coursePractice.exceptions;

import java.io.IOException;

public class ExceptionsDemo {
	public static void show() throws IOException{
		var account = new Account();
		try {
			account.deposit(0);
		} catch (IOException e) {
			throw e;
		}
	}
}
