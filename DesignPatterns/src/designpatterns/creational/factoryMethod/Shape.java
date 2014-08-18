/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.creational.factoryMethod;
import java.awt.*;

/**
 *
 * @author icastillejos
 */
interface Shape {
public void draw();
}

class Line implements Shape {
    Point x, y;
    Line(Point a, Point b)
    {
        x =a;
        y=b;
    }
    public void draw(){
    //draw a line
    }
}

class Square implements Shape{
    Point start;
    int width, height;
    
    Square(Point s, int w, int h){
    this.start = s;
    this.width = w;
    this.height = h;
    }
    
    public void draw() {
//draw a square
    }
}

class Circle implements Shape{
    Point start;
    int radious;
    Circle(Point a, int r){
    this.start = a;
    this.radious = r;
    }
    
    public void draw() {
    }
}

class Painting {
    Painting(Point a, Point b)
    {
        @SuppressWarnings("unused")
		Line l = new Line(a, b);
    }
    Painting(Point a, int w, int h){
        new Square(a, w, h);
    }
    Painting(Point a, int r){
        new Circle(a, r);
    }    
}
//class Painting {
//    Painting(Point a, Point b){
//        
//        draw(a, b);
//    }
//    Painting(Point a, int w, int h){
//        draw(a, w, h);
//    }
//    Painting(Point a, int r){
//        draw(a, r);
//    }    
//}
