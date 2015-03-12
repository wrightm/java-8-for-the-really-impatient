package com.wrightm.tutorials.java8.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

public class CompareFileFilter {

	public static void main(String[] args) throws IOException {
    	final String filename = "src/main/java/com/wrightm/tutorials/java8/streams/alice.txt";
    	System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
    	
        String contents = new String(Files.readAllBytes(
                Paths.get(filename)), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		
		long startTimeLoop = System.currentTimeMillis();
		long count = 0;
		for(String w: words){
			if(w.length() > 12) count++;
		}
		long stopTimeLoop = System.currentTimeMillis();
		System.out.println("loop time: " + (stopTimeLoop - startTimeLoop));
		
		
		long startTimeStream = System.currentTimeMillis();
		count = words.stream().filter(word -> word.length() > 10).count();
		long stopTimeStream = System.currentTimeMillis();
		System.out.println("Stream time: " + (stopTimeStream - startTimeStream));
		
		long startTimeStreamParallel = System.currentTimeMillis();
		count = words.parallelStream().filter(word -> word.length() > 10).count();
		long stopTimeStreamParallel = System.currentTimeMillis();
		System.out.println("Parallel Stream time: " + (stopTimeStreamParallel - startTimeStreamParallel));
		
	}
	
}
