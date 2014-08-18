package designpatterns.behavioral.chainOfResp;
import java.io.*;

abstract class PurchasePower{
	protected final double base = 500;
	protected PurchasePower successor;
	
	public void setSuccessor(PurchasePower successor){
		this.successor = successor;
	}
	
	abstract public void processRequest(PurchaseRequest request);
}

class Manager extends PurchasePower{
	private final double ALLOWABLE = 10*base;

	@Override
	public void processRequest(PurchaseRequest request) {
	if (request.getAmount()<ALLOWABLE)
		System.out.println("Manager will approve $"+request.getAmount());
	else
		if (successor != null)
			successor.processRequest(request);
	}	
}

class Director extends PurchasePower{
	private final double ALLOWABLE = 20*base;

	@Override
	public void processRequest(PurchaseRequest request) {
	if (request.getAmount()<ALLOWABLE)
		System.out.println("Director will approve $"+request.getAmount());
	else
		if (successor != null)
			successor.processRequest(request);
	}		
}

class VicePresident extends PurchasePower{
	private final double ALLOWABLE = 40*base;

	@Override
	public void processRequest(PurchaseRequest request) {
	if (request.getAmount()<ALLOWABLE)
		System.out.println("VP will approve $"+request.getAmount());
	else
		if (successor != null)
			successor.processRequest(request);
	}	
}

class President extends PurchasePower{
	private final double ALLOWABLE = 60*base;

	@Override
	public void processRequest(PurchaseRequest request) {
	if (request.getAmount()<ALLOWABLE)
		System.out.println("President will approve $"+request.getAmount());
	else
		System.out.println("Your request for $" + request.getAmount() + " needs a board meeting!!!");
	}	
}

class PurchaseRequest {
	private int number;
	private double amount;
	private String response;
	
	public PurchaseRequest(int number, double amount, String purpose){
		this.number = number;
		this.amount =  amount;
		this.response = purpose;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}	
}

public class TestChainResponsability {
	public static void main(String[] args) {
		Manager manager = new Manager();
		Director director = new Director();
		VicePresident vp = new VicePresident();
		President president = new President();
		manager.setSuccessor(director);
		director.setSuccessor(vp);
		vp.setSuccessor(president);
		while(true){
			System.out.println("Enter the amount to check who should approve your expenditure.");
			System.out.print(">");
			double d =0;
			try {
				d = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			manager.processRequest(new PurchaseRequest(0,d,"General"));
		}
	}
}
