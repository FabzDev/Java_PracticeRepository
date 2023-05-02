package com.alura.jdbc.modelo;

public class Producto {
	private int id;

	private String nombre;
	
	private String descripcion;
	
	private int cantidad;

	public Producto(String nombre, String descripcion, int cantidad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("id= %s , nombre= %s, descripcion= %s, cantidad= %d", 
				id, nombre, descripcion, cantidad);
	}
	
	
	
	
}
