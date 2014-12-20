package _04InetAddresses;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class IPCharacteristics {
	public static void main(String[] args){
		//String address = (args.length > 0) ? (args[0]) :("127.0.0.1");
		List<String> addressList = 
		Arrays.asList("127.0.0.1", "192.168.254.32", "224.0.2.1", "FF01:0:0:0:0:0:0:1"
					, "FF05:0:0:0:0:0:0:101", "0::1", "www.oreilly.com");
		for (String address : addressList){
		try {
			InetAddress a = InetAddress.getByName(address);
			if (a.isAnyLocalAddress()){
				System.out.println(a + " is a wildcard address.");
			}
			if (a.isLoopbackAddress()){
				System.out.println(a + " is loopback address.");
			}
			
			if (a.isLinkLocalAddress()){
				System.out.println(a + " is a link-local address."); 
			} else if (a.isSiteLocalAddress()) {
				System.out.println(a + " is a site-local address.");
			} else {
				System.out.println(a + " is a global address.");
			}
			
			if (a.isMulticastAddress()){
				if (a.isMCGlobal()){
					System.out.println(a + " is a global multicast address.");
				} else if (a.isMCOrgLocal()){
					System.out.println(a + " is an org wide multicast address.");
				} else if (a.isMCSiteLocal()){
					System.out.println(a + " is a site wide multicast address.");
				} else if (a.isMCLinkLocal()){
					System.out.println(a + " is a subnet wide multicast address.");
				} else if (a.isMCNodeLocal()){
					System.out.println(a + " is a interface-local multicast address.");
				} else {
					System.out.println(a + " is an unknown multicast addresstype.");
				}
			} else {
				System.out.println(a + " is a unicast address.");
			}
		} catch (UnknownHostException e) {
			System.err.println(e.getCause() + "::: Could not resolve "+ address);
		}
		}
	}
}
