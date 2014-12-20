package _04InetAddresses;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyLocalAddress {

	public static void main(String[] args) {
		try {
			InetAddress m =  InetAddress.getLocalHost();
			String dQuad =  m.getHostAddress();
			System.out.println("My address is: "+dQuad);
			System.out.println("Version : "+ getVersion(m));
		} catch (UnknownHostException e){
			System.out.println(e.getMessage() + "::: Don't know my own address!!!");
		}
	}
	
	public static int getVersion(InetAddress ia) {
		byte[] address = ia.getAddress();
		if(address.length == 4) 
			return 4;
		else if (address.length == 16)
			return 6;
		else 
			return -1;
	}
}
