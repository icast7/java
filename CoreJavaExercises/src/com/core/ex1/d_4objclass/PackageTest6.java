
package com.core.ex1.d_4objclass;

import com.core.ex1.d_4objclass.newpackage.*;

import static java.lang.System.*;

/**
 * This is a test using multiple packages 
 * @author icastillejos
 * @version 1.0.0
 */
public class PackageTest6 {
	public static void main(String[] args){
		Employee7 harry = new Employee7("Harry Hacker", 50000, 1989, 10, 1);
		harry.raiseSalary(5);
		
		//Use static import here
		out.println("name="+harry.getName()+",salary="+harry.getSalary());
	}
}
