package _02Streams;

import java.io.IOException;
import java.io.OutputStream;
/*
 * rfc864
 */
public class CharacterGeneratorProtocol {

	public static void main(String[] args) throws IOException{
		//getCharsAsInt(System.out);
		getCharsAsByteArray(System.out);
	}

	public static void getCharsAsInt(OutputStream out) throws IOException{
		int firstPrintableChar = 33;
		int numOfPrintableChars= 94;
		int numOfCharsPerLine = 72;
		
		int start = firstPrintableChar;
		while (true){ /*infinite loop*/
			for (int i = start; i < start + numOfCharsPerLine; i++){
				out.write(((i - firstPrintableChar) % numOfPrintableChars) + firstPrintableChar);
			}
			out.write('\r');//CR
			out.write('\n');//LF
			start = ((start + 1) - firstPrintableChar) % numOfPrintableChars + firstPrintableChar;
		}
	}
	
	public static void getCharsAsByteArray(OutputStream out) throws IOException{
		int firstPrintableChar = 33;
		int numOfPrintableChars= 94;
		int numOfCharsPerLine = 72;
		
		int start = firstPrintableChar;
		byte[] line = new byte[numOfCharsPerLine + 2];//2 is for CRLF
		while (true){ /*infinite loop*/
			for (int i = start; i < start + numOfCharsPerLine; i++){
				line[i-start] = (byte) (((i - firstPrintableChar) % numOfPrintableChars) + firstPrintableChar);
			}
			line[72] = (byte) '\r';//CR
			line[73] = (byte) '\n';//LF
			out.write(line);
			start = ((start + 1) - firstPrintableChar) % numOfPrintableChars + firstPrintableChar;
		}
	}
}
