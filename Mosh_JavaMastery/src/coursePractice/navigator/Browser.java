package coursePractice.navigator;

public class Browser {
	public void navigate(String address) {
		String ip = getIp(address);
		String html = sendHttpRequest(ip);
		System.out.println(html);
	}
	
	private String getIp(String address) {
		return "127.0.0.1";
	}
	
	private String sendHttpRequest(String ip) {
		return "<html></html>";
	}
}
