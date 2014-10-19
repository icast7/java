package com.core.ex1.m_13collections;

import java.util.*;

public class ShuffleTest7 {
	//Random Shuffle
	public static void main(String[] args){
		List<Integer> numbers = new ArrayList();
		for (int i = 1; i <= 49; i++) {
			numbers.add(i);
		};
		System.out.println(numbers);
		Collections.shuffle(numbers);
		List<Integer> winningCombination = numbers.subList(0, 6);
		Collections.sort(winningCombination);
		System.out.println(winningCombination);
	}
}
