package clientServer_template.example;

import clientServer_template.TCPServer;

public class ObjectServer {
	public static void main(String[] args) throws Exception {
		int port = Integer.parseInt("9000");
		TCPServer server = new TCPServer(port, ObjectHandler.class);
		server.start();
		System.out.println("ObjectServer gestartet.");
		System.out.println("ENTER stoppt den Server.");
		System.in.read();
		server.stopServer();
		System.out.println("ObjectServer wird gestoppt.");
	}
}