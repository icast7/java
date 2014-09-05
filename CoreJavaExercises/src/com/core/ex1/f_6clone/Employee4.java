/**
 * 
 */
package com.core.ex1.f_6clone;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Cloneable class
 * @author icastillejos
 */
public class Employee4 implements Cloneable {
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee4(String name, double salary){
		this.name = name;
		this.salary = salary;
		this.hireDay = new Date();
	}
	
	public Employee4 clone() throws CloneNotSupportedException{
		//Call object.Clone to make shallow copy
		Employee4 cloned = (Employee4) super.clone();
		
		//clone mutable fields
		cloned.hireDay = (Date) hireDay.clone();
		
		return cloned;
	}
	
	@Override
	public String toString(){
		return "Employee[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay +"]";
	}
	
	/**
	 * Set hire day
	 * @param year
	 * @param month
	 * @param day
	 */
	public void setHireDay(int year, int month, int day){
		Date newHireDay = new GregorianCalendar(year, month -1, day).getTime();
		//Example of instance field mutation
		hireDay.setTime(newHireDay.getTime());
	}
	
	public void raiseSalary(double byPercent){
		double raise = salary * byPercent/100;
		salary += raise;
	}
}
