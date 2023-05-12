package com.alura.gerenciador.servlet;

import java.util.Date;

public class Empresa {
	private Integer id;
	private String nombreEmpresa;
	private Date fechaApertura = new Date();

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date paramFechaApertura) {
		this.fechaApertura = paramFechaApertura;
	}
	
	
}
