package com.alura.jdbc.controller;

import java.util.List;

import com.alura.jdbc.clases.ConnectionFactory;
import com.alura.jdbc.modelo.Producto;
import com.alura.jdbc.modelo.ProductoDAO;

public class ProductoController {

	private ProductoDAO productoDAO;
	
	public ProductoController() {
		productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());		
	}
	
	public void modificar(Producto producto) {
		
		productoDAO.modificar(producto);
	}

	public int eliminar(Integer id) {
		return productoDAO.eliminar(id);
	}

	public List<Producto> listar() {
		return productoDAO.listar();
			}

	public void guardar(Producto producto) {
		productoDAO.guardarProducto(producto);
	}	

}
