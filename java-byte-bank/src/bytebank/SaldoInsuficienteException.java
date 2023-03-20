package bytebank;

public class SaldoInsuficienteException extends RuntimeException{

	private static final long serialVersionUID = -8480006275868452603L;
	
	public SaldoInsuficienteException(String message){
		super(message);
		
	};
	
}
