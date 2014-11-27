package _12UDP.poke;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import _12UDP.poke.UDPPoke;

public class UDPTimeClient {
	public final static int PORT = 37;
	public final static String DEFAULT_HOST = "time.nist.gov";
	
	
	public static void main(String[] args) {
		InetAddress host;
		try {
			if (args.length > 0){
				host = InetAddress.getByName(args[0]);
			} else {
				host = InetAddress.getByName(DEFAULT_HOST);
			}
		} catch (RuntimeException | UnknownHostException  ex){
			System.out.println("Usage: java UDPTimeClient [host]");
			return;
		}
		
		UDPPoke poker = new UDPPoke(host, PORT);
		byte[] response = poker.poke();
		if (response == null){
			System.out.println("No response within alloted time");
			return;
		} else if (response.length != 4){
			System.out.println("Unrecognized response format");
			return;
		}
		
		//Diff between 1900 and 1970 epochs
		long diffBetweenEpochs = 2208988800L;
		
		long secondsSince1900 = 0L;
		for (int i= 0; i < 4; i++){
			secondsSince1900 =  (secondsSince1900 << 8 ) | (response[i] & 0x000000FF);
		}
		
		long secondsSince1970 =  secondsSince1900 - diffBetweenEpochs;
		long msSince1970 = secondsSince1970 * 1000;
		Date time = new Date(msSince1970);
		
		System.out.println(time);
	}

}
