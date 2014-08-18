package designpatterns.structural.composite;

public class TestComposite {
	public static void main(String[] args) {
		Employee[] e1 = {new Employee("Aaron", 50),
						 new Employee("Betty", 60)};
		Manager m1 = new Manager(e1, "Accounting");
		
		Employee[] e2 = {new Employee("Cathy", 70),
				 		 new Employee("Dan", 80),
				 		 new Employee("Eliz", 90)};
		Manager m2 = new Manager(e2, "Production");
		
		System.out.println(m2);
		Employee[] emp = m2.getEmployee();
		if(emp!=null)			
			for(int k =0; k < emp.length; k++)
				System.out.println(" "+emp[k]+ " Salary: $"+emp[k].getSalary());
		Manager m = m2.getManager();
		System.out.println(" "+m1);
		if(m1!=null){
		Employee[] emps = m1.getEmployee();
		if(emps!=null)
			for(int k=0;k<emps.length;k++)
				System.out.println("     "+emps[k]+" Salary: $"+ emps[k].getSalary());
		}		
	}

}

class Employee{
	String name;
	double salary;
	Employee(String n, double s){
		this.name = n;
		this.salary = s;
	}
	String getName(){
		return name;
	}
	double getSalary(){
		return salary;
	}
	public String toString() {
		return "Employee " + name;
	}
}

class Manager{
	Manager mgr;
	Employee[] ely;
	String dept;
	Manager(Manager mgr, Employee[] e, String d){
		this(e,d);
		this.mgr = mgr;
	}
	Manager(Employee[] e, String d){
		this.ely = e;
		this.dept = d;
	}
	String getDept(){
		return this.dept;
	}
	Manager getManager(){
		return this.mgr;
	}
	Employee[] getEmployee(){
		return ely;
	}
	public String toString(){
		return dept + " Manager";
	}
}


