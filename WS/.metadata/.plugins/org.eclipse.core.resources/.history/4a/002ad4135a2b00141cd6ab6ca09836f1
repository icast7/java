package com.core.ex1.javapenv2;

import java.util.Scanner;

public class Retirement {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		System.out.println("How much money do you ned to retire?");
		double goal = in.nextDouble();
		
		System.out.println("How much money will you contribute every year?");
		double payment = in.nextDouble();
		
		System.out.println("What is the interest rate in %?");
		double interestRate = in.nextDouble();
		
		double balance = 0;
		int years = 0;
		
		while(balance < goal){
			balance += payment;
			double interest = balance * interestRate/100;
			balance += interest;
			years++;			
		}
		StringBuilder s = new StringBuilder();
		s.append("You can retire in ");
		s.append(years);
		s.append(" years.");
		System.out.println(s.toString());
	}	
}
