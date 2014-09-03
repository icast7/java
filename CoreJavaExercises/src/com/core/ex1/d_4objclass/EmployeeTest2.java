package com.core.ex1.d_4objclass;

import java.util.Date;
import java.util.GregorianCalendar;

public class EmployeeTest2 {
	public static void main(String[] args){
		Employee2[] staff =  new Employee2[3];
		staff[0] = new Employee2("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee2("Harry Hacker", 50000, 1989, 10,1);
		staff[2] = new Employee2("Tony Tester", 40000, 1990, 3, 15);
		
		for (Employee2 e: staff)
			e.raiseSalary(5);
		
		for (Employee2 e: staff)
			System.out.println("name="+ e.getName()+",salary"+e.getSalary()+",hireDay="+e.getHireDay());
	}
}

class Employee2{
	private String name;
	private double salary;
	private Date hireDay;

	public Employee2(String n, double s, int year, int month, int day){
		this.name = n;
		this.salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month -1, day);
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
	
	public void raiseSalary(double byPercent){
		double raise = salary*byPercent/100;
		salary+= raise;
	}

}
