package _12UDP.dgchannel.trivial;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

import javax.imageio.IIOException;

import _12UDP.dgchannel.trivial.util.ConnectionStatus;
import _12UDP.dgchannel.trivial.util.ErrorCode;
import _12UDP.dgchannel.trivial.util.PacketType;
import _12UDP.dgchannel.trivial.util.packet.ACKPacket;
import _12UDP.dgchannel.trivial.util.packet.DATAPacket;
import _12UDP.dgchannel.trivial.util.packet.ERRORPacket;
import _12UDP.dgchannel.trivial.util.packet.TFTPPacket;
import _12UDP.dgchannel.trivial.util.packet.XRQPacket;

public class TFTPServer {

		
		//public final static int PORT = 7;
		public final static int PORT = 5007;
		public final static int MAX_PACKET_SIZE =  1024;
		public final static int MAX_PAYLOAD_SIZE =  512;
		
		public static void main(String[] args){
			try {
				DatagramChannel channel = DatagramChannel.open();
				DatagramSocket socket = channel.socket();
				SocketAddress address = new InetSocketAddress(PORT);
				socket.bind(address);
				ByteBuffer buffer = ByteBuffer.allocate(MAX_PACKET_SIZE);
				//ConnectionStatus s = ConnectionStatus.IDLE;
				while(true){
					SocketAddress client = channel.receive(buffer);
					TFTPPacket response = buildResponsePackage(buffer);	
					//Clear the buffer
					buffer.clear();
					
					//Respond
					buffer.put(response.getArray());
					buffer.flip();
					channel.send(buffer, client);
					buffer.clear();
				}
			} catch (IOException ex){
				System.err.println(ex);
			}
		}

		private static TFTPPacket buildResponsePackage(ByteBuffer buffer)
				throws UnsupportedEncodingException {
			//Build received packet
			TFTPPacket p = TFTPPacket.getReceivedPacket(buffer);
			//Create response packet
			switch(p.getPacketType()) {
				case RRQ:
					//Return DATAPACKET with Block #
					String fileNameR= ((XRQPacket)p).getFileName();
					File fR = new File("TFTPFolder", fileNameR);
					
					try (FileChannel in = new FileInputStream(fR).getChannel()){
						ByteBuffer readBuffer = ByteBuffer.allocate(MAX_PAYLOAD_SIZE);
						in.read(readBuffer);
						return new DATAPacket((short) 0, readBuffer.array());
					} catch (FileNotFoundException e) {
						//Print stack trace and return ERROR if file not found
						e.printStackTrace();
						//Return ERROR if file DOES NOT exists
						return new ERRORPacket(ErrorCode.FILE_NOT_FOUND);
					} catch (IOException e) {
						e.printStackTrace();
					}
				case WRQ:
					String fileNameW= ((XRQPacket)p).getFileName();
					
					if (Files.exists(Paths.get("TFTPFolder", fileNameW), LinkOption.NOFOLLOW_LINKS)) {
						//Return ERROR if file exists
						return new ERRORPacket(ErrorCode.FILE_EXISTS);
					} else {
						//Return ACK with Block  0
						return new ACKPacket((short) 0);
					}
				case ACK:
					//if ()
					
				case DATA:
					
				case ERROR:
					
				default:
					break;
			}	
			return null;
		}
}