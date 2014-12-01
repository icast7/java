package _12UDP.dgchannel.trivial.util;



public class ConnectionStatus{
	public enum Status {IDLE, READING, WRITING};
	
	private Status status;
	private short blockNumber; 

	public ConnectionStatus(Status status,short blockNumber){
		
	}
	
	public Status getStatus() {
		return status;
	}

	public short getBlockNumber() {
		return blockNumber;
	}
}
