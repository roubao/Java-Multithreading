package com.mycom.projects.java.multithreading;

public class MySynchronized {
	private volatile int count = 0;
	private synchronized void increment() {
		count++;
	}
	public static void main(String[] args) {
		MySynchronized ms = new MySynchronized();
		try {
			ms.dowork();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void dowork() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i ++) {
					increment();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i ++) {
					increment();
				}
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(count);
	}
}
