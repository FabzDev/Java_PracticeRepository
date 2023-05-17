package annotationsJava_Practice.reflexion;

public class ResultadoAnalisis {
	private String cantidad;
	private String resultado;
	private String instrumento;

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}

	public void method() {
		System.out.println("Analisis completo");
	}
}
