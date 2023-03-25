
public class MailService {

	public void sendEmail() {
		connect(5);
		authenticate();
		// Send email
		disconnect();
	}
	
	private void connect(int n) {
		System.out.println("Connect");
	}
	
	private void disconnect() {
		System.out.println("Disconnect");
	}
	
	private void authenticate() {
		System.out.println("Authenticate");
	}
}
