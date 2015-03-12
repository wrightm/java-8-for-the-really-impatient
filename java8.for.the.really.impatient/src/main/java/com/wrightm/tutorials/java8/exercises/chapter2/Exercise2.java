package com.wrightm.tutorials.java8.exercises.chapter2;

import java.util.Comparator;
import java.util.stream.Stream;

public class Exercise2 {

	public static void main(String[] args){
		Stream<String> words = Stream.of("1234",
				"12345","123456",
				"1234567",
				"12345678",
				"123456789","12345678910",
				"12",
				"123",
				"1",
				"2",
				"3"
				,"9999",
				"N1",
				"O22");
		words.sorted((x,y) -> y.length() - x.length()).limit(5).forEach(System.out::println);
		
	}
}
