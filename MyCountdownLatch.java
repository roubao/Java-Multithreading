package com.mycom.projects.java.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable{
	private CountDownLatch latch;
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}
	public void run() {
		System.out.println("Started...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();
	}
}
public class MyCountdownLatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch latch = new CountDownLatch(5);
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i ++) {
			executor.submit(new Processor(latch));
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("completed.");
	}

}
