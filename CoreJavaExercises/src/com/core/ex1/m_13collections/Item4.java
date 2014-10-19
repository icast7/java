package com.core.ex1.m_13collections;

import java.util.Objects;

public class Item4 implements Comparable<Item4>{
	
	private String description;
	private int partNumber;
	
	public Item4(String aDescription, int aPartNumber){
		this.description = aDescription;
		this.partNumber = aPartNumber;
	}
	
	public String getDescription() {
		return description;
	}

//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public int getPartNumber() {
//		return partNumber;
//	}
//
//	public void setPartNumber(int partNumber) {
//		this.partNumber = partNumber;
//	}
	@Override
	public boolean equals(Object otherObject){
		if (this == otherObject) {
			return true;
		}
		if (otherObject == null){
			return false;
		}
		if (this.getClass() != otherObject.getClass()){
			return false;
		}
		Item4 other =  (Item4) otherObject;
		return Objects.equals(this.description, other.description) && partNumber == other.partNumber;
	}
	
	@Override
	public int compareTo(Item4 o) {
		return Integer.compare(partNumber, o.partNumber);
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(this.description, this.partNumber);
	}
	
	@Override
	public String toString(){
		return "[description="+this.description+", partNumber="+partNumber+"]";
	}
}
