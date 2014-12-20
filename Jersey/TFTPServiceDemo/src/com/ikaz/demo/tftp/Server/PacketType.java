package com.ikaz.demo.tftp.Server;

/**  TFTP Packet type enum for types defined on https://www.ietf.org/rfc/rfc1350.txt
 * 
 * @author icastillejos
 * @version 0.0.1
 */
public enum PacketType {
	/*  TFTP supports five types of packets, all of which have been mentioned above:
	  opcode  operation
	    1     Read request (RRQ)
	    2     Write request (WRQ)
	    3     Data (DATA)
	    4     Acknowledgment (ACK)
	    5     Error (ERROR)
	 */
	RRQ(1, "RRQ", "Read request"), 
	WRQ(2, "WRQ", "Write request"),
	DATA(3,"DATA", "Data"),
	ACK(4, "WRQ", "Write request"),
	ERROR(5,"ERROR", "Error");
	
	private int code;
	private String type;
	private String description;
	
	private PacketType(int code, String type, String description){
		this.code = code;
		this.type = type;
		this.description = description;
	}
	
	public int getCode(){
		return this.code;
	}
	
	public String getType(){
		return this.type;
	}
	
	public PacketType getTFTPPacketType(int code){
		for (PacketType tftpPacketType : PacketType.values()){
			if (tftpPacketType.getCode() == code){
				return tftpPacketType;
			}
		}
		return null;
	}
}
