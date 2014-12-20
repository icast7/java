package com.ikaz.demo.tftp.Server;

/**
 * Error code enum for error codes defined on https://www.ietf.org/rfc/rfc1350.txt
 * @author icastillejos
 * @version 0.0.1
 */
public enum ErrorCode {
	/*
	Error Codes
	   Value     Meaning
	
	   0         Not defined, see error message (if any).
	   1         File not found.
	   2         Access violation.
	   3         Disk full or allocation exceeded.
	   4         Illegal TFTP operation.
	   5         Unknown transfer ID.
	   6         File already exists.
	   7         No such user. 
	  
	 */
	
	NOT_DEFINED(0, "Not defined, see error message (if any)."), 
	FILE_NOT_FOUND(1, "File not found."),
	ACCESS_VIOLATION(2, "Access violation."),
	DISK_FULL(3, "Disk full or allocation exceeded."),
	ILLEGAL_OPERATION(4, "Illegal TFTP operation."),
	UNKNOWN_TRANSFER_ID(5, "Unknown transfer ID."),
	FILE_EXISTS(6, "File already exists."),
	NO_SUCH_USER(7, "No such user.");
	
	private int code;
	private String description;
	
	private ErrorCode(int code, String description){
		this.code = code;
		this.description = description;
	}
	
	public int getCode(){
		return this.code;
	}
	
	public ErrorCode getErrorCode(int code){
		for (ErrorCode errorCode : ErrorCode.values()){
			if (errorCode.getCode() == code){
				return errorCode;
			}
		}
		return null;
	}
}
