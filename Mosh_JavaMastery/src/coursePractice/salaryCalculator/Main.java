package coursePractice.salaryCalculator;

public class Main {
	
	public static void main(String[] args) {
		Employee employee1 = new Employee(50_000, 20);
		Employee employee2 = new Employee(30_000);
		int wage1 = employee1.calculateWage(10);
		int wage2 = employee2.calculateWage();
		System.out.println(wage1);
		System.out.println(wage2);
		Employee.printNumberOfEmployees();
	}
};