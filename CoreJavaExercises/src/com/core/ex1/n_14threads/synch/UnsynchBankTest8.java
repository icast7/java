package com.core.ex1.n_14threads.synch;
/***
 * Shows data corruption when multiple threads access a data structure
 * */
public class UnsynchBankTest8 {
	public static final int NACCS = 100;
	public static final double INIT_BAL = 1000;
	
	public static void main(String[] args){
		Bank8 b = new Bank8(NACCS, INIT_BAL);
		int i;		
		for (i =0 ; i<NACCS; i++){
		TransferRunnable8 r = new TransferRunnable8(b, i, INIT_BAL);
		Thread t = new Thread(r);
		t.start();
		}
	}
}
