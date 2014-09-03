package com.core.ex1.e_5supersubclass.abstractTest;

public class Student7 extends Person5{
	private String major;
	
	/**
	 * @param n -> name
	 * @param m -> major
	 */
	public Student7(String n, String m){
		super(n);
		this.major =m;
	}
	
	public String getDescription(){
		return "a student majoring in " + major;
	}

}
