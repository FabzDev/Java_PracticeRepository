package MortageCalculator_Project;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		final int MONTHS_IN_YEAR = 12;
		final int PERCENT = 100;
		
		Scanner scan = new Scanner(System.in);
		double principal; // done
		double anualIntRate; //done 
		double monthIntRate; //done
		int periodYears; //done
		int periodMonths;
		double mortgage;
		
		System.out.print("Principal: ");
		principal = scan.nextDouble();
		System.out.print("Anual Interest Rate: ");
		anualIntRate = scan.nextDouble()/PERCENT;
		System.out.print("Period (Years): ");
		periodYears = scan.nextInt();
		
		monthIntRate = anualIntRate / MONTHS_IN_YEAR;
		periodMonths = periodYears * MONTHS_IN_YEAR;
		
		mortgage = principal * monthIntRate * Math.pow((1+monthIntRate), periodMonths)/ (Math.pow((1+monthIntRate),periodMonths ) -1);
		
//		NumberFormat currency = NumberFormat.getCurrencyInstance();
//		System.out.println("Mortgage: " + currency.format(mortgage));
//		System.out.println("Total paid: " + currency.format(mortgage*periodMonths));
		
		String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println("Mortgage: " + mortgageFormated);
		System.out.println("Total paid: " + NumberFormat.getCurrencyInstance().format(mortgage*periodMonths));
	}
}
