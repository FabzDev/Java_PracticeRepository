package coursePractice.interfaces;

public class TaxCalculator2023 implements TaxCalculator{
	private double taxableAmount;

	public TaxCalculator2023(double taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	@Override
	public double calculateTax() {
		return taxableAmount * 0.4;	
	}
}
