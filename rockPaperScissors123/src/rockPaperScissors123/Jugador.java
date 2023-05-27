package rockPaperScissors123;

public class Jugador {
	private String name;
	private Jugada jugada;
	
	public Jugador() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Jugada getJugada() {
		return jugada;
	}
	
	public void elegirJugada(Jugada jugada) {
		this.jugada = jugada;
	}
	
}
