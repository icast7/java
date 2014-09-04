package com.core.ex1.f_6interface;

public class Employee2 implements Comparable<Employee2>{
	private String name;
	private int salary;
	
	public Employee2(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}
	
	public void raiseSalary(double byPercent){
		double raise = salary * byPercent/100;
		salary += raise;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * @param another Employee2 object
	 * @return negative if less, 0 if equal, positive if greater
	 */
	@Override
	public int compareTo(Employee2 o) {
		return -1*Double.compare(salary,o.salary);
	}
}
