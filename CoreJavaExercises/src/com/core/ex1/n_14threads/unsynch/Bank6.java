package com.core.ex1.n_14threads.unsynch;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This is just a bank with a number of accts
 * **/
public class Bank6 {

	private double[] accounts;
	/**
	 * Constructor
	 * */
	public Bank6(int n, double initBal) {
		accounts = new double[n];
		for (int i =0; i < accounts.length;  i++){
			accounts[i] = initBal;
		}
	}
	
	/*
	 * Transfer balances from one account to another
	 */
	private Lock bankLock = new ReentrantLock();
	
	public void transfer(int from, int to, double amount){
		bankLock.lock();
		try{
			System.out.print(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf(" %10.2f from %d to %d", amount, from, to);
			accounts[to] += amount;
			System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());	
		} finally {
			bankLock.unlock();
		}	
		
//		if (accounts[from] < amount){
//			return;
//		}
//		System.out.print(Thread.currentThread());
//		accounts[from] -= amount;
//		System.out.printf(" %10.2f from %d to %d", amount, from, to);
//		accounts[to] += amount;
//		System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());		
	}
	
	/**
	 * Get sum of all accounts balances
	 * */
	public double getTotalBalance(){
		double sum = 0;
		for (double a: accounts){
			sum +=a;
		}
		return sum;
	}
	
	/**
	 * Get the number of accounts in the bank
	 * */
	public int size(){
		return accounts.length;
	}
}
