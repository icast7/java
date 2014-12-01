package _12UDP.dgchannel.trivial.util.packet;

import java.io.UnsupportedEncodingException;

import _12UDP.dgchannel.trivial.util.PacketType;
import _12UDP.dgchannel.trivial.util.TransferMode;

/**
 * This represents an *RQ packet
 *  		2 bytes    string   1 byte     string   1 byte
 *	        -----------------------------------------------
 *	 RRQ/  | 01/02 |  Filename  |   0  |    Mode    |   0  |
 *	 WRQ    -----------------------------------------------
 *  
 * @author icastillejos
 * @version 0.0.1
 */
public final class XRQPacket extends TFTPPacket {
	private TransferMode transferMode;
	private String fileName;
	
	public XRQPacket(PacketType packetType, String fileName, TransferMode transferMode) throws UnsupportedEncodingException {
		super(packetType);
		this.fileName = fileName;
		this.transferMode = transferMode;
		//ToDo
		//Throw exception if packetType is not RRQPacket or WRQPacket
		byte[] packetTypeArray = packetType.getTypeArray();	
		byte[] fileNameArray = fileName.getBytes("US-ASCII");
		byte[] modeArray = transferMode.getModeName().getBytes("US-ASCII");
		this.setArray(packetTypeArray, fileNameArray, separator,modeArray, separator);
	}
	
	public String getFileName(){
		return this.fileName;
	}
	
	public TransferMode getMode(){
		return this.transferMode;
	}
}
