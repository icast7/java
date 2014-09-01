/**
 * 
 */
package com.core.ex1.supersubclass5;

import java.util.ArrayList;

import com.core.ex1.supersubclass5.abstractTest.Employee;

/**
 * ArrayList test
 * @author icastillejos
 */
public class ArrayListTest11 {
	public static void main(String[] args){
		//fill list with 3 Employee objects
		ArrayList<Employee> staff = new ArrayList<>();
		
		staff.add(new Employee("Carl Panda", 75000, 1987, 9, 12));
		staff.add(new Employee("Harry Cane", 50000, 1989,10,1));
		staff.add(new Employee("Tony Brave", 40000, 1990, 3,15));
		
		//raise everyone's salary
		for(Employee e : staff){
			e.raiseSalary(5);
		}
		//Print
		for(Employee e : staff){
			System.out.println("name="+e.getName()+",salary="+e.getSalary()+",hireDay="+e.getHireDay());
		}
	}
}
