package designpatterns.structural.adapter;

interface Clean{
    public void makeClean();
}

class Office implements Clean{
    @Override
    public void makeClean() {
        System.out.println("Clean Office");
    }    
}

class Workshop implements Clean{
    @Override
    public void makeClean() {
    System.out.println("Clean Workshop");
    }
}

interface Extra extends Clean{
    public void takeCare();
}

class Facility implements Extra{
    @Override
    public void takeCare() {
          System.out.println("Facility taken care of");
    }
    @Override
    public void makeClean() {
          System.out.println("Clean Facility");
    }
}

public class TestAdapter_Clean {
    static void Jobs(Clean job){
        System.out.print("job:");
        if (job instanceof Clean)
            ((Clean)job).makeClean();
        if (job instanceof Extra)
            ((Extra)job).takeCare();        
    }

    public static void main(String[] args){
        Extra e = new Facility();
        Jobs(e);
        Clean c1= new Office();
        Jobs(c1);
        Clean c2 = new Workshop();
        c1.makeClean();
        c2.makeClean();
        e.makeClean();
    }    
}
