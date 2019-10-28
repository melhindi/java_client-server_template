package clientServer_template.example;

import clientServer_template.AbstractHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ObjectHandler extends AbstractHandler {
	public void runTask(Socket socket) {
		try (ObjectInputStream in = new ObjectInputStream(
				socket.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
			//out.println("Server ist bereit ...");
			SerializableObject input;
			while ((input = (SerializableObject) in.readObject()) != null) {
				System.out.println(input.getCommand());
				System.out.println("ObjectHandler: Modifying input");
				input.setCommand("modifiedCommand");
				System.out.println("ObjectHandler: Sending modified server");
				out.writeObject(input);
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}