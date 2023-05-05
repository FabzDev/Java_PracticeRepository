package com.alura.jdbc.controller;

import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.clases.ConnectionFactory;
import com.alura.jdbc.modelo.Categoria;
import com.alura.jdbc.modelo.CategoriaDAO;
import com.alura.jdbc.modelo.ProductoDAO;

public class CategoriaController {
	
	private CategoriaDAO categoriaDAO;
	
	public CategoriaController() {
		categoriaDAO = new CategoriaDAO(new ConnectionFactory().recuperaConexion()); 
	}

	public List<Categoria> listar() {
		return categoriaDAO.listar();
	}

    public List<?> cargaReporte() {
        // TODO
        return new ArrayList<>();
    }

}
