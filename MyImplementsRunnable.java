package com.mycom.projects.java.multithreading;

class Runner1 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i ++) {
			System.out.println("Hello " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
public class MyImplementsRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread runner1 = new Thread(new Runner1());
		Thread runner2 = new Thread(new Runner1());
		runner1.start();
		runner2.start();
	}

}
