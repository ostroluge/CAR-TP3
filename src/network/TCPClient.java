package network;

import model.ProxyCarnet;

public class TCPClient {
	
	public static final String HOSTNAME = "hostname";
	public static final int PORT = 8080;
	
	public static void main(String[] args) {
		
		try {	
			ProxyCarnet proxyCarnet = new ProxyCarnet(HOSTNAME, PORT);
		} catch (Exception e) {
			e.printStackTrace();;
		}
	}
}
