/**
 * This is the exception packages
 */
package com.core.ex1.k_11exception;

import java.util.Scanner;

/**
 * @author icastillejos
 * @version 1.0.0
 */
public class StackTraceTest1 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter n:");
		int n = in.nextInt();
		factorial(n);
	}
	
	public static int factorial(int n){
		/**
		 * Computes the factorial of a number
		 * */
		System.out.println("factorial("+ n +"):");
		Throwable t = new Throwable();
		StackTraceElement[] frames = t.getStackTrace();
		for (StackTraceElement f : frames){
			System.out.println(f);
		}
		
		int r;
		if (n<= 1) r=1;
		else r=n*factorial(n-1);
		System.out.println("return "+r);
		return r;
	}
	
	
}
