package designpatterns.structural.proxy;

abstract class Graphic{
public abstract void load();
public abstract void draw();
}

class Image extends Graphic{
	public Image(String filename){
		
	}
	
	public void load(){
		System.out.println("loading...");
	}
	public void draw(){
		System.out.println("drawing...");
	}
}


public class ImgProxy extends Graphic{
	String filename = null;
	Object image = null;
	
	public void load(){
		
		if(image == null){
			image = new Image(filename);
		}
	}
	public void draw(){
		if(image == null){
			image = new Image(filename);
		}
	}
}
