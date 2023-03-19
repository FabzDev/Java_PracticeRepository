package java_pila_ejecucion;

public class FabioExcepcion extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6645625475342451591L;

	public FabioExcepcion(){
		super();
	}
	
	public FabioExcepcion(String message){
		super(message);
	}
}
