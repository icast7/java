package com.core.ex1.n_14threads.synchkey;

public class Bank9 {
	private final double[] accounts;

	/**
	 * Construct the bank
	 **/
	public Bank9(int num, double initBal){
		accounts = new double[num];
		for(int i = 0; i < accounts.length; i++){
			accounts[i] = initBal;
		}		
	}
	/*
	 * Transfer money
	 */
	public synchronized void transfer(int from, int to, double amount) throws InterruptedException{
		while(accounts[from] < amount){
			Thread.currentThread().wait();
		}
		System.out.print(Thread.currentThread());
		accounts[to] -= amount;
		System.out.printf("%10.2f from %d to %d", amount, from, to);
		accounts[to] += amount;
		System.out.printf("Total balance: %10.2f%n ", getTotalBalance());
		notifyAll();
	}
	/*
	 * Sum of all accounts balances.
	 * **/
	public synchronized double getTotalBalance(){
		double sum = 0;
		for (double a : accounts){
			sum += a;
		}
		return sum;
	}
	
	/**
	 * Gets the number of accounts in the bank
	 * */
	public int size(){
		return accounts.length;
	}
}
