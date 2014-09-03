package com.core.ex1.e_5supersubclass.abstractTest;

public abstract class Person5{
	public abstract String getDescription();
	private String name;
	
	public Person5(String n){
		this.name = n;
	}
	
	public String getName(){
		return this.name;
	}
}
