package MortageCalculator_Project;

public class MortageCalculator {
	int MONTHS_IN_YEAR = 12;
	int PERCENTAGE = 100;

	private double principal;
	private double anualIntRate;
	private byte periodYears;

	private double monthIntRate;
	private byte periodMonths;

	public MortageCalculator(double principal, double anualIntRate, byte periodYears) {
		this.principal = principal;
		this.anualIntRate = anualIntRate;
		this.periodYears = periodYears;
		this.monthIntRate = this.getMonthIntRate();
		this.periodMonths = this.getPeriodMonths();
	}

	public double calculateMortgage() {
		double mortgage = principal * getMonthIntRate() * ((Math.pow((1 + getMonthIntRate()), getPeriodMonths()))
				/ ((Math.pow((1 + getMonthIntRate()), getPeriodMonths())) - 1));
		return mortgage;
	}

	public double calcMonthlyPayment(short paidMonths) {
		double balance = principal
				* ((Math.pow((1 + getMonthIntRate()), getPeriodMonths()))
						- (Math.pow((1 + getMonthIntRate()), paidMonths)))
				/ ((Math.pow((1 + getMonthIntRate()), getPeriodMonths())) - 1);

		return balance;
	}

	public double getMonthIntRate() {
		monthIntRate = anualIntRate / MONTHS_IN_YEAR / PERCENTAGE;
		return monthIntRate;
	}

	public byte getPeriodMonths() {
		this.periodMonths = (byte) (periodYears * MONTHS_IN_YEAR);
		return periodMonths;
	}

}
