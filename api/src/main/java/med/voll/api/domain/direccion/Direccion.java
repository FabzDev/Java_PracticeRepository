package med.voll.api.domain.direccion;

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

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
		
	 
}