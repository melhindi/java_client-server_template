package clientServer_template;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.ExecutorService;

public abstract class AbstractHandler {
	public void handle(final Socket socket, ExecutorService pool) {
		pool.execute(new Runnable() {
			@Override
			public void run() {
				SocketAddress socketAddress = socket.getRemoteSocketAddress();
				System.out.println("Connection to " + socketAddress + " open");
				runTask(socket);
				try {
					if (socket != null)
						socket.close();
				} catch (IOException e) {
					System.err.println("Unable to close connection to " + socketAddress);
					e.printStackTrace();
				}
				System.out.println("Connection to " + socketAddress + " closed");
			}
		});
	}
	public abstract void runTask(Socket socket);
}