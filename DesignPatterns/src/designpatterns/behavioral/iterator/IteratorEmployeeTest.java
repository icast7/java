package designpatterns.behavioral.iterator;

interface Employee{
	public abstract double earnings();
}

class Manager implements Employee{
	private double weeklySalary;
	private String name;
	
	public Manager(String name, double s){
		this.name = name;
		setWeeklySalary(s);
	}
	 void setWeeklySalary(double s){
		 if (s>0)
			 weeklySalary = s;
		 else 
			 weeklySalary=0;
	}	
	public double earnings() {
		return weeklySalary;
	}
	public String getName(){
		return name;
	}
	public String toString(){
		return "Manager: "+getName();
	}	
}

class PieceWorker  implements Employee{
	private double 	wagePerPiece;
	private int 	quantity;
	private String 	name;
	
	public double earnings() {
		return quantity * wagePerPiece;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return "Piece worker: " + getName();
	}
	
}

class HourlyWorker implements Employee{
	public double earnings() {
		return 0;
	}
	
}



public class IteratorEmployeeTest {
	public static void main(String[] args) {
	System.out.println("NOT READY");
	}
}
