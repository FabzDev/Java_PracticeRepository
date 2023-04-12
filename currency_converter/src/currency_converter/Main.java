package currency_converter;

public class Main {
	public static void main(String[] args) {
		var calculo1 = new CurrencyCalculator(10000, new COP(), new EUR());
		System.out.println(calculo1.printConverter());
	}

}
