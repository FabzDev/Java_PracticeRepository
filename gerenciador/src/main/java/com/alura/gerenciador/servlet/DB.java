package com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class DB {
	private static List<Empresa>listaEmpresasDB = new ArrayList<>();
	private static int secuencialEmpresa= 1;
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
	}
	
	public void agregarEmpresa(Empresa empresa) {
		DB.listaEmpresasDB.add(empresa);
		empresa.setId(DB.secuencialEmpresa++);
	}
	
	public void eliminarEmpresa(Empresa empresa) {
		DB.listaEmpresasDB.remove(empresa);
		DB.secuencialEmpresa--;
	}
	
	public Empresa getEmpresa(Integer id) {
		return listaEmpresasDB.stream()
                .filter(empresa -> empresa.getId().equals(id))
                .findFirst()
                .orElse(null);
	}
	
	public List<Empresa> getEmpresas() {
		return DB.listaEmpresasDB;
	}
}
