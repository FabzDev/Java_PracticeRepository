package coursePractice.generics;

public class Main {
	public static void main(String[] args) {
		var instructors = new GenericList<Instructor>();
		var Users = new GenericList<User>();
		Utils.printUsers(new GenericList<Instructor>());
		
	}
}