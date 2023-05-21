package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.medico.DatosMedicoRegistro;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	@PostMapping
	public void registrarMedico(@RequestBody DatosMedicoRegistro datosMedicoRegistro) {
		System.out.println("\nMédico registrado\n");
		System.out.println(datosMedicoRegistro);
	}
}
