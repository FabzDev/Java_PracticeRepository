package coursePractice.salaryCalculator;

public class Employee {
	private int baseSalary;
	private int hourlyRate;

	public int calculateWage(int extraHours) {
		return baseSalary + extraHours * hourlyRate;
	}

	private int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		if (baseSalary <= 0)
			throw new IllegalArgumentException("Error: salary not valid");
		this.baseSalary = baseSalary;
	}

	private int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		if (hourlyRate <= 0)
			throw new IllegalArgumentException("Error: rate not valid");
		this.hourlyRate = hourlyRate;

	}

}
