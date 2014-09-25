package com.core.ex1.n_14threads.synch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Bank with locks for serializing access to accounts
 * **/
public class Bank8 {
	
	private final double[] accounts;
	private Lock bankLock;
	private Condition sufficientFunds;
	
	/**
	 * Constructor
	 * */
	public Bank8(int n, double initBal) {
		accounts = new double[n];
		for (int i =0; i < accounts.length;  i++){
			accounts[i] = initBal;
		}
		bankLock = new ReentrantLock();
		sufficientFunds = bankLock.newCondition();
	}
	
	/*
	 * Transfer balances from one account to another
	 */
	
	public void transfer(int from, int to, double amount) throws InterruptedException {
		bankLock.lock();
		try{
			while(accounts[from] < amount){
				sufficientFunds.await();
			}
			System.out.print(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf(" %10.2f from %d to %d", amount, from, to);
			accounts[to] += amount;
			System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());	
			sufficientFunds.signalAll();
		} finally {
			bankLock.unlock();
		}
	}
	
	/**
	 * Get sum of all accounts balances
	 * */
	public double getTotalBalance(){
		bankLock.lock();
		try {
			double sum = 0;
			
			for (double a: accounts){
				sum +=a;
			}
			return sum;
		} finally {
			bankLock.unlock();
		}
	}
	
	/**
	 * Get the number of accounts in the bank
	 * */
	public int size(){
		return accounts.length;
	}
}
