package com.core.ex1.f_6interface;

import java.util.Arrays;

/**
 * Test IComparable
 *@author icastillejos
 *@version 1.0.0
 */
public class EmployeeSortTest1 {
	public static void main(String[] args){
		Employee2[] staff = new Employee2[3];
		staff[0] = new Employee2("Harry Hacker", 35000);
		staff[1] = new Employee2("Carl Cracker", 75000);
		staff[2] = new Employee2("Tony Tester", 3000);
		Arrays.sort(staff);
		
		for (Employee2 e2: staff){
			System.out.println("name="+e2.getName()+",salary="+e2.getSalary());
		}
	}

}
