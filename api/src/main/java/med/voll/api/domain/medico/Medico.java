package med.voll.api.domain.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.direccion.Direccion;

@Table(name = "medicos")
@Entity(name = "Medico")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Medico {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String email;
	private String telefono;
	private String documento;
	private boolean activo;
	@Enumerated(EnumType.STRING)
	private Especialidad especialidad;
	@Embedded
	private Direccion direccion;

	
	public Medico(DatosMedicoRegistro datosMedicoRegistro) {
		this.activo = true;
		this.nombre = datosMedicoRegistro.nombre();
		this.email= datosMedicoRegistro.email();
		this.documento = datosMedicoRegistro.documento();
		this.especialidad= datosMedicoRegistro.especialidad();
		
		this.direccion = new Direccion(datosMedicoRegistro.direccion());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void actualizarDatos(DatosActualizarMedico datosActualizarMedico) {
				
		if(datosActualizarMedico.nombre() != null) {
			setNombre(datosActualizarMedico.nombre());
		}
		if(datosActualizarMedico.documento() != null) {
			setDocumento(datosActualizarMedico.documento());
		}
		if(datosActualizarMedico.direccion() != null) {
			this.direccion = new Direccion(datosActualizarMedico.direccion());
		} 
		
	}

	public void desactivarMedico() {
		this.setActivo(false);
		
	}	
	
}