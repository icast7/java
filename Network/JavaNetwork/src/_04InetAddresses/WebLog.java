package _04InetAddresses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WebLog {
	public static void main(String[] args){
		long start = System.nanoTime();
		if (args.length == 0){	
			String fullclass =  WebLog.class.getName();
			String pack = fullclass.substring(0, fullclass.indexOf('.'));
			String base = WebLog.class.getClassLoader().getResource("").getPath();
			String log = base + pack+"/myweblog.txt";
			args = new String[]{log};
		}
		try (
				FileInputStream fin = new FileInputStream(args[0]);
				Reader in = new InputStreamReader(fin);
				BufferedReader bin = new BufferedReader(in);
				) 
			{
			for (String entry =  bin.readLine(); entry != null; entry = bin.readLine()){
				//Get the ip address
				int index = entry.indexOf(' ');
				String ip = entry.substring(0, index);
				String theRest = entry.substring(index);
				//Query DNS for the hostname
				try {
					InetAddress address = InetAddress.getByName(ip);
					System.out.println(address.getHostName() + theRest);
				} catch (UnknownHostException ex){
					System.err.println(entry);
				}
			}
		} catch (IOException ex){
			System.out.println("Exception:"+ex);
		}
		long end = System.nanoTime();
		System.out.println("Duration:"+(end-start)/1000000+"ms");
	}
}
