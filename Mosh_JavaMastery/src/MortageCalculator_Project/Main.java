package MortageCalculator_Project;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double principal; // done
		double anualIntRate; //done 
		double monthIntRate; //done
		int periodYears; //done
		int periodMonths;
		double mortage;
		
		System.out.print("Principal: ");
		principal = scan.nextDouble();
		System.out.print("Anual Interest Rate: ");
		anualIntRate = scan.nextDouble()/100;
		System.out.print("Period (Years): ");
		periodYears = scan.nextInt();
		
		monthIntRate = anualIntRate / 12;
		periodMonths = periodYears * 12;
		
		mortage = principal * monthIntRate * Math.pow((1+monthIntRate), periodMonths)/ (Math.pow((1+monthIntRate),periodMonths ) -1);
		
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		System.out.println("Mortgage: " + currency.format(mortage));
		
	}
}
