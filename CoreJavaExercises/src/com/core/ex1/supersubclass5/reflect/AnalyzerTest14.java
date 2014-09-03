/**
 * 
 */
package com.core.ex1.supersubclass5.reflect;

import java.util.ArrayList;

/**
 * Analyze object
 * @version 1.2.3
 * @author icastillejos
 */
public class AnalyzerTest14 {
	public static void main(String[] args){
		ArrayList<Integer> squares = new ArrayList<>();
		for ( int i =10 ; i <= 20; i++){
			squares.add(i*i);
		}
		System.out.println(new ObjectAnalyzer15().toString(squares));
	}
}
