/**
 * 
 */
package com.core.ex1.objclass4.newpackage;

/* Import statements obviously come after package definition*/
import java.util.*;

/**
 * This is the class Employee for testing PackageTest.java
 * @author icastillejos
 *
 */
public class Employee6 {
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee6(String n, double s, int year, int month, int day) {
		this.name = n;
		this.salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month -1, day);
		//Gregorian calendar uses 0 for January
		hireDay = calendar.getTime();
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
	
	public void raiseSalary(double byPercent){
		double raise = salary * byPercent/100;
		salary += raise;
	}
}
