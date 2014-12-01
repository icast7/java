package _12UDP.dgchannel.trivial.util.packet;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import _12UDP.dgchannel.trivial.util.ErrorCode;
import _12UDP.dgchannel.trivial.util.PacketType;

/**
 * This represents an ERROR packet
 *         		2 bytes  2 bytes        string    1 byte
 *	          ----------------------------------------
 *	   ERROR | 05    |  ErrorCode |   ErrMsg   |   0  |
 *	          ----------------------------------------
 * @author icastillejos
 * @version 0.0.1
 */
public final class ERRORPacket extends TFTPPacket {
	private short errorCode;
	private String errorMsg;	
	
	public ERRORPacket(ErrorCode errorCode) throws UnsupportedEncodingException {
		super(PacketType.ERROR);
		this.errorCode = (short) errorCode.getCode();

		byte[] packetTypeArray = PacketType.ERROR.getTypeArray();	
		
		ByteBuffer errorCodeBB = ByteBuffer.allocate(2);
		errorCodeBB.putShort(errorCode.getCode());
		byte[] errorCodeBytes = errorCodeBB.array();
		
		ErrorCode err = ErrorCode.getErrorCode(errorCode.getCode());
		byte[] errorMsgBytes = err.getMsg().getBytes("US-ASCII");
		
		this.setArray(packetTypeArray, errorCodeBytes, errorMsgBytes);
	}

	public short getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
}