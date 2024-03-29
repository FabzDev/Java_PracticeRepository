package MortageCalculator_Project;

public class Main {
		public static void main(String[] args) {
		double principal = Reader.readValue("Principal ($1,000 - $1,000,000): ", 1000, 1000000);
		double anualIntRate = Reader.readValue("\nAnual Interest Rate: ", 1, 30);
		byte periodYears = (byte) Reader.readValue("\nPeriod (Years): ", 1, 30);
		MortageCalculator fabioCalculator = new MortageCalculator(principal, anualIntRate, periodYears);
		LoanReport fabioLoanReport = new LoanReport(fabioCalculator);
		
		fabioLoanReport.printMortgage();
		fabioLoanReport.printPaymentSchedule();
	}

}

