package MortageCalculator_Project;

public class MortageCalculator {
	int MONTHS_IN_YEAR = 12;
	int PERCENTAGE = 100;

	private double principal;
	private double anualIntRate;
	private byte periodYears;

	public MortageCalculator(double principal, double anualIntRate, byte periodYears) {
		this.principal = principal;
		this.anualIntRate = anualIntRate;
		this.periodYears = periodYears;
	}

	
	public double calculateMortgage() {
		double monthIntRate = getMonthIntRate();
		byte periodMonths = getPeriodMonths();
		double mortgage = principal * monthIntRate * ((Math.pow((1 + monthIntRate), periodMonths))
				/ ((Math.pow((1 + monthIntRate), periodMonths)) - 1));
		return mortgage;
	}

	public double calcMonthlyPayment(short paidMonths) {
		double monthIntRate = getMonthIntRate();
		byte periodMonths = getPeriodMonths();
		double balance = principal
				* ((Math.pow((1 + monthIntRate), periodMonths))
						- (Math.pow((1 + monthIntRate), paidMonths)))
				/ ((Math.pow((1 + monthIntRate), periodMonths)) - 1);
		return balance;
	}

	private double getMonthIntRate() {
		return anualIntRate / MONTHS_IN_YEAR / PERCENTAGE;
	}

	public byte getPeriodMonths() {
		return (byte) (periodYears * MONTHS_IN_YEAR);
	}

}
