package _04InetAddresses;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class WebLogPooled {
	private final static int NUMBER_THREADS = 4;
	
	public static void main(String[] args) throws IOException{
		long start = System.nanoTime();
		ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREADS);
		Queue<LogEntry> results = new LinkedList<LogEntry>();

		if (args.length == 0){	
			String fullclass =  WebLog.class.getName();
			String pack = fullclass.substring(0, fullclass.indexOf('.'));
			String base = WebLog.class.getClassLoader().getResource("").getPath();
			String log = base + pack+"/myweblog.txt";
			args = new String[]{log};
		}
		
		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(
					 new FileInputStream(args[0]), "UTF-8"));
			){
			for (String entry = in.readLine(); entry != null; entry = in.readLine()){
				WebLogLookupTask task = new WebLogLookupTask(entry);
				Future<String> future = executor.submit(task);
				LogEntry result = new LogEntry(entry, future);
				results.add(result);
			}
		}
		//Print the results as they become available
		for (LogEntry result : results){
			try {
				System.out.println(result.future.get());
			} catch (InterruptedException | ExecutionException ex){
				System.out.println(result.original);
			}
		}
		long end = System.nanoTime();
		System.out.println("Duration:"+(end-start)/1000000+"ms");
		executor.shutdown();
	}
	
	private static class LogEntry{
		String original;
		Future<String> future;
		LogEntry(String original, Future<String> future){
			this.original = original;
			this.future = future;
		}
	}
}
