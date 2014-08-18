package designpatterns.structural.adapter;
class Info{};

class Data{
public void add(Info i){}
public void delete(Info i){}
public void modify(Info i){}
}

class AdaptData{
    Data data;
    public void add(Info i){
    data.add(i);   
    }
    public void delete(Info i){
    data.delete(i);   
    }
    public void modify(Info i){
    data.modify(i);   
    }
}

public class TestAdapter_AdaptData {
    
}
