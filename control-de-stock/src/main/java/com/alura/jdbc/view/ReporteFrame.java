package com.alura.jdbc.view;

import java.awt.Container;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.alura.jdbc.controller.CategoriaController;

import com.alura.jdbc.controller.ProductoController;
import com.alura.jdbc.modelo.Categoria;

public class ReporteFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTable tablaReporte;
	private DefaultTableModel modelo;


	private CategoriaController categoriaController;
	private ProductoController productoController;

	public ReporteFrame(ControlDeStockFrame controlDeStockFrame) {
		super("Reporte de produtos del stock");

		this.categoriaController = new CategoriaController();

		Container container = getContentPane();
		setLayout(null);

		tablaReporte = new JTable();
		tablaReporte.setBounds(0, 0, 600, 400);
		container.add(tablaReporte);


		modelo = (DefaultTableModel) tablaReporte.getModel();
		modelo.addColumn("");
		modelo.addColumn("");
		modelo.addColumn("");
		modelo.addColumn("");

		cargaReporte();

		setSize(600, 400);
		setVisible(true);
		setLocationRelativeTo(controlDeStockFrame);
	}


	private void cargaReporte() {
		List<Categoria> contenido = categoriaController.listar();
		this.productoController = new ProductoController();

		contenido.forEach(categoria -> {
			modelo.addRow(new Object[] { categoria.getNombre() });
			var producto = productoController.listar(categoria.getId());
			producto.forEach(prod -> {
				modelo.addRow(new Object[] { "", prod.getNombre(), prod.getCantidad() });
			});

		});
	}

}
