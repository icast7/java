package com.core.ex1.e_5supersubclass.abstractTest;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee6 extends Person5{
	private double salary;
	private Date hireDay;
	
	public Employee6(String n, double s, int year, int month, int day){
		super(n);
		this.salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);
		hireDay = calendar.getTime();
	}
	
	public double getSalary() {
		return salary;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public String getDescription(){
		return String.format("an employee with a salary of $%.2f", this.salary);
	}
	
	public void raiseSalary(double byPercent){
		double raise = this.salary * byPercent/100;
		this.salary += raise;
	}
}
