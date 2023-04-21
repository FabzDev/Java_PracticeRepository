package coursePractice.generics;

public class Main {
	public static void main(String[] args) {
		var userFabio = new User(1500);
		var userYuli = new User (1200);
		if(userFabio.compareTo(userYuli)>0) 
			System.out.println("userFabio > userYuli");
		else if (userFabio.compareTo(userYuli) == 0) 
			System.out.println("userFabio = userYuli");
		else 
			System.out.println("userFabio < userYuli");
	}
}