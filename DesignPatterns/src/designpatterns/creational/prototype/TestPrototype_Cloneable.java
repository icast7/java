/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.creational.prototype;


/**
 *
 * @author julope
 */
//class Complex implements Cloneable{
//    int[] nums = {1,2,3,4,5,6};
//    
//    @Override
//    public Object clone(){
//        try{
//            return super.clone();
//        }catch(CloneNotSupportedException cnse){
//            System.out.println(cnse.getMessage());
//            return null;
//        }
//    }
//    
//    int[] getNums(){
//        return nums;
//    }
//}
class Complex{
    int[] nums = {1,2,3,4,5};
    
    public Complex clone(){
        return new Complex();
    }
    
    int[] getNums(){
        return nums;
    }
}


class TestPrototype_Cloneable{
    static Complex c1 = new Complex();
    
    static Complex makeCopy(){
        return (Complex)c1.clone();
    }
    
    public static void main(String[] args){
    TestPrototype_Cloneable tp = new TestPrototype_Cloneable();
    Complex c2 = TestPrototype_Cloneable.makeCopy();
    int[] mycopy = c2.getNums();
    mycopy[0]=5;
    
    System.out.println();
    System.out.print("local array: ");
    for (int i = 0; i < mycopy.length; i++){
        System.out.print(mycopy[i]);
    }
    System.out.println();
    
    System.out.print("Cloned object ");
    for(int ii=0;ii<c2.nums.length;ii++) {
            System.out.print(c2.nums[ii]);
    }
    System.out.println();
    
    System.out.print("original object: ");
    for(int iii=0; iii < TestPrototype_Cloneable.c1.nums.length; iii++){
        System.out.print(TestPrototype_Cloneable.c1.nums[iii]);
    }
  }
}