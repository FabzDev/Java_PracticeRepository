package rockPaperScissors123;

import java.util.Scanner;

public class JuegoMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Jugador player1 = new Jugador();
		Jugador player2 = new Jugador();
		Match match1 = new Match(player1, player2);
		int revancha;
		
		System.out.println("\n.:Papel, Tijera, Piedra... 1, 2, 3!.\n");
		
		// Checkpoint #1
		registrarNombres(player1, player2);
		
		do {
			// Checkpoint #2
			registarJugada(player1);
			registarJugada(player2);
			
			match1.iniciarMatch();
			
			System.out.println("\nRevancha?\n1.Si! Quiero ganar o.ó...\n2.No, acepto el resultado u.u...\n");
			revancha = scan.nextInt();
			
		} while (revancha == 1);
		
		
	}

	private static void registarJugada(Jugador player) {
		Scanner scanJugada = new Scanner(System.in);
		int jugada;

		System.out.println("\n" + player.getName() + ", elije tu jugada: \n1. Piedra \n2. Papel \n3. Tijera\n");
		jugada = scanJugada.nextInt();

		switch (jugada) {
		case 1:
			player.elegirJugada(Jugada.PIEDRA);
			break;
		case 2:
			player.elegirJugada(Jugada.PAPEL);
			break;
		case 3:
			player.elegirJugada(Jugada.TIJERA);
			break;
		}
		
	}

	private static void registrarNombres(Jugador jugador1, Jugador jugador2) {
		Scanner scanNombres = new Scanner(System.in);

		System.out.println("\nIngresa el nombre del jugador #1:");
		jugador1.setName(scanNombres.nextLine());

		System.out.println("\nIngresa el nombre del jugador #2:");
		jugador2.setName(scanNombres.nextLine());
		
	}
	
	

}

//	public static void main(String[] args) {
//		Scanner scanOption = new Scanner(System.in);
//
//		int opcion1;
//
//		System.out.println(".:Papel, Tijera, Piedra... 1, 2, 3!.\n");
//		do {			
//			System.out.println("Selecciona: ");
//			System.out.println("1. Jugar");
//			System.out.println("2. Salir");
//			opcion1 = scanOption.nextInt();
//			
//			if (opcion1 == 1) {
//				Jugador player1 = new Jugador();
//				Jugador player2 = new Jugador();
//
//				registrarJugador(player1);
//				registrarJugador(player2);
//				
//				Match match1 = new Match(player1, player2);
//				
//				match1.iniciarMatch();
//				
//				System.out.println();
//
//			}
//
//		} while (opcion1 != 2);
//
//	}

//	private static void registrarJugador(Jugador jugador) {
//		Scanner scanJugada = new Scanner(System.in);
//		int jugada;
//
//		System.out.println("\nIngresa el nombre del jugador:\n");
//		jugador.setName(scanJugada.nextLine());
//
//		System.out.println("\nElije tu jugada: \n1. Piedra \n2. Papel \n3. Tijera\n");
//		jugada = scanJugada.nextInt();
//
//		switch (jugada) {
//		case 1:
//			jugador.elegirJugada(Jugada.PIEDRA);
//			break;
//		case 2:
//			jugador.elegirJugada(Jugada.PAPEL);
//			break;
//		case 3:
//			jugador.elegirJugada(Jugada.TIJERA);
//			break;
//		}
//
//	}
