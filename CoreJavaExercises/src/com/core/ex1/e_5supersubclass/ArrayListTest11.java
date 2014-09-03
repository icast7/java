/**
 * 
 */
package com.core.ex1.e_5supersubclass;

import java.util.ArrayList;

import com.core.ex1.e_5supersubclass.abstractTest.Employee6;

/**
 * ArrayList test
 * @author icastillejos
 */
public class ArrayListTest11 {
	public static void main(String[] args){
		//fill list with 3 Employee objects
		ArrayList<Employee6> staff = new ArrayList<>();
		
		staff.add(new Employee6("Carl Panda", 75000, 1987, 9, 12));
		staff.add(new Employee6("Harry Cane", 50000, 1989,10,1));
		staff.add(new Employee6("Tony Brave", 40000, 1990, 3,15));
		
		//raise everyone's salary
		for(Employee6 e : staff){
			e.raiseSalary(5);
		}
		//Print
		for(Employee6 e : staff){
			System.out.println("name="+e.getName()+",salary="+e.getSalary()+",hireDay="+e.getHireDay());
		}
	}
}
