package com.alura.jdbc.modelo;

public class Producto {
	private int id;

	private String nombre;
	
	private String descripcion;
	
	private int cantidad;
	
	private int categoriaId;

	

	public Producto(String nombre, String descripcion, int cantidad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}
	
	public Producto(int id, String nombre, String descripcion, int cantidad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.id = id;
	}
	
	public Producto(int id, String nombre, String descripcion, int cantidad, int categoriaId) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.id = id;
		this.categoriaId = categoriaId;
	}
	
	public Producto(String nombre, String descripcion, int cantidad, int categoriaId) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.categoriaId = categoriaId;
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

	public int getCategoriaId() {
		return this.categoriaId;
	}
	
	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}
	
	
}
