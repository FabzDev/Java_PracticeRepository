package med.voll.api.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.direccion.DatosDireccion;
import med.voll.api.domain.medico.DatosActualizarMedico;
import med.voll.api.domain.medico.DatosListadoMedico;
import med.voll.api.domain.medico.DatosMedicoRegistro;
import med.voll.api.domain.medico.DatosRespuestaMedico;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private MedicoRepository medicoRepository;

	@PostMapping
	public ResponseEntity registrarMedico(@RequestBody @Valid DatosMedicoRegistro datosMedicoRegistro, UriComponentsBuilder uriBuilder) {
		Medico medico = medicoRepository.save(new Medico(datosMedicoRegistro));
		URI url = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
		return ResponseEntity.created(url).body(datosMedicoRegistro);
	}

	@GetMapping("/{id}")
	public ResponseEntity buscarMedico(@PathVariable Long id) {
		Medico medico = medicoRepository.getReferenceById(id);
		return ResponseEntity.ok(new DatosListadoMedico(medico));
	}
	
	
	@GetMapping
	public ResponseEntity<Page<DatosListadoMedico>> listadoMedico(@PageableDefault(sort = "nombre", size = 3) Pageable pag) {
		return ResponseEntity.ok(medicoRepository.findByActivoTrue(pag).map(medico -> new DatosListadoMedico(medico)));
	}

	@PutMapping
	@Transactional
	public ResponseEntity actualizarMedico(@RequestBody DatosActualizarMedico datosMedicoActualizar) {
		Medico medico = medicoRepository.getReferenceById(datosMedicoActualizar.id());
		medico.actualizarDatos(datosMedicoActualizar);
		return ResponseEntity.ok(new DatosRespuestaMedico(medico.getId(), medico.getNombre(),
				medico.getEmail(), medico.getTelefono(), medico.getEspecialidad(), medico.getDocumento(),
				new DatosDireccion(medico.getDireccion().getCalle(), medico.getDireccion().getDistrito(),
						medico.getDireccion().getBarrio(), medico.getDireccion().getCiudad(),
						medico.getDireccion().getNumero(), medico.getDireccion().getComplemento())));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity eliminarMedico(@PathVariable Long id) {
		Medico medico = medicoRepository.getReferenceById(id);
		medico.desactivarMedico();
		return ResponseEntity.noContent().build();
	}

//		ELIMINAR DE BASE DE DATOS
//		Medico medico = medicoRepository.getReferenceById(id);
//		medicoRepository.delete(medico);
//	}

}