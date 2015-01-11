package _04InetAddresses;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SpamCheck {
	

	public static void main(String[] args) throws UnknownHostException {
		if (args.length ==0){
			args = new String[]{"207.34.56.23","125.12.32.4","130.130.130.130"};
		}
		for (String arg: args){
			if (isSpammer(arg)){
				System.out.println(arg + " is a known spammer.");
			} else {
				System.out.println(arg + " is a appears to be legit.");
			}
		}
	}

	public static final String BLACKHOLE = "sbl.spamhaus.org";
	
	private static boolean isSpammer(String arg) {
		try {
			InetAddress address = InetAddress.getByName(arg);
			byte[] quad = address.getAddress();
			String query = BLACKHOLE;
			for (byte octect : quad){
				int unsignedByte = (octect < 0) ? (octect + 256) : (octect);
				query = unsignedByte + "." + query;
			}
			InetAddress.getByName(query);
			return true;
		} catch (UnknownHostException e){
			return false;
		}
	
	}
}
