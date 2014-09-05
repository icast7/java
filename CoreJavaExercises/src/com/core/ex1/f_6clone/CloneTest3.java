/**
 * 
 */
package com.core.ex1.f_6clone;

/**
 * Make a deep copy
 * @author icastillejos
 * @version 1.0.0 
 */
public class CloneTest3 {
	public static void main(String[] args){
		try{
		Employee4 original = new Employee4("John Q. Public", 50000);
		original.setHireDay(2000, 1, 1);
		Employee4 copy = original.clone();
		
		copy.raiseSalary(10);
		copy.setHireDay(2002, 12, 31);
		
		System.out.println("original="+original);
		System.out.println("copy="+copy);
		}
		catch (CloneNotSupportedException e){
			e.printStackTrace();
		}
		
	}
}
