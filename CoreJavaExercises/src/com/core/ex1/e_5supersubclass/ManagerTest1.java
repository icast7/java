/**
 * 
 */
package com.core.ex1.e_5supersubclass;

import com.core.ex1.e_5supersubclass.inheritance.*;

/**
 * Test inheritance
 * @author icastillejos
 *
 */
public class ManagerTest1 {
	public static void main(String[] args){
		//create Manager
		Manager3 boss = new Manager3("Carl Cracker", 80000, 1987, 12, 15);
		boss.setBonus(5000);
		
		Employee2[] staff = new Employee2[3];
		staff[0] = boss;
		staff[1] = new Employee2("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee2("Tomy Tested", 40000, 1990, 3, 15);
		
		//print info about employees
		for (Employee2 e: staff){
			System.out.println("name="+e.getName()+",salary="+e.getSalary());
		}
	}	
}
