package _12UDP;

import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPPortScanner {

	public static void main(String[] args) {
		for (int port =1024; port <= 65535; port++){
			try {
				//Exception is thrown is port is already taken
				DatagramSocket server = new DatagramSocket(port);
				//System.out.println(server.getLocalPort());
				server.close();
			} catch (SocketException se){
				System.out.println("There is a server on port "+ port +"!!!\n"+se.getMessage());
			}
		}
	}

}
