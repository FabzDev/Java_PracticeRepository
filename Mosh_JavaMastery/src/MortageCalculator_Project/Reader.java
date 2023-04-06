package MortageCalculator_Project;

import java.util.Scanner;

public class Reader {
	static Scanner scan = new Scanner(System.in);
	
	public static double readValue(String initialMessage) {
	return scan.nextDouble();
	}
	
	public static double readValue(String initialMessage, int min, int max) {
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
