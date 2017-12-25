package clientServer_template.example;

import clientServer_template.AbstractHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoHandler extends AbstractHandler {
	public void runTask(Socket socket) {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(),
						true)) {
			out.println("Server ist bereit ...");
			String input;
			while ((input = in.readLine()) != null) {
				out.println(input);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}