package coursePractice.interfaces;

public class TaxCalculator {
	private double taxableAmount;

	public TaxCalculator(double taxableAmount) {
		this.taxableAmount = taxableAmount;
	}
	
	public double calculateTax() {
		return taxableAmount * 0.3;	
		
	}
	
	
}
