package _08SocketsForClients;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeProtocolClient {
	private static final String HOSTNAME = "time.nist.gov";
	
	public static void main(String[] args) throws IOException, ParseException {
		Date d = TimeProtocolClient.getDateFromNetwork();
		System.out.println("It is " +  d);

	}
	
	public static Date getDateFromNetwork() throws IOException, ParseException{
		//Time protocol starts at 1900
		//Java Date class at 1970
		long diffBetweenEpochs = 2208988800L;
		
		Socket s = null;
		try {
			s = new Socket(HOSTNAME, 37);
			s.setSoTimeout(15000);
			
			InputStream raw = s.getInputStream();
			
			long secSince1900 = 0;
			for (int i =0; i<4; i++){
				secSince1900 = (secSince1900 << 8 ) | raw.read();
			}
			long secSince1970 = secSince1900 - diffBetweenEpochs;
			long msSince1970 = secSince1970 * 1000;
			Date time= new Date(msSince1970);
			return time;			
		} finally {
			try {
				if (s != null) 
					s.close();
			}
			catch (IOException ex) {
				
			} 
		}
		
	}
	
	private static long calcDiffBetweenEpochs(){
		TimeZone gmt = TimeZone.getTimeZone("GMT");
		Calendar epoch1900 = Calendar.getInstance(gmt);
		epoch1900.set(1900,  01, 01, 00, 00, 00);
		long epoch1900ms = epoch1900.getTime().getTime();
		
		Calendar epoch1970 = Calendar.getInstance(gmt);
		epoch1970.set(1970, 01,01,00,00,00);
		long epoch1970ms = epoch1970.getTime().getTime();
		
		long diffInMS= epoch1970ms - epoch1900ms;
		long diffBetweenEpochs = diffInMS/1000;
		return diffBetweenEpochs;
	} 
	


}
