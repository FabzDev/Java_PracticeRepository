package MortageCalculator_Project;

import java.text.NumberFormat;

public class LoanReport {
	final NumberFormat currency;
	MortageCalculator calculator;

	public LoanReport(MortageCalculator calculator) {
		this.calculator = calculator;
		currency = NumberFormat.getCurrencyInstance();
	}

	public void printMortgage() {
		double mortgage = calculator.calculateMortgage();
		double totalPaid = mortgage * calculator.getPeriodMonths();
		String mortgageFormated = currency.format(mortgage);
		String totalPaidFormated = currency.format(totalPaid);
		System.out.println("\nMORTGAGE");
		System.out.println("-----------");
		System.out.println("Monthly Payments: " + mortgageFormated);
		System.out.println("Total paid: " + totalPaidFormated);
	}

	public void printPaymentSchedule() {
		System.out.println("\nPAYMENT SCHEDULE");
		System.out.println("-------------------");

		double[] balances = new double[calculator.getPeriodMonths()+1];

		for (short i = 0; i < balances.length; i++) {
			balances[i] = calculator.calcMonthlyPayment(i);
		}
		for (double balance : balances) {
			System.out.println(currency.format(balance));
		}
	}
}
