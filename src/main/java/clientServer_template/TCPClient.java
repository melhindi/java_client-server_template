package clientServer_template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
	
	protected Socket socket = null;
	protected BufferedReader inputStreamFromServer = null;
	protected PrintWriter ouputStreamToServer = null;
	protected ObjectInputStream objectInputStream = null;
	protected ObjectOutputStream objectOutputStream = null;
	
	public TCPClient(String host, int port) throws IOException {
		this.connect(host, port);
//		this.inputStreamFromServer = new BufferedReader(new InputStreamReader(
//				this.socket.getInputStream()));
//		this.ouputStreamToServer = new PrintWriter(this.socket.getOutputStream(),
//				true);

		System.out.println("TCPClient: creating stream 1");
		this.objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
		System.out.println("TCPClient: stream 1 created");
		System.out.println("TCPClient: creating output stream");
		this.objectInputStream = new ObjectInputStream(this.socket.getInputStream());
	}
	
	public void println(String line) {
		this.ouputStreamToServer.println(line);
	}
	
	public String readLine() throws IOException {
		return this.inputStreamFromServer.readLine();
	}
	
	public ObjectInputStream getObjectInputStream() {
		return objectInputStream;
	}

	public void setObjectInputStream(ObjectInputStream objectInputStream) {
		this.objectInputStream = objectInputStream;
	}

	public ObjectOutputStream getObjectOutputStream() {
		return objectOutputStream;
	}

	public void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
		this.objectOutputStream = objectOutputStream;
	}

	protected void connect(String host, int port) {
		try {
			this.socket = new Socket(host, port);
		} catch (Exception e) {
			System.err.println("Could not create Socket on host " + host + " and port " + port);
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// override this method in your client
	}
}