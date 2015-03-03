package com.wrightm.tutorials.java8.exercises.chapter1;

public class ExerciseSix {

	public static void main(String[] args){
		new Thread(uncheck(new RunnableEx())).start();
	}
	
	public static Runnable uncheck(RunnableEx runnable){
		return () -> {
			try {
				runnable.run();
			} catch(Throwable ex){
				System.out.printf("Exception Thrown: %s", ex.getMessage());
			}
			System.out.printf("Exception? What Exception! Mwhahaha");
		};
	}
}