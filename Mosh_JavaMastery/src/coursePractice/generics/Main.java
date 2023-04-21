package coursePractice.generics;

public class Main {
	public static void main(String[] args) {
//		var userFabio = new User(1500);
//		var userYuli = new User (1200);
//		if(userFabio.compareTo(userYuli)>0) 
//			System.out.println("userFabio > userYuli");
//		else if (userFabio.compareTo(userYuli) == 0) 
//			System.out.println("userFabio = userYuli");
//		else 
//			System.out.println("userFabio < userYuli");
		// -----
//		var max = Util.max(12, 8);
//		System.out.println(max);
		// -----
//		Util.printKey("Fabio", 1234);
		var key1 = new KeyValue("Fabio", "Alejandro");
		key1.printKey();
	}
}