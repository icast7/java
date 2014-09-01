package com.core.ex1.supersubclass5.inheritance;
/**
 * Class Manager3
 * @author icastillejos
 * */
public class Manager3 extends Employee2{
	private double bonus;
	
	
	/**
	 * @param n
	 * @param s
	 * @param year
	 * @param month
	 * @param day
	 */
	public Manager3(String n, double s, int year, int month, int day){
		//call super constructor, same constructor signature
		super(n, s, year, month, day);
		bonus = 0;
	}
	
	public double getSalary()
	{
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	
	public void setBonus(double b){
		bonus = b;
	}

}
