package coursePractice.interfaces;

public class TaxCalculator2022 implements TaxCalculator{
	private double taxableAmount;

	public TaxCalculator2022(double taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	@Override
	public double calculateTax() {
		return taxableAmount * 0.3;	
	}	
	
}
