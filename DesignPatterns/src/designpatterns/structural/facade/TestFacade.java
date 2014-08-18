package designpatterns.structural.facade;

interface General{
	public void accessGeneral();
}

interface Special extends General{
	public void accessSpecial();
}

interface Private extends General{
	public void accessPrivate();
}

class User{
	private General user;
	public User(){
		super();
	}
	public void setUser(General user){
		this.user = user;
	}
	public General getUser(){
		return this.user;
	}
}

class GeneralInfo implements General{
	public void accessGeneral(){
		
	}
}

class SpecialInfo extends GeneralInfo implements Special{

	@Override
	public void accessSpecial() {
	}
	
}

class PrivateInfo extends SpecialInfo implements Private{

	@Override
	public void accessPrivate() {
		
	}
}

public class TestFacade {

	public static void main(String[] args){
		User x = new User();
		x.setUser(new PrivateInfo());
		System.out.println(x.getUser());
		
		x.setUser(new SpecialInfo());
		System.out.println(x.getUser());

		x.setUser(new GeneralInfo());
		System.out.println(x.getUser());

		x.setUser(null);
		System.out.println(x.getUser());

	}
}
