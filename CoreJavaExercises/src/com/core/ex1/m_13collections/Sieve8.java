package com.core.ex1.m_13collections;

import java.util.BitSet;

public class Sieve8 {
	public static void main(String[] args){
		int n = 2000;
		long start = System.currentTimeMillis();
		BitSet b = new BitSet(n+1);
		
		int count = 0;
		int i;
		for (i = 2; i <= n; i++){
			b.set(i);
		}
		i = 2;
		while(i*i<=n){
			if (b.get(i)){
				count++;
				int k = 2*i;
				while(k<=n){
					b.clear(k);
					k+=i;
				}
			}
		}
		while(i<=n){
			if (b.get(i)) {
				count++;
			}
			i++;
		}
		long end = System.currentTimeMillis();
		System.out.println(count + " primes");
		System.out.println((end - start) + " milliseconds");
	}
}
