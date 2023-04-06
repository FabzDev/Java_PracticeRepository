package MortageCalculator_Project;

public class MortageMain {
		public static void main(String[] args) {
		
//		double principal = Reader.readValue("Principal ($1,000 - $1,000,000): ", 1000, 1000000);
//		double anualIntRate = Reader.readValue("\nAnual Interest Rate: ", 1, 30);
//		byte periodYears = (byte) Reader.readValue("\nPeriod (Years): ", 1, 30);
		Reader principal = new Reader("Principal ($1,000 - $1,000,000): ", 1000, 1000000);
		Reader anualIntRate = new Reader("\nAnual Interest Rate: ", 1, 30);
		Reader periodYears = new Reader("\nPeriod (Years): ", 1, 30);
			
		MortageCalculator fabioLoan = new MortageCalculator(principal.readValue(), anualIntRate.readValue(), (byte)periodYears.readValue());
		fabioLoan.printMortgage();
		
	}

}
