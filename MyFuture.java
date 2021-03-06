package com.mycom.projects.java.multithreading;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyFuture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<Integer> future = executor.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				Random random = new Random();
				int duration = random.nextInt(4000);
				if (duration > 2000) {
					throw new IOException("Sleeping for too long.");
				}
				System.out.println("Starting ...");
				try {
					Thread.sleep(duration);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Finished.");
				return duration;
			}
		});
		executor.shutdown();
		try {
			System.out.println("Result is : " + future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//System.out.println(e.getMessage());
			IOException ex = (IOException) e.getCause();
			System.out.println(ex.getMessage());
		}
	}

}
/* 
new Runnable() {
			public void run() {
			Random random = new Random();
			int duration = random.nextInt(4000);
			System.out.println("Starting ...");
			try {
				Thread.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Finished.");
			}
		}
*/