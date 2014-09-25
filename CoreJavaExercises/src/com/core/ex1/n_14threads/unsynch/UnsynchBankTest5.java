package com.core.ex1.n_14threads.unsynch;
/***
 * Shows data corruption when multiple threads access a data structure
 * */
public class UnsynchBankTest5 {
	public static final int NACCS = 100;
	public static final double INIT_BAL = 1000;
	
	public static void main(String[] args){
		Bank6 b = new Bank6(NACCS, INIT_BAL);
		int i;		
		for (i =0 ; i<NACCS; i++){
		TransferRunnable7 r = new TransferRunnable7(b, i, INIT_BAL);
		Thread t = new Thread(r);
		t.start();
		}
	}
}
