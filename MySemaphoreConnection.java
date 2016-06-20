package com.mycom.projects.java.multithreading;

import java.util.concurrent.Semaphore;

public class MySemaphoreConnection {
	private Semaphore sem = new Semaphore(10);
	private static int connections = 0;
	private static MySemaphoreConnection instance = new MySemaphoreConnection();
	private MySemaphoreConnection() {
		
	}
	public static MySemaphoreConnection getInstance() {
		return instance;
	}
	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			doconnect();
		} finally {
			sem.release();
		}
	}
	public void doconnect() {
		
		synchronized (this) {
			connections++;
			System.out.println("Current connections: " + connections);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (this) {
			connections--;
			System.out.println("Finished. current connections: "+ connections);
		}
		
	}

}
