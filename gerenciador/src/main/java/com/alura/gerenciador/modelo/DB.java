package com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.List;

public class DB {
	private static List<Usuario> listaUsuariosDB = new ArrayList<>();
	private static List<Empresa> listaEmpresasDB = new ArrayList<>();
	private static int secuencialEmpresa = 1;
	static {
		Empresa sby = new Empresa();
		sby.setNombreEmpresa("Skin By Yulieth");
		sby.setId(DB.secuencialEmpresa++);
		Empresa dondeFabio = new Empresa();
		dondeFabio.setNombreEmpresa("Donde Fabio");
		dondeFabio.setId(DB.secuencialEmpresa++);
		Empresa fabztech = new Empresa();
		fabztech.setNombreEmpresa("FabzTech Software");
		fabztech.setId(DB.secuencialEmpresa++);

		listaEmpresasDB.add(sby);
		listaEmpresasDB.add(dondeFabio);
		listaEmpresasDB.add(fabztech);

		Usuario u1 = new Usuario();
		u1.setLogin("Fabio04");
		u1.setContrasena("12345");

		Usuario u2 = new Usuario();
		u2.setLogin("Yuliet2");
		u2.setContrasena("67890");

		Usuario u3 = new Usuario();
		u3.setLogin("Alejandro13");
		u3.setContrasena("54321");

		listaUsuariosDB.add(u1);
		listaUsuariosDB.add(u2);
		listaUsuariosDB.add(u3);
	}

	public void agregarUsuario(Usuario usuario) {
		DB.listaUsuariosDB.add(usuario);
	}

	public void agregarEmpresa(Empresa empresa) {
		empresa.setId(DB.secuencialEmpresa++);
		DB.listaEmpresasDB.add(empresa);
	}

	public void eliminarEmpresa(Empresa empresa) {
		DB.listaEmpresasDB.remove(empresa);
		DB.secuencialEmpresa--;
	}

	public Empresa getEmpresa(Integer id) {
		return listaEmpresasDB.stream().filter(empresa -> empresa.getId().equals(id)).findFirst().orElse(null);
	}

	public Usuario encontrarUsuario(String login) {
		return listaUsuariosDB.stream().filter(user -> user.getLogin().equals(login)).findFirst()
				.orElse(null);
	}

	public List<Empresa> getEmpresas() {
		return DB.listaEmpresasDB;
	}

	public List<Usuario> getUsuarios() {
		return DB.listaUsuariosDB;
	}
}
