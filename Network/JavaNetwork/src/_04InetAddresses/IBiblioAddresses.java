package _04InetAddresses;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IBiblioAddresses {

	public static void main(String[] args) {
		try {
			InetAddress ibiblio = InetAddress.getByName("news.google.com");
			InetAddress helios = InetAddress.getByName("www.google.com");
			System.out.println("Ibiblio:"+ibiblio.toString());
			System.out.println("Helios:"+helios.toString());
			if (ibiblio.equals(helios)){
				System.out.println("www.ibiblio.org is the same as helios.ibiblio.org.");
			} else {
				System.out.println("www.ibiblio.org is not the same as helios.ibiblio.org");
			}
		} catch (UnknownHostException ex){
			System.out.println("Host lookup failed.");
		}
	}

}
