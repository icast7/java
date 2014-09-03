package com.core.ex2.c_3networking;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * @version 1.0
 * @author ikaz
 *
 */
public class InetAddressTest2 {
	public static void main(String[] args) throws IOException{
		if (args.length >0){
			String host = args[0];
			InetAddress[] addresses;
			addresses = InetAddress.getAllByName(host);
			for (InetAddress a : addresses){
					System.out.println(a);
			}
		} else {
			InetAddress localHostAddress;
				localHostAddress = InetAddress.getLocalHost();
				System.out.println(localHostAddress);
		}		
	}
}
