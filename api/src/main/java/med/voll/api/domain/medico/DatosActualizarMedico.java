package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.direccion.DatosDireccion;
import med.voll.api.domain.direccion.Direccion;

public record DatosActualizarMedico(
		
		@NotNull 
		Long id, 
		
		String nombre, 
		
		String documento, 
		
		DatosDireccion direccion) {
	
}
