package clientServer_template;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer extends Thread {
	private AbstractHandler handler;
	private ServerSocket serverSocket;
	private ExecutorService pool;
	public TCPServer(int port, Class<?> handlerClass) throws Exception {
		handler = (AbstractHandler) handlerClass.newInstance();
		serverSocket = new ServerSocket(port);
		pool = Executors.newCachedThreadPool();
	}
	public TCPServer(int port, Object handlerObject) throws IOException {
		handler = (AbstractHandler) handlerObject;
		serverSocket = new ServerSocket(port);
		pool = Executors.newCachedThreadPool();
	}
	public void run() {
		try {
			while (true) {
				Socket socket = serverSocket.accept();
				handler.handle(socket, pool);
			}
		} catch (SocketException e) {
			// Beim Aufruf von stopServer() wird eine SocketException ausgeloest
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	public void stopServer() {
		try {
			serverSocket.close();
		} catch (IOException e) {
		}
		pool.shutdown();
	}
}