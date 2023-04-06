package MortageCalculator_Project;

import java.util.Scanner;

public abstract class Reader {

	public static double readValue(String initialMessage, int min, int max) {
		Scanner scan = new Scanner(System.in);
		double value;
		while (true) {
			System.out.print(initialMessage);
			value = (double) scan.nextDouble();
			if (value >= min && value <= max) {
				return value;
			}
			System.out.println("Enter a number between " + min + " and " + max + "\n");
		}
	}
	
}
