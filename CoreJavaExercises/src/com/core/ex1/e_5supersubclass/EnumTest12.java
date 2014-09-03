/**
 * In this package because it is only one file
 */
package com.core.ex1.e_5supersubclass;
import java.util.*;

/**
 * Enum tests from the book
 * @author icastillejos
 */
public class EnumTest12 {
	
	public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.print("Enter a size: (SMALL,MEDIUM,LARGE,EXTRA_LARGE)");
	String input = in.next().toUpperCase();
	Size size = Enum.valueOf(Size.class, input);
	System.out.println("size="+ size);
	System.out.println("abbreviation="+size.getAbbreviation());
	if (size == Size.EXTRA_LARGE){
		System.out.println("Good job, you paid attention to the underscre character...");
	}
	
	}
}	

enum Size{
	SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
	
	private String abbreviation;
	
	private Size(String abbreviation){
		this.abbreviation = abbreviation;
	}		
	public String getAbbreviation(){
		return this.abbreviation;
	}
}
