package com.core.ex1.n_14threads.misc;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class ThreadPoolTest12 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter base directory (e.g. /usr/local/jdk5.0/src):::");
		String directory = in.nextLine();
		System.out.print("Enter keyword (e.g. test):");
		String keyword = in.nextLine();
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		MatchCounter12 counter = new MatchCounter12(new File(directory),keyword, pool);
		Future<Integer> result = pool.submit(counter);
		
		try{
			System.out.println(result.get() + " matching files.");
		} catch (ExecutionException e){
			e.printStackTrace();
		} catch (InterruptedException e) {
		}
		pool.shutdown();
		
		int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
		System.out.println("Largest Pool Size = " + largestPoolSize);
		
	}
}

class MatchCounter12 implements Callable<Integer>{
	private File directory;
	private String keyword;
	private int count;
	private ExecutorService pool;
	
	/*
	 * Construct a Callable counter
	 * **/
	public MatchCounter12(File directory, String keyword, ExecutorService pool){
		this.directory = directory;
		this.keyword = keyword;
		this.pool = pool;
	}

	@Override
	public Integer call() throws Exception {
		count = 0;
		try{
			File[] files = directory.listFiles();
			List<Future<Integer>> results = new ArrayList<>();
			
			for(File file : files){
				if(file.isDirectory()){
					System.out.println("Directory:" + file.getPath());					
					MatchCounter12 counter = new MatchCounter12(file, keyword, pool);
					Future<Integer> result = pool.submit(counter);
					results.add(result);
				} else {
					if (search(file)){
						count ++;
					}
				}
			}
			for (Future<Integer> result : results){
				try{
					count += result.get();
				} catch (ExecutionException e){
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e){
		}
		return count;
	}
	
	/*
	 * Search a file for a given keyboard
	 ***/
	private boolean search(File file) {
		try {
			try (Scanner in = new Scanner(file)){
				boolean found = false;
				while (!found && in.hasNextLine())
				{
					String line = in.nextLine();
					if (line.contains(keyword)){
						found = true;
					}
				}
				return found;
			}
		} catch (IOException e){
		return false;
		}
	}
}