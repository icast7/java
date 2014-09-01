package com.core.ex1.objclass4;
/**
 * @author icastillejos
 *
 */
public class StaticTests3 {
	
	public static void main(String[] args)
	{
		Employee3[] staff = new Employee3[3]; 
	
		staff[0] = new Employee3("Tom", 40000); 
		staff[1] = new Employee3("Dick", 60000);
		staff[2] = new Employee3("Harry", 65000);
	
		
		
		for (Employee3 e : staff){
			e.setId();
			System.out.println("name="+e.getName()+",id="+e.getId()+",salary="+e.getSalary());
		}
	
		
		
		int n = Employee3.getNextId();//calls the static method
		System.out.println("Next available id="+n);
	}
}

class Employee3 {
		private static int nextId = 1;
		
		private double salary;
		private String name;
		private int id;
	
		public Employee3(String n, double s){
			this.name = n;
			this.salary = s;
			this.id = 0;
		}
		
		public String getName() {
			return name;
		}
	
		public double getSalary() {
			return salary;
		}
	
		public int  getId(){
			return id;
		}
		
		public void setId(){
			id = nextId;
			nextId++;
		}
		
		public static int getNextId(){
			return nextId;
		}
		
		public static void main(String[] args) {
			Employee3 e  = new Employee3("Harry", 50000);
			System.out.println(e.getName() + " " + e.getSalary());
		}	
}