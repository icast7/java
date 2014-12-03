package _08SocketsForClients;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class LowPortScanner {

	public static void main(String[] args) {
		String host = args.length > 0  ? args[0] : "localhost";
		for (int i=1 ; i < 1024; i++){
			try {
				Socket s = new Socket(host, i);
				System.out.println("Server on port " + i + " of " + host);
				s.close();
			} catch (UnknownHostException ex){
				System.err.println(ex);
				break;
			} catch (IOException ex){
				System.err.println("Server NOT on port " + i + " of " + host);
			}
		}

	}

}
