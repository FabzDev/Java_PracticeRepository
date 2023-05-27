package rockPaperScissors123;

public class Match {
	private Jugador jugador1;
	private Jugador jugador2;

	public Match(Jugador jugador1, Jugador jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}

	public void iniciarMatch() {
		if ((this.jugador1.getJugada() == Jugada.PAPEL && this.jugador2.getJugada() == Jugada.PIEDRA)
				|| (this.jugador1.getJugada() == Jugada.PIEDRA && this.jugador2.getJugada() == Jugada.TIJERA)
				|| (this.jugador1.getJugada() == Jugada.TIJERA && this.jugador2.getJugada() == Jugada.PAPEL)) {
			System.out.println("\n" + this.jugador1.getName() + " ha ganado la partida!");
		} else if (this.jugador1.getJugada().equals(this.jugador2.getJugada())) {
			System.out.println("Empate!");
		} else {
			System.out.println("\n" + this.jugador2.getName() + " ha ganado la partida!");
		}
		
	}
}
