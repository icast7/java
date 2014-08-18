package designpatterns.behavioral.templateMethod;

abstract class CheckBackground{
	public abstract void checkBank();
	public abstract void checkCredit();
	public abstract void checkLoan();
	public abstract void checkStock();
	public abstract void checkIncome();
	
	public void check(){
		checkBank();
		checkCredit();
		checkLoan();
		checkStock();
		checkIncome();
	}
}

class LoanApp extends CheckBackground{
	private String name;
	
	public LoanApp(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}	
	
	@Override
	public void checkBank() {
		System.out.println("check bank...");
	}
	@Override
	public void checkCredit() {
		System.out.println("check credit...");
	}
	@Override
	public void checkLoan() {
		System.out.println("check loan...");
	}
	@Override
	public void checkStock() {
		System.out.println("check stock...");		
	}
	@Override
	public void checkIncome() {
		System.out.println("check family income...");
	}
}

class TestTemplate{
	public static void main(String[] args) {
		LoanApp mortgageClient = new LoanApp("Juddy");
		System.out.println("\nCheck client "+mortgageClient.getName() + " Mortgage Loan application.");
		mortgageClient.check();
		
		LoanApp equityLoanClient = new LoanApp("Mark");
		System.out.println("\nCheck client "+mortgageClient.getName() + " Equity Loan application.");
		equityLoanClient.check();
	}
}
