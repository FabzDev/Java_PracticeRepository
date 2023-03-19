package annotationsJava_Practice;


import java.time.LocalDate;
import java.time.Period;

public class Usuario {

	private String nombre;
	private String identidad;
	@EdadMinima(valor = 18)
	private LocalDate fechaNacimiento;

	

	public Usuario(String nombre, String identidad, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.identidad = identidad;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getIdentidad() {
		return identidad;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public boolean usuarioValido(Usuario usuario) {
		if (!usuario.getNombre().matches("[a-zA-Záàâãéèêíïóôõöúçñ\\s]+")) {
			return false;
		}
		if (!usuario.getIdentidad().matches("[^0-9]+")) {
			return false;
		}
		return Period.between(usuario.getFechaNacimiento(), LocalDate.now()).getYears() >= 18;
	}

}