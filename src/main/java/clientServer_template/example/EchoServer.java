package clientServer_template.example;

import clientServer_template.TCPServer;

public class EchoServer {
	public static void main(String[] args) throws Exception {
		int port = Integer.parseInt(args[0]);
		TCPServer server = new TCPServer(port, EchoHandler.class);
		server.start();
		System.out.println("EchoServer gestartet.");
		System.out.println("ENTER stoppt den Server.");
		System.in.read();
		server.stopServer();
		System.out.println("EchoServer wird gestoppt.");
	}
}