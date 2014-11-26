package _12UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DayTimeUDPServer {
	private final static int PORT = 5000;
	private final static Logger audit = Logger.getLogger("requests");
	private final static Logger errors = Logger.getLogger("errors");
	
	public static void main(String[] args){
		try(DatagramSocket socket = new DatagramSocket(PORT)){
			while(true){
				try {
					DatagramPacket request = new DatagramPacket(new byte[1024], 1014);
					socket.receive(request);
					
					String daytime = new Date().toString();
					byte[] data = daytime.getBytes("US-ASCII");
					DatagramPacket response = new DatagramPacket(data, data.length, request.getAddress(), request.getPort());
					socket.send(response);
					audit.info(daytime + " " + request.getAddress());
					
				} catch (IOException | RuntimeException ex){
					errors.log(Level.SEVERE, ex.getMessage(), ex);
				}
			}
		} catch (IOException ex){
			errors.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}
}
