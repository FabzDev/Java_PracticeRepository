package coursePractice.salaryCalculator;

public class Employee {
	private int baseSalary;
	private int hourlyRate;
	
	static int numberOfEmployees;

	
	public Employee(int baseSalary) {
		this(baseSalary, 0);
	}
	
	public Employee(int baseSalary, int hourlyRate) {
		setBaseSalary(baseSalary);
		setHourlyRate(hourlyRate);
		numberOfEmployees++;
	}

	public int calculateWage(int extraHours) {
		return baseSalary + extraHours * hourlyRate;
	}
	
	public int calculateWage() {
		return baseSalary;
	}
	
	public static void printNumberOfEmployees() {
		System.out.println(numberOfEmployees); 
	}

	public void setBaseSalary(int baseSalary) {
		if (baseSalary <= 0)
			throw new IllegalArgumentException("Error: salary not valid");
		this.baseSalary = baseSalary;
	}

	public void setHourlyRate(int hourlyRate) {
		if (hourlyRate < 0)
			throw new IllegalArgumentException("Error: rate not valid");
		this.hourlyRate = hourlyRate;
	}
	
}
