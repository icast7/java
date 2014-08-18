package designpatterns.structural.decorator;
import java.util.Random;

public class TestDecorator {
    public static void main(String[] args){
    new Decorator();
    new SubNumber();
    }    
}

class Number{
    public void print(){
    System.out.println(new Random().nextInt());
    }
}

class Decorator{
    public Decorator(){
    System.out.print("Random number: ");
    new Number().print();
    }
}

class SubNumber extends Number{
    public SubNumber(){
        super();
        System.out.print("Random number: ");
        print();
    }
}
