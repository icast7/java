
package com.core.ex1.objclass4;

import com.core.ex1.objclass4.newpackage.*;

import static java.lang.System.*;

/**
 * This is a test using multiple packages 
 * @author icastillejos
 * @version 1.0.0
 */
public class PackageTest6 {
	public static void main(String[] args){
		Employee6 harry = new Employee6("Harry Hacker", 50000, 1989, 10, 1);
		harry.raiseSalary(5);
		
		//Use static import here
		out.println("name="+harry.getName()+",salary="+harry.getSalary());
	}
}
