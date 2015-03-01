package com.wrightm.tutorials.java8.lambdaexpressions;

import java.nio.file.*;
import java.util.*;

public class ApplicationExample {
	public static void main(String[] args) {

	      // Path first = Paths.get("/usr/bin");
	      // Uncomment to see error "variable first is already defined"
	      // in the lambda expression below

	      Comparator<String> comp = 
	         (first, second) -> Integer.compare(first.length(), second.length());
	      ApplicationExample app = new ApplicationExample();
	      app.doWork();
	   }

   public void doWork() {      
      Runnable runner = () -> { System.out.println(this.toString()); };
      runner.run();
      // Prints Application@... since this refers to an Application object
   }
}
