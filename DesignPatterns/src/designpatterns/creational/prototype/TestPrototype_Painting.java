/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.creational.prototype;

/**
 *
 * @author julope
 */
interface Shape{
    public void draw();
}

class Line implements Shape{
    @Override
    public void draw() {
        System.out.println("square");
    }
}

class Square implements Shape{
    @Override
    public void draw(){
    System.out.println("square");
    }
}

class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("circle");
    }
}

class TestPrototype_Painting {
    public static void main(String[] args){
        Shape s1 = new Line();
        Shape s2 = new Square();
        Shape s3 = new Circle();
    
        paint(s1, true);
        paint(s2, true);
        paint(s3, true);        
    }
    
    static void paint(Shape s){
        s.draw();
    }
    
    static void paint(Shape s, boolean checkType)
    {
        if (checkType){
            if(s instanceof Line){
                s.draw();
            }
            if(s instanceof Square){
                s.draw();
            }
            if(s instanceof Circle){
                s.draw();
            }
        }
        else {
            paint(s);
        }
    }
}
