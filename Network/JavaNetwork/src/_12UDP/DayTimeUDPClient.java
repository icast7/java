package _12UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DayTimeUDPClient {
	private final static int PORT = 13;
	private static final String HOSTNAME =  "time.nist.gov";
	
	public static void main(String[] args){
		try (DatagramSocket socket = new DatagramSocket(5000)){
			socket.setSoTimeout(60000);
			InetAddress host = InetAddress.getByName(HOSTNAME);
			//byte[] reqData = new byte[1];
			//reqData[0] =  (byte)0;
			DatagramPacket request = new DatagramPacket(new byte[1], 1, host, PORT);
			DatagramPacket response= new DatagramPacket(new byte[1024], 1024);
			System.out.println(request.getAddress() +":::"+ request.getData() +"::::" + request.getPort());
			socket.send(request);
			socket.receive(response);
			String result = new String(response.getData(), 0, response.getLength(), "US-ASCII");
			System.out.println(result);
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}

}
