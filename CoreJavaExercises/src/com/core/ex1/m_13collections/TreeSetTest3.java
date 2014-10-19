package com.core.ex1.m_13collections;

import java.util.*;


public class TreeSetTest3 {
	public static void main(String[] args){
		
		SortedSet<Item4> parts = new TreeSet<>();
		parts.add(new Item4("Toaster", 1234));
		parts.add(new Item4("Widget", 4562));
		parts.add(new Item4("Modem", 9912));
		
		System.out.println(parts);
		
		SortedSet<Item4> sortedByDescription =  new TreeSet<Item4>(new Comparator<Item4>(){
			@Override
			public int compare(Item4 a, Item4 b) {
				String descrA = a.getDescription();
				String descrB = b.getDescription();
				return descrA.compareTo(descrB);
			}
		});
		
		sortedByDescription.addAll(parts);
		System.out.println(sortedByDescription);
	}
}
