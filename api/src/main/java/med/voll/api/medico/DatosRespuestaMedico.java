package med.voll.api.medico;

import med.voll.api.direccion.DatosDireccion;

public record DatosRespuestaMedico(Long id, String name, String email,
		String telefono, Especialidad Especialidad, String Documento, DatosDireccion direccion) {

}
