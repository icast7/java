package _04InetAddresses;

import java.net.InetAddress;
import java.util.concurrent.Callable;

public class WebLogLookupTask implements Callable<String>{
	private String line;
	
	public WebLogLookupTask(String line){
		this.line = line;
	}
	
	@Override
	public String call() throws Exception {
		try {
			//Separate ip address
			int index = line.indexOf(' ');
			String address = line.substring(0, index);
			String theRest = line.substring(index);
			String hostname = InetAddress.getByName(address).getHostName();
			return hostname + " " + theRest;
		} catch (Exception ex) {
			return line;
		}
	}
}