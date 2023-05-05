package com.alura.jdbc.modelo;

public class Categoria {
	private int id;
	private String nombre;
	
	public Categoria(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
}
