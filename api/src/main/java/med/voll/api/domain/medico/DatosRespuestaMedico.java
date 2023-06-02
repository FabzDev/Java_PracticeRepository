package med.voll.api.domain.medico;

import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRespuestaMedico(Long id, String name, String email,
		String telefono, Especialidad Especialidad, String Documento, DatosDireccion direccion) {

}
