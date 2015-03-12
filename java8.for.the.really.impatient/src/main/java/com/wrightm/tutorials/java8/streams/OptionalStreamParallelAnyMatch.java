package com.wrightm.tutorials.java8.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalStreamParallelAnyMatch {
	
	public static void main(String[] args) throws IOException {
    	final String filename = "src/main/java/com/wrightm/tutorials/java8/streams/alice.txt";
		String contents = new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);
		
		List<String> wordList = Arrays.asList(contents.split("[\\P{L}]+"));
		
		Stream<String> words = wordList.stream();
		
		Optional<String> largest = words.max(String::compareToIgnoreCase);
		if(largest.isPresent()){
			System.out.println("largest: " + largest.get());
		}
		
		words = wordList.stream();
		boolean aWordStarsWithQ = words.anyMatch(s -> s.startsWith("Q"));
		System.out.println("aWordStarsWithQ: "+ aWordStarsWithQ);
		
		words = wordList.stream();
		Optional<String> startsWithQ = words.parallel().filter(s -> s.startsWith("Q")).findAny();
		if(startsWithQ.isPresent()){
			System.out.println("startsWithQ: " + startsWithQ.get());
		}else {
			System.out.println("No word stars with Q");
		}
		
		
	}

}
