package com.wrightm.tutorials.java8.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsLimitCollectDistinctSortedReversed {

	public static <T> void show(String title, Stream<T> stream){
		final int SIZE = 10;
		List<T> firstElements = stream.limit(SIZE + 1).collect(Collectors.toList());
		System.out.print(title + ": ");
		if(firstElements.size() <= SIZE){
			System.out.println(firstElements);
		} else {
			firstElements.remove(SIZE);
			String out = firstElements.toString();
			System.out.println(out.substring(0, out.length() -1) + ", ...]");
		}
	}
	
	public static void main(String[] args) throws IOException {
		Stream<String> uniqueWords = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
		
		show("unique", uniqueWords);
		
		final String filename = "src/main/java/com/wrightm/tutorials/java8/streams/alice.txt";
		String contents = new String(Files.readAllBytes(Paths.get(filename)),StandardCharsets.UTF_8);
		List<String> wordList = Arrays.asList(contents.split("[\\P{L}]+"));
		Stream<String> words = wordList.stream();
		
		show("words",words);
		
		words = wordList.stream();
		Stream<String> distinct = words.distinct();
		show("distinct",distinct);
		
		words = wordList.stream();
		Stream<String> sorted = words.sorted();
		show("sorted",sorted);
		
		words = wordList.stream();
		Stream<String> distinctSorted = words.distinct().sorted();
		show("distinctSorted",distinctSorted);
	}
}
