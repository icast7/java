package com.core.ex1.e_5supersubclass.abstractTest;

public class PersonTest4 {
	public static void main(String[] args){
		Person5[] people = new Person5[2];
		//Students and employees
		people[0] = new Employee6("Harry Hacker", 50000, 1989, 10, 1);
		people[1] = new Student7("Maria Morris", "CSc");
		
		//Print all names using person
		for (Person5 p : people){
			System.out.println(p.getName() + ", " + p.getDescription());
		}		
	}
}
