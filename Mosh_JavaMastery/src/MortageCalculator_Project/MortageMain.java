package MortageCalculator_Project;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortageMain {
	public static void main(String[] args) {
		double principal = readNumber("Principal ($1,000 - $1,000,000): ", 1000, 1000000);
		double anualIntRate = readNumber("\nAnual Interest Rate: ", 1, 30);
		byte periodYears = (byte) readNumber("\nPeriod (Years): ", 1, 30);

		double mortgage = calculateMortgage(principal, anualIntRate, periodYears);
		double totalPaid= mortgage * periodYears * 12;	
		String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
		String totalPaidFormated = NumberFormat.getCurrencyInstance().format(totalPaid);
		
		System.out.println("\nMORTGAGE");
		System.out.println("-----------");
		System.out.println("Monthly Payments: " + mortgageFormated);
		System.out.println("Total paid: " + totalPaidFormated);
		System.out.println("\nPAYMENT SCHEDULE");
		System.out.println("-------------------");
		
		getPaymentSchedule(principal, anualIntRate, periodYears);
	}

	public static double calculateMortgage(double principal, double anualIntRate, double periodYears) {
		final int MONTHS_IN_YEAR = 12;
		final int PERCENTAGE = 100;

		double monthIntRate = anualIntRate / MONTHS_IN_YEAR / PERCENTAGE;
		byte periodMonths = (byte) (periodYears * MONTHS_IN_YEAR);

		double mortgage = principal * monthIntRate * ((Math.pow((1+monthIntRate), periodMonths))/((Math.pow((1+monthIntRate), periodMonths))-1));
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
	
	public static void getPaymentSchedule(double principal, double anualIntRate, byte periodYears) {
		final int MONTHS_IN_YEAR = 12;
		final int PERCENTAGE = 100;
		double monthIntRate = anualIntRate / MONTHS_IN_YEAR / PERCENTAGE;
		byte periodMonths = (byte) (periodYears * MONTHS_IN_YEAR);
		byte paidMonths = 0; 
		double balance = principal;
		
		while (balance > 0) {
		balance = principal * ((Math.pow((1+monthIntRate), periodMonths))-(Math.pow((1+monthIntRate), paidMonths)))
				/ ((Math.pow((1+monthIntRate), periodMonths)) - 1);
		if (balance > 0)
			System.out.println(NumberFormat.getCurrencyInstance().format(balance));
		paidMonths ++;
		}
	}

}
