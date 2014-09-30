package com.core.ex1.n_14threads.misc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest13 {
	public static void main(String[] args){
		final int SIZE = 10000;
		double[] numbers = new double[SIZE];
		for (int i = 0; i < SIZE; i++){
			numbers[i] =  Math.random();
		}
		Counter counter = new Counter(numbers, 0, numbers.length, new Filter(){
			@Override
			public boolean accept(double x) {
				//<-- Anonymous inner class
				return x > 0.5;
			}
		});
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(counter);
		System.out.println("ForkJoin Result:"+ counter.join());
	}
}

interface Filter{
	boolean accept(double t);
}

class Counter extends RecursiveTask<Integer>{
	public static final int THRESHOLD = 1000;
	private double values[];
	private int from;
	private int to;
	private Filter filter;
	
	public Counter(double[] values, int from, int to, Filter filter){
		this.values = values;
		this.from = from;
		this.to = to;
		this.filter = filter;
		System.out.println("From:"+from+" To:"+to);
	}

	@Override
	protected Integer compute() {
		if (to - from < THRESHOLD){
			int count = 0;
			for (int i = 0; i< to; i ++){
				if (filter.accept(values[i])){
					count++;
				}
			}
			return count;
		} else {
			int mid = (from + to)/2;
			Counter first = new Counter(values, from, mid, filter);
			Counter second = new Counter(values, mid, to, filter);
			invokeAll(first, second);
			return first.join() + second.join();
		}
	}
}