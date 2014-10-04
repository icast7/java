package com.core.ex1.m_13collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*
 * Operations in a linked list
 * **/
public class LinkedLinkTest1 {
	public static void main(String[] args){
		List<String> a = new LinkedList<>();
		a.add("Amy");
		a.add("Carl");
		a.add("Erica");
		
		List<String> b = new LinkedList<>();
		b.add("Bob");
		b.add("Doug");
		b.add("Frances");
		b.add("Gloria");
		
		//Merge the words from b into a
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();
		
		while (bIter.hasNext()){
			if (aIter.hasNext()){
				aIter.next();
			}
			aIter.add(bIter.next());
		}
	
		System.out.println(a);
		//
		bIter = b.iterator();
		while(bIter.hasNext()){
			bIter.next();//skip 1 guy
			if (bIter.hasNext()){
				bIter.next();
				bIter.remove();				
			}
		}
		
		System.out.println(b);
		//Remove b's
		a.removeAll(b);
		
		System.out.println(a);
	}
}
