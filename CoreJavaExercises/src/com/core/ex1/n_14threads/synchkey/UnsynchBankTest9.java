package com.core.ex1.n_14threads.synchkey;
/***
 * Shows data corruption when multiple threads access a data structure
 * */
public class UnsynchBankTest9 {
	public static final int NACCS = 100;
	public static final double INIT_BAL = 1000;
	
	public static void main(String[] args){
		Bank9 b = new Bank9(NACCS, INIT_BAL);
		int i;		
		for (i =0 ; i<NACCS; i++){
		TransferRunnable9 r = new TransferRunnable9(b, i, INIT_BAL);
		Thread t = new Thread(r);
		t.start();
		}
	}
}
