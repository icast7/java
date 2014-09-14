/**
 * 
 */
package com.core.ex1.supersubclass5.inheritance;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Class Employee2
 * @author icastillejos
 */
public class Employee2 {
	private String name;
	private double salary;
	private Date hireDay;
	
	/**
	 * @param n
	 * @param s
	 * @param year
	 * @param month
	 * @param day
	 */
	public Employee2(String n, double s, int year, int month, int day){
		//Implicit = explicit
		this.name =n;
		//Implicit = explicit
		this.salary = s;
		//Implicit = explicit, use signature with year, month and day
		GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);
		this.hireDay = calendar.getTime();
	}
	
	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Date getHireDay() {
		return hireDay;
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent/100;
		salary += raise;
	}

}
