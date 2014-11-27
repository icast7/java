package _12UDP.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class FastUDPDiscardServer extends UDPServer {
	//public static final int DEFAULT_PORT = 9;
	public static final int DEFAULT_PORT = 5009;
	
	public FastUDPDiscardServer() {
		super(DEFAULT_PORT);
	}

	public static void main(String[] args) {
		UDPServer server = new FastUDPDiscardServer();
		Thread t = new Thread(server);
		t.start();
	}

	@Override
	public void respond(DatagramSocket socket, DatagramPacket request){
	}

}
