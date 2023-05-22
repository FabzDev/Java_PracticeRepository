package med.voll.api.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@Getter
@AllArgsConstructor
public class Direccion {
	
	private String calle;
	private String numero;
	private String complemento;
	private String distrito;
	private String barrio;
	private String ciudad;
	
	public Direccion() {
	}
	
	public Direccion(DatosDireccion datosDireccion) {
		this.calle = datosDireccion.calle();
		this.numero = datosDireccion.numero();
		this.distrito = datosDireccion.distrito();
		this.barrio = datosDireccion.barrio();
		this.complemento = datosDireccion.complemento();
		this.ciudad = datosDireccion.ciudad();
	}
	 
}