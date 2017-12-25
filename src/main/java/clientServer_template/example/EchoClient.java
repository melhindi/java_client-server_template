package clientServer_template.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import clientServer_template.TCPClient;

public class EchoClient extends TCPClient{


	public EchoClient(String host, int port) throws IOException {
		super(host, port);

	}

	public static void main(String[] args) {
		String host = args[0];
		int port = Integer.parseInt(args[1]);
		try {

			TCPClient tcpClient = new TCPClient(host, port);
			BufferedReader cmdInput = new BufferedReader(
					new InputStreamReader(System.in));

			String msg = tcpClient.readLine();
			System.out.println(msg);
			String line;
			while (true) {
				System.out.println("Enter a message (q to quit):");
				line = cmdInput.readLine();
				if (line == null || line.equals("q"))
					break;
				tcpClient.println(line);
				System.out.println(tcpClient.readLine());
			}
		}catch (Exception e) {
			System.err.println("Following exception caught:");
			e.printStackTrace();
		}

	}

}