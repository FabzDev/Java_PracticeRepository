package currency_converter;

public class EUR  extends Currency{
	public String currencyName = "EUR";
	
	public EUR() {
		setCurrencyName("EUR");
		setDolarFactor(1.09);
	}
}

