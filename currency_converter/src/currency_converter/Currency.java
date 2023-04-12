package currency_converter;

public abstract class Currency {
	private double dolarFactor;
	public String currencyName;
	
	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public double getDolarFactor() {
		return dolarFactor;
	}

	public void setDolarFactor(double dolarFactor) {
		this.dolarFactor = dolarFactor;
	}
}
