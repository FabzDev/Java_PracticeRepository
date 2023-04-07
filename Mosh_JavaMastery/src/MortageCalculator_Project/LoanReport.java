package MortageCalculator_Project;

import java.text.NumberFormat;

public class LoanReport {
	MortageCalculator calculator;

	public LoanReport(MortageCalculator calculator) {
		this.calculator = calculator;
	}
	

	public void printMortgage() {
		double mortgage = calculator.calculateMortgage();
		double totalPaid = mortgage * calculator.periodMonths();
		String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
		String totalPaidFormated = NumberFormat.getCurrencyInstance().format(totalPaid);
		System.out.println("\nMORTGAGE");
		System.out.println("-----------");
		System.out.println("Monthly Payments: " + mortgageFormated);
		System.out.println("Total paid: " + totalPaidFormated);
	}

	public void printPaymentSchedule() {
		short paidMonths = 0;
		double balance = 1;
		System.out.println("\nPAYMENT SCHEDULE");
		System.out.println("-------------------");

		while (balance > 0) {
			balance = calculator.calcMonthlyPayment(paidMonths);
			System.out.println(NumberFormat.getCurrencyInstance().format(balance));
			paidMonths++;
		}
	}
}
