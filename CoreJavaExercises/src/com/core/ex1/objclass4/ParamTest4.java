/**
 * 
 */
package com.core.ex1.objclass4;

/**
 * Parameter passing
 * @author icastillejos
 */
public class ParamTest4 {
	public static void main(String[] args){
		
		/* Test1: Methods can't modify numeric parameters*/
		System.out.println("Testing tripleValue:");
		double percent = 10;
		System.out.println("Before: percent="+percent);
		tripleValue(percent);
		System.out.println("After: percent="+percent);
		
		/* Test2: Methods can change the state of the object parameters */
		System.out.println("\nTesting tripleSalary:");
		Employee4 harry = new Employee4("Harry", 50000);
		System.out.println("Before: salary= " + harry.getSalary());
		tripleSalary(harry);
		System.out.println("After: salary = " + harry.getSalary());
		
		/* Test3: Methods can't attach new objects to object parameters */
		System.out.println("\nTesting swap:");
		Employee4 a = new Employee4("Alice", 70000);
		Employee4 b = new Employee4("Bob", 60000);
		System.out.println("Before: a=" + a.getName());
		System.out.println("Before: b=" + b.getName());
		swap(a, b);		
		System.out.println("After: a=" + a.getName());
		System.out.println("After: b=" + b.getName());		
	}

	public static void tripleValue(double x) {
		x = 3*x;
		System.out.println("End of method: x="+ x);
	}
	
	public static void tripleSalary(Employee4 x){
		x.raiseSalary(200);
		System.out.println("End of method: salary=" + x.getSalary());
	}
	
	public static void swap(Employee4 x, Employee4 y){
		Employee4 temp = x;
		x = y;
		y = temp;
		System.out.println("End of method: x=" + x.getName());
		System.out.println("End of method: y=" + y.getName());
	}
}	
	class Employee4{
		private String name;
		private double salary;
		
		public Employee4(String name, double salary){
			this.name = name;
			this.salary = salary;
		}
		
		public String getName() {
			return name;
		}

		public double getSalary() {
			return salary;
		}
		
		public void raiseSalary(double byPercent) {
			double raise = salary * byPercent/100;
			salary += raise;
		}
		
	}

