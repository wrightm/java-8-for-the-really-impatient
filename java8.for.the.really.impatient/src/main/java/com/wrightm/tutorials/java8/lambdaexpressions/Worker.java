package com.wrightm.tutorials.java8.lambdaexpressions;

public class Worker implements Runnable {
	
	public void run() {
		for(int i = 0; i < 10; i++){
			doWork();
		}
	}
	
	public void doWork(){
		System.out.println("Doing work");
		try {
			Thread.sleep(100);
		} catch (InterruptedException ex){
			Thread.currentThread().interrupt();
		}
	}
}
