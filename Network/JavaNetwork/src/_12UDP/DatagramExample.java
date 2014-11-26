package _12UDP;

import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class DatagramExample {
	//private static final String encoding = "US-ASCII";
	private static final String encoding = "UTF-8";
	
	public static void main(String[] args) {

		String s = "This is a test.";
		
		try{
			byte[] data = s.getBytes(encoding);
			InetAddress ia = InetAddress.getByName("www.ibiblio.org");
			int port = 7;
			DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);
			System.out.println("This packet is addresses to:" + dp.getAddress() + 
							   " On port:" +  dp.getPort());
			System.out.println("There are " + dp.getLength() + " bytes of data in the packet");
			System.out.println(new String(dp.getData(), dp.getOffset(), dp.getLength(), encoding));
			
		} catch (UnknownHostException | UnsupportedEncodingException ex){
			System.err.println(ex);
		}

	}

}
