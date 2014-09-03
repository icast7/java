package com.core.ex1.d_4objclass;

import java.util.*;

/**
 * Demonstrates object construction
 * @author icastillejos
 */
public class ConstructorTest5 {
	public static void main(String[] args){
		Employee5[] staff = new Employee5[3];
		
		staff[0] = new Employee5("Harry", 40000);
		staff[1] = new Employee5(60000);
		staff[2] = new Employee5();
		
		//print info
		for (Employee5 e : staff){
			System.out.println("name=" + e.getName() + ",id=" +  e.getId() + ",salary="+e.getSalary());
		}
	}
	
}

class Employee5{
	private static int nextId;
	
	private int id;
	private String name = "";
	private double salary;
	
	//Object init
	{
		id = nextId;
		nextId ++;
	}
	
	//static init block
	static
	{
		Random generator = new Random();
		// set next id to a random num between 0 and 9,999
		nextId = generator.nextInt(10000);
	}
	
	//three overloads constructors
	public Employee5(String n , double s){
		this.name = n;
		this.salary = s;
	}
	///Another constructor
	public Employee5(double s){
		this.salary = s;
	}
	//Default constructor
	public Employee5(){
		
	}
	
	public String getName(){
		return this.name;
	}
	
	public double getSalary(){
		return this.salary;
	}
	
	public int getId(){
		return this.id;
	}
}