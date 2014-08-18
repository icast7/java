package designpatterns.behavioral.visitor;
import java.util.*;

interface Visitor{
	public void visit(Pizza p);
}

interface Pizza{
	public String order();
}

class PopJohn implements Pizza{
	final String name = "PopJohn";
	public String order() {
		return name;
	}
}
 
class PizzaHut implements Pizza {
	final String name = "PizzaHut";
	public String order() {
		return name;
	}
}

class GodFather implements Pizza{
	final String name = "GodFather";
	public String order(){
		return name;
	}
}

class ByPickup implements Visitor {
	private String name;
	private final String method = "By pick up";
	
	public void visit(Pizza p){
		name = p.order();
	}
}

class ByEatIn implements Visitor {
	private String name;
	private final String method = "By eat in";
	
	public void visit(Pizza p){
		name = p.order();
	}
}

class ByDelivery implements Visitor{
	private String name;
	private final String method = "By Delivery";

	public void visit(Pizza p){
		name = p.order();	 
	}
}

class Dinner{
	public Pizza getDinner(){
		switch((int)(Math.random()*3)){
		case 0: return new PopJohn();
		case 1: return new PizzaHut();
		case 2: return new GodFather();
		default: return null;
		}
	}
	public Visitor howto(){
		switch ((int)(Math.random()*3)){
		case 0: return new ByPickup();
		case 1: return new ByEatIn();
		case 2: return new ByDelivery();
		default: return null;
		}
	}
}

public class TestVisitor {

	/**
	 * @param args
	 */
public static void main(String[] args) {
	List<Pizza> pizzaList = new ArrayList<Pizza>();
	pizzaList.add(new PopJohn());
	pizzaList.add(new PizzaHut());
	pizzaList.add(new GodFather());
	
	Iterator it = pizzaList.iterator();
	System.out.println("How many pizza restaurants in this area?");
	while (it.hasNext()){
		System.out.println(((Pizza)it.next()).order());
	}
	
	Dinner d = new Dinner();
	Pizza pza = d.getDinner();
	Visitor v= d.howto();
	v.visit(pza);
		
	System.out.println("\nWhich store for dinner?");
	System.out.println(d.getDinner().order() + " " + v.toString());
	}
}
