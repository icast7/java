/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.creational.factoryMethod;
import java.net.*;

/**
 *
 * @author julope
 */

class DataInfo {
}

class FieldInfo {
}


interface DatabaseService {
    public DataInfo getDataInfo() throws Exception;
    public FieldInfo getFieldInfo() throws Exception;
    public void write(FieldInfo fi) throws Exception;
    public void modify(FieldInfo fi) throws Exception;
    public void delete(FieldInfo fi) throws Exception;
}

class Data implements DatabaseService{
    public Data(String fileName) {};
    public Data(URL ulr, String fileName) {};
    public DataInfo getDataInfo() throws Exception {
        return null;
    }
    public FieldInfo getFieldInfo() throws Exception {
        return null;
    }
    public void write(FieldInfo fi) throws Exception {
    throw new UnsupportedOperationException();
    }
    public void modify(FieldInfo fi) throws Exception {
    throw new UnsupportedOperationException();
    }
    public void delete(FieldInfo fi) throws Exception {
    throw new UnsupportedOperationException();
    }
}

class DataManager{
    DataManager() throws Exception{
    Data data = null;
    boolean local=false;
    boolean remote=false;
 
    if(local){
    data = new Data(null);
    }
    if(remote){
    data = new Data(null, null);
    }
    data.write(null);
    data.modify(null);
    }
}