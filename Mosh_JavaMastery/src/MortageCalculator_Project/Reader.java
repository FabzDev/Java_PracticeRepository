package MortageCalculator_Project;

import java.util.Scanner;

public  class Reader {
	String initialMessage;
	int min;
	int max;
	
	
	
	public Reader(String initialMessage, int min, int max) {
		this.initialMessage = initialMessage;
		this.min = min;
		this.max = max;
	}

	public double readValue() {
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
