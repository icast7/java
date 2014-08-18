/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.creational.singleton;

/**
 *
 * @author icastillejos
 */
class Employee{
    public static final int companyID=12345;
    public String address;
}

class HourlyEmployee extends Employee{
    public double hourlyRate;
}

class SalaryEmployee extends Employee{
    public double salary;
}

class TestSingleton_Employee {
    
    public static void main(String[] args){
    @SuppressWarnings("unused")
	Employee evens = new Employee();
    @SuppressWarnings("unused")
	HourlyEmployee hellen = new HourlyEmployee();
    @SuppressWarnings("unused")
	SalaryEmployee sara = new SalaryEmployee();
    System.out.println(Employee.companyID == HourlyEmployee.companyID);
    System.out.println(Employee.companyID == SalaryEmployee.companyID);
   }
}
