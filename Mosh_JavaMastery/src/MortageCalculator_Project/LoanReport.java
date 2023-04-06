package MortageCalculator_Project;

import java.text.NumberFormat;

public class LoanReport {

	private double principal;
	private double anualIntRate;
	private byte periodYears;

	public LoanReport(double principal, double anualIntRate, byte periodYears) {
		this.principal = principal;
		this.anualIntRate = anualIntRate;
		this.periodYears = periodYears;
	}

	public void printMortgage() {
		MortageCalculator calculator = new MortageCalculator(principal, anualIntRate, periodYears);
		double mortgage = calculator.calculateMortgage();
		double totalPaid = mortgage * calculator.getPeriodMonths();
		String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
		String totalPaidFormated = NumberFormat.getCurrencyInstance().format(totalPaid);
		System.out.println("\nMORTGAGE");
		System.out.println("-----------");
		System.out.println("Monthly Payments: " + mortgageFormated);
		System.out.println("Total paid: " + totalPaidFormated);
	}

	public void printPaymentSchedule() {
		MortageCalculator calculator = new MortageCalculator(principal, anualIntRate, periodYears);
		short paidMonths = 0;
		double balance = principal;
		System.out.println("\nPAYMENT SCHEDULE");
		System.out.println("-------------------");

		while (balance > 0) {
			balance = calculator.calcMonthlyPayment(paidMonths);
			System.out.println(NumberFormat.getCurrencyInstance().format(balance));
			paidMonths++;
		}
	}
}
