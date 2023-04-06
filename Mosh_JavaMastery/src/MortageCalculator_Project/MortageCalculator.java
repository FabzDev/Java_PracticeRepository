package MortageCalculator_Project;

import java.text.NumberFormat;

public class MortageCalculator {
	int MONTHS_IN_YEAR = 12;
	int PERCENTAGE = 100;
	double principal;
	double anualIntRate;
	byte periodYears;
	double monthIntRate = anualIntRate / MONTHS_IN_YEAR / PERCENTAGE;
	byte periodMonths = (byte) (periodYears * MONTHS_IN_YEAR);
	
	public MortageCalculator(double principal, double anualIntRate, byte periodYears) {
		this.principal = principal;
		this.anualIntRate = anualIntRate;
		this.periodYears = periodYears;
	}

	public void printMortgage() {
		double mortgage = calculateMortgage();
		double totalPaid = mortgage * periodYears * MONTHS_IN_YEAR;
		String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
		String totalPaidFormated = NumberFormat.getCurrencyInstance().format(totalPaid);
		System.out.println("\nMORTGAGE");
		System.out.println("-----------");
		System.out.println("Monthly Payments: " + mortgageFormated);
		System.out.println("Total paid: " + totalPaidFormated);
	}
	
	public double calculateMortgage() {
		double mortgage = principal * monthIntRate
				* ((Math.pow((1 + monthIntRate), periodMonths)) / ((Math.pow((1 + monthIntRate), periodMonths)) - 1));
		return mortgage;

	}
	
	public void getPaymentSchedule() {
		short paidMonths = 0;
		double balance = principal;

		System.out.println("\nPAYMENT SCHEDULE");
		System.out.println("-------------------");

		while (balance > 0) {
			balance = principal
					* ((Math.pow((1 + monthIntRate), periodMonths)) - (Math.pow((1 + monthIntRate), paidMonths)))
					/ ((Math.pow((1 + monthIntRate), periodMonths)) - 1);

			System.out.println(NumberFormat.getCurrencyInstance().format(balance));
			paidMonths++;
		}
	}
}
