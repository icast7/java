package com.core.ex1.m_13collections;

import java.util.*;

import com.core.ex1.f_6clone.Employee4;

//maps
public class MapTest6 {
	public static void main(String[] args){
		Map<String, Employee4> s = new HashMap<>();
		s.put("144-25-5464", new Employee4("Amy Lee"));
		s.put("567-24-2546", new Employee4("Harry Hacker"));
		s.put("157-62-7935", new Employee4("Carry Cooper"));
		s.put("456-62-5527", new Employee4("Francesca Cruzz"));
		
		//print
		System.out.println(s);
		//remove 1
		s.remove("157-62-7935");
		//replace
		s.put("144-25-5464", new Employee4("Francesco Totti"));
		//look up a value
		System.out.println(s.get("567-24-2546"));
		
		for (Map.Entry<String, Employee4> entry : s.entrySet()){
			String key = entry.getKey();
			Employee4 value = entry.getValue();
			System.out.println("key=" + key + ", value="+ value);
		}
	}

}
