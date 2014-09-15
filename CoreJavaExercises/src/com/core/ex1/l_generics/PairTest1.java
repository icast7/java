/**
 * 
 */
package com.core.ex1.l_generics;

/**
 * @author icastillejos
 */
public class PairTest1 {
	public static  void main(String[] args){
		String[] words = {"Mary", "had", "a", "little", "wolf"};
		Pair<String> mm = ArrayAlg.minmax(words);
		System.out.println("min = " + mm.getFirst());
		System.out.println("max = " + mm.getSecond());
	}
}

class ArrayAlg{
	/**
	 * Gets the min and max of an array of str
	 * @param an array of str
	 * @return a pair with min and max
	 * */
	public static Pair<String> minmax(String[] a){
		if (a==null || a.length==0){
			return null;
		}
		String min = a[0];
		String max = a[0];
		for (int i=1; i < a.length; i++){
			if (min.compareTo(a[i]) > 0){
				min = a[i];
			}
			if (max.compareTo(a[i]) < 0){
				max = a[i];
			}
		}
		return new Pair<String>(min, max);
	}
}

class Pair<T>{
	private T first;
	private T second;
	
	public Pair()	{	this.setFirst(null);	this.second = null;	}
	
	public Pair(T first, T second)	{	this.setFirst(first); this.second = second;	}

	public T getFirst() {
		return first;
	}
	
	public T getSecond() {
		return second;
	}
	
	public void setFirst(T first) {
		this.first = first;
	}

	public void setSecond(T second) {
		this.second = second;
	}
}