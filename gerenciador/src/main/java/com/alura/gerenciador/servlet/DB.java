package com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class DB {
	private static List<Empresa>listaEmpresas = new ArrayList<>();
	
	static {
		Empresa sby = new Empresa();
		sby.setNombreEmpresa("Skin By Yulieth");
		Empresa dondeFabio = new Empresa();
		dondeFabio.setNombreEmpresa("Donde Fabio");
		Empresa fabztech = new Empresa();
		fabztech.setNombreEmpresa("FabzTech Software");
		
		listaEmpresas.add(sby);
		listaEmpresas.add(dondeFabio);
		listaEmpresas.add(fabztech);
	}
	
	public void agregarEmpresa(Empresa empresa) {
		DB.listaEmpresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return DB.listaEmpresas;
	}
}
