package com.wrightm.tutorials.java8.exercises.chapter1;

class RunnableEx implements Runnable {
	
	/**
	 * @throws Throwable always throws.
	 */
	public void run() {
		throw new Throwable("This will be caught by unchecked");
	}
	
}

