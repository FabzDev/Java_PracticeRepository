package currency_converter;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyCalculator {
	public double amount;
	public Currency objCurrency1;
	public Currency objCurrency2;

	public CurrencyCalculator(double amount, Currency objCurrency1, Currency objCurrency2) {
		this.amount = amount;
		this.objCurrency1 = objCurrency1;
		this.objCurrency2 = objCurrency2;
	}

	private double convertToUSD() {
		return amount * objCurrency1.getDolarFactor();
	}

	public double convertToCurrency() {
		 return convertToUSD() * objCurrency2.getDolarFactor();
		 
	}
	
	public String formattedAmount() {
		 return NumberFormat.getCurrencyInstance(new Locale("es", "CO")).format(amount);
	}
	
	public String formattedCurrency() {
		 var result = convertToUSD() * objCurrency2.getDolarFactor();
		 return NumberFormat.getCurrencyInstance(Locale.US).format(result);
	}
	
	public String printConverter() {
		return formattedAmount() + " " + objCurrency1.getCurrencyName() + " equivalen a " + formattedCurrency() + " " + objCurrency2.getCurrencyName();
	}

}
