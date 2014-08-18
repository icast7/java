/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.creational.factoryMethod;

/**
 *
 * @author julope
 */
interface Display {
    //load a file
    public void load(String fileName);
    
    //parse the file and make a consistent data type
    public void formatConsustency();    
}

class CSVFile implements Display{
    @Override
    public void load(String fileName) {
     System.out.println("load from a txt file");
    }

    @Override
    public void formatConsustency() {
     System.out.println("txt file format changed");
    }
}

class XMLFile implements Display{
@Override
    public void load(String fileName) {
     System.out.println("load from a xml file");
    }

    @Override
    public void formatConsustency() {
     System.out.println("xml file format changed");
    }
}

class DBFile implements Display{
@Override
    public void load(String fileName) {
     System.out.println("load from a db file");
    }

    @Override
    public void formatConsustency() {
     System.out.println("db file format changed");
    }
}