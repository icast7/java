package com.core.ex1.javapenv2;

public class Welcome1 {
	
	public static void main(String[] args)
	{
		String[] greeting = new String[3];
		greeting[0] = " Welcome to core Java";
		greeting[1] = " by Me ";
		greeting[2] = " corp ";
		
		for (String s : greeting){
			System.out.println(s);
		}
	}
}
