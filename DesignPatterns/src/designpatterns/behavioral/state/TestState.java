package designpatterns.behavioral.state;

abstract class Connection{
	public abstract void open();
	public abstract void close();
	public abstract void log();
}

class Accounting extends Connection{
	public void open(){
		System.out.println("open DB for accounting");
	}
	public void close(){
		System.out.println("close DB for accounting");
	}
	public void log(){
		System.out.println("log activities for accounting");
	}
}

class Sales extends Connection{
	public void open(){
		System.out.println("open DB for sales");
	}
	public void close(){
		System.out.println("close DB for sales");
	}
	public void log(){
		System.out.println("log activities for sales");
	}	
}

class Management extends Connection{
	public void open(){
		System.out.println("open DB for management");
	}
	public void close(){
		System.out.println("close DB for management");
	}
	public void log(){
		System.out.println("log activities for management");
	}	
}

class Controller{
	public static Accounting acct;
	public static Sales sales;
	public static Management manage;
	private static Connection current;
	
	Controller(){
		acct = new Accounting();
		sales = new Sales();
		manage = new Management();
	}
	
	public void makeAccountingConnection(){
		current = acct;
	}
	
	public void makeSalesConnection(){
		current = sales;
	}
	
	public void makeManagementConnection(){
		current = manage;
	}
	
	public void open(){
		current.open();
	}
	
	public void close(){
		current.close();
	}
	
	public void log(){
		current.log();
	}	
}

class LocalTest{
	String con;
	Controller controller;
	LocalTest(String con){
		controller = new Controller();
		if(con.equalsIgnoreCase("management"))
			controller.makeManagementConnection();
		if(con.equalsIgnoreCase("sales"))
			controller.makeSalesConnection();
		if(con.equalsIgnoreCase("accounting"))
			controller.makeAccountingConnection();
		controller.open();
		controller.log();
		controller.close();
	}
}

public class TestState {
	public static LocalTest test;

	public static void main(String[] args) {
		args = new String[1];
		args[0] = "management";
		new LocalTest(args[0]);
	}

}