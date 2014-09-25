package com.core.ex1.n_14threads.synch;
/**
 * Runnable that transfers money
 * **/
public class TransferRunnable8 implements Runnable{
	private Bank8 bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY = 10;
	/**
	 * Transfer runnable constructor
	 * */
	public TransferRunnable8(Bank8 b, int from, double max){
		bank = b;
		fromAccount = from ;
		maxAmount = max;
	}
	
	@Override
	public void run() {
		try{
			while(true){
				int toAccount = (int) (bank.size() * Math.random());
				double amount = maxAmount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((int)(DELAY*Math.random()));
				Thread.sleep((int)(DELAY*Math.random()));
				Thread.sleep((int)(DELAY*Math.random()));
			}
		} catch (InterruptedException e){
		}
	}
}
