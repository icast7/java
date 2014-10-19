package com.core.ex1.m_13collections;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;
//Test PriosityQueue
public class PriorityQueueTest5 {
	public static void main(String[] args){
		PriorityQueue<GregorianCalendar> p = new PriorityQueue<>();
		p.add(new GregorianCalendar(1906, Calendar.DECEMBER, 9));
		p.add(new GregorianCalendar(1815, Calendar.DECEMBER, 10));
		p.add(new GregorianCalendar(1903, Calendar.DECEMBER, 3));
		p.add(new GregorianCalendar(1910, Calendar.JUNE, 22));
		
		System.out.println("Iterating over elements...");
		for (GregorianCalendar date: p){
			System.out.println(date.get(Calendar.YEAR));
		}
		System.out.println("Removing elements...");
		while(!p.isEmpty()){
			System.out.println(p.remove().get(Calendar.YEAR));
		}
	}
}
