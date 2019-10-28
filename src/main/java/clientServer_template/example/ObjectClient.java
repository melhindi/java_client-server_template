package clientServer_template.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import clientServer_template.TCPClient;
import clientServer_template.TCPServer;

public class ObjectClient extends TCPClient{


	public ObjectClient(String host, int port) throws IOException {
		super(host, port);

	}

	public static void main(String[] args) {
		String host = "localhost";
		int port = Integer.parseInt("9000");

		try {
			TCPServer server = new TCPServer(port, ObjectHandler.class);
			server.start();
			System.out.println("ObjectServer gestartet.");

			System.out.println("Object Client: connecting to Server");
			TCPClient tcpClient = new TCPClient(host, port);
			System.out.println("Object Client 1");
			
			SerializableObject object = new SerializableObject("testCommand");
			System.out.println("Object Client 2");
			tcpClient.getObjectOutputStream().writeObject(object);
			System.out.println("Object Client: Reading from server");
			while ((object = (SerializableObject) tcpClient.getObjectInputStream().readObject()) != null) {
				System.out.println(object.getCommand());
			}
			
		}catch (Exception e) {
			System.err.println("Following exception caught:");
			e.printStackTrace();
		}

	}

}