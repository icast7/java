package com.core.ex1.m_13collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/***
 * This is a Set that prints unique words entered in the console
 * @author icastillejos
 */
public class SetTest2 {
	public static void main(String[] args){
		Set<String> words = new HashSet<String>();
		long totalTime = 0;
		
		Scanner in = new Scanner(System.in);
		while (in.hasNext()){
			String word = in.next();
			long callTime = System.currentTimeMillis();
			words.add(word);
			callTime = System.currentTimeMillis() - callTime;
			totalTime += callTime;
		}
		
		Iterator<String> iter = words.iterator();
		for (int i = 0; i <= 20 && iter.hasNext(); i++){
			System.out.println(iter.hasNext());
		}
		System.out.println("...");
		System.out.println(words.size() + " distinct words.\n");
		System.out.println(totalTime + " milliseconds.");
	}
}
