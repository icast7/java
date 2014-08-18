package designpatterns.creational.singleton;

class Connection {
    public static boolean haveOne = false;
    public Connection() throws Exception{
    if(!Connection.haveOne)
    {
        doSomething();
        haveOne=true;
    } else {
        throw new Exception("You cannot have a second instance");
    }
    }
    
    public static Connection getConnection() throws Exception{
    return new Connection();
    }
    
    void doSomething(){}
    
    public static void main(String[] args){
    try{
        Connection con= new Connection();
    }catch(Exception e){
        System.out.println("first: "+e.getMessage());
    }
    try{
        Connection con2 = Connection.getConnection();
    }catch(Exception e){
        System.out.println("second: "+e.getMessage());
    }
    }
}