package annotationsJava_Practice.reflexion;

public class Comunicado {
	private String encabezado;
	private String departamento;
	private String mensaje;

	public String getEncabezado() {
		return encabezado;
	}

	public void setEncabezado(String encabezado) {
		this.encabezado = encabezado;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void method() {
		System.out.println("Comunicado publicado");
	}
}
