/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.creational.factoryMethod;

/**
 *
 * @author julope
 */
class TestFactoryMethod {
    public static void main(String args[]){
    Display display = null;
    
    if (args.length == 0)
    {
        System.exit(1);   
    }
     
    if (args[0].equals("1"))
        display = new CSVFile();
    if (args[0].equals("2"))
        display = new XMLFile();
    if (args[0].equals("3"))
        display = new DBFile();
    else
        System.exit(1);
    display.load("");
    display.formatConsustency();
    }
}
