package _08SocketsForClients;

import java.io.*;
import java.net.*;
import java.text.*;
import java.util.Date;

public class DayTimeClient {

	/**
	 * Main Method
	 * @param args
	 * @throws ParseException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, ParseException {
		getDateFromNIST(); 
	}

	public static Date getDateFromNIST() throws IOException, ParseException {
		String hostname = "time.nist.gov";
		try (Socket s = new Socket(hostname, 13)) {
			s.setSoTimeout(15000);
			InputStream in = s.getInputStream();
			StringBuilder time = new StringBuilder();
			InputStreamReader reader = new InputStreamReader(in, "ASCII");
			
			for (int c = reader.read(); c!= -1; c= reader.read()){
				time.append((char)c);
			}
			
			System.out.println(time);
			return parseDate(time.toString());
			
		}
	}

	private static Date parseDate(String dateString) throws ParseException {
		String[] pieces = dateString.split(" ");
		String dateTime = pieces[1] + " " + pieces[2] + " UTC";
		DateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss z");
		return format.parse(dateTime);
	}
}
