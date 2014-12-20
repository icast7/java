package com.ikaz.demo.tftp.Server;

/** Transfer modes defined on https://www.ietf.org/rfc/rfc1350.txt
 * 
 * @author icastillejos
 * @version 0.0.1
 */
public enum TransferMode {
	/*
	Tranfer Modes
	   Value     	Meaning	
	   netascii	"8 bit ASCII"
	   octect   "Raw 8 bit bytes"
	  - mail     Obsolete, should not be implemented
	 */
	NETASCII(0), 
	OCTECT(1);
	
	private int code;
	
	private TransferMode(int code){
		this.code = code;
	}
	
	public int getCode(){
		return this.code;
	}
}
