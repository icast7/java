package designpatterns.creational.builder;
import java.util.*;

class WorkShop {
    //force the order of the building process
    public void construct(HouseBuilder hb){
    hb.buildFoundation();
    hb.buildFrame();
    hb.buildExterior();
    hb.buildInterior();
    }
}
//set steps for building the house
abstract class HouseBuilder{
    protected House house = new House();
    
    protected String showProgress(){
         return house.toString();    
    }
    
    abstract public void buildFoundation();
    abstract public void buildFrame();
    abstract public void buildExterior();
    abstract public void buildInterior();
}
    
    class House {
    private String type = null;
    private List<String> features = new ArrayList<String>();
    
    public House(){
    }
    
    public House(String type){
        this.type = type;
    }
    
    public void setType(String type){
    this.type = type;
    }
    
    public String getType(){
    return type;
    }
    
    public void setProgress(String s){
    features.add(s);
    }
    
    @Override
    public String toString(){
    StringBuilder ff = new StringBuilder();
    String t = type.substring(6);
    ff.append(t+"\n");
    for (int i = 0; i < features.size(); i++){
       ff.append(features.get(i)+"\n");
    }
    return ff.toString();
    }
}

class OneStoryHouse extends HouseBuilder {
    public OneStoryHouse(String features){
        house.setType(this.getClass()+" "+features);
    }
    @Override
    public void buildFoundation() {
    house.setProgress("foundation"+" is done");    
    }
    @Override
    public void buildFrame() {
    house.setProgress("frame"+" is done");    
    }
    @Override
    public void buildExterior() {
    house.setProgress("exterior"+" is done");    
    }
    @Override
    public void buildInterior() {
    house.setProgress("interior"+" is under going");
    }
}

class TwoStoryHouse extends HouseBuilder{

    public TwoStoryHouse(String features){
    house.setType(this.getClass()+" "+features);
    }
    
    @Override
    public void buildFoundation() {
    house.setProgress("foundation"+" is done");    
    }

    @Override
    public void buildFrame() {
    house.setProgress("frame"+" is under construction");    
    }

    @Override
    public void buildExterior() {
    house.setProgress("exterior"+" is waiting to start");
    }

    @Override
    public void buildInterior() {
    house.setProgress("interior"+" is not started yet");
    }
}