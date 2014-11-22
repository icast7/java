package _08SocketsForClients;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.Socket;

public class DictionaryClient {
	
	public static final String SERVER = "dict.org";
	public static final int PORT = 2628;
	public static final int TIMEOUT = 15000;
	
	public static void main(String[] args) {
		try (Socket s = new Socket(SERVER, PORT)) {
			s.setSoTimeout(TIMEOUT);
			
			OutputStream out = s.getOutputStream();			
			Writer writer = new OutputStreamWriter(out, "UTF-8");
			writer = new BufferedWriter(writer);
			
			InputStream in = s.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
			
			for (String word : args){
				define(word, writer, reader);
			}
			
			writer.write("quit\r\n");
			writer.flush();			
		} catch (IOException e){
			System.err.println(e);
		}		

	}

	private static void define(String word, Writer writer, BufferedReader reader) 
				 throws IOException, UnsupportedEncodingException {
		writer.write("DEFINE fd-eng-lat " + word + "\r\n");
		writer.flush();
		
		for (String line = reader.readLine(); line != null; line = reader.readLine()){
			//System.out.println(line);
			if (line.startsWith("250 ")){ //OK
				return;
			} else if (line.startsWith("552 ")){ //no def found
				System.out.println("No definition found for '" +  word + "'");
				return;
			}
			else if (line.matches("\\d\\d\\d .*")) continue;
			else if (line.trim().equals(".")) continue;
			else System.out.println(line);
		}
}
}
