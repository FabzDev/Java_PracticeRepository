package coursePractice.interfaces;

public class Main {
	public static void main(String[] args) {
//      Constructor injection:
//		var calculator = new TaxCalculator2022(100_000);
//		var report = new TaxReport(calculator);
//		report.show();
//		
//		report.setCalculator(new TaxCalculator2023(100_000));
//		report.show();
//		-----------------------------------------------------

//		Method Injection:
		var calculator = new TaxCalculator2022(100_000);
		var report = new TaxReport();
		report.show(calculator);
		report.show(new TaxCalculator2023(100_000));
		
	}
}
