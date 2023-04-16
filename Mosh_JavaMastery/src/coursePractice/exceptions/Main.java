package coursePractice.exceptions;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
//		try {
//			ExceptionsDemo.show();
//		} catch (IOException e) {
//			System.out.println("Toma lo tuyo");
//			e.printStackTrace();
//			System.out.println("!!!");
//		}
		var fabioAcc = new Account();
		try {
			fabioAcc.withdraw(10);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
			System.out.println("ayala!");
		}
	}
}
