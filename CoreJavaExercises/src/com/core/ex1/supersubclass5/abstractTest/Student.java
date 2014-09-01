package com.core.ex1.supersubclass5.abstractTest;

public class Student extends Person{
	private String major;
	
	/**
	 * @param n -> name
	 * @param m -> major
	 */
	public Student(String n, String m){
		super(n);
		this.major =m;
	}
	
	public String getDescription(){
		return "a student majoring in " + major;
	}

}
