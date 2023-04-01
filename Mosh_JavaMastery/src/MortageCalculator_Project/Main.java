package MortageCalculator_Project;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double principal;
		double anualIntRate;
		byte periodYears;
		double mortgage;

		principal = readNumber("Principal ($1,000 - $1,000,000): ", 1000, 1000000);
		anualIntRate = readNumber("\nAnual Interest Rate: ", 1, 30);
		periodYears = (byte) readNumber("\nPeriod (Years): ", 1, 30);

		mortgage = calculateMortgage(principal, anualIntRate, periodYears);
		String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println("\nMortgage: " + mortgageFormated);
		System.out.println("\nTotal paid: " + NumberFormat.getCurrencyInstance().format(mortgage * periodYears * 12));
	}

	public static double calculateMortgage(double principal, double anualIntRate, double periodYears) {
		final int MONTHS_IN_YEAR = 12;
		final int PERCENTAGE = 100;
		double mortgage;
		double monthIntRate;
		byte periodMonths;

		monthIntRate = anualIntRate / MONTHS_IN_YEAR / PERCENTAGE;
		periodMonths = (byte) (periodYears * MONTHS_IN_YEAR);

		mortgage = principal * monthIntRate * ((Math.pow((1+monthIntRate), periodMonths))/((Math.pow((1+monthIntRate), periodMonths))-1));
		return mortgage;

	}

	public static double readNumber(String initialMessage, int min, int max) {
		Scanner scan2 = new Scanner(System.in);
		double value;
		while (true) {
			System.out.print(initialMessage);
			value = (double) scan2.nextDouble();
			if (value >= min && value <= max) {
				return value;
			}
			System.out.println("Enter a number between " + min + " and " + max + "\n");
		}
	}

}
