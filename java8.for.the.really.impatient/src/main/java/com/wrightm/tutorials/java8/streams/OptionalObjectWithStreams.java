package com.wrightm.tutorials.java8.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

public class OptionalObjectWithStreams {
	
	public static void main(String[] args) throws IOException {
		final String filename = "src/main/java/com/wrightm/tutorials/java8/streams/alice.txt";
		String contents = new String(Files.readAllBytes(Paths.get(filename)),StandardCharsets.UTF_8);
		
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		
		Optional<String> optionalValue = words.stream().filter(s->s.contains("red")).findFirst();
		
		optionalValue.ifPresent(s -> System.out.println(s+ "containes red"));
		
		Set<String> results = new HashSet<>();
		optionalValue.ifPresent(results::add);
		Optional<Boolean> added = optionalValue.map(results::add);
		System.out.println(added);
		
		optionalValue = words.stream().filter(s -> s.contains("fred")).findFirst();
		
		System.out.println(optionalValue.orElse("No word") + "contains fred");
		Optional<String> optionalString = Optional.empty();
		String result = optionalString.orElse("N/A");
		System.out.println("result: "+ result);
		result = optionalString.orElseGet(() -> System.getProperty("user.dir"));
		System.out.println("result: "+ result);
		
		try {
			result = optionalString.orElseThrow(NoSuchElementException::new);
			System.out.println("result: "+ result);
		} catch (NoSuchElementException exception){
			exception.printStackTrace();
		}	
		
		System.out.println(inverse(4.0).flatMap(OptionalObjectWithStreams::squareRoot));
		System.out.println(inverse(-1.0).flatMap(OptionalObjectWithStreams::squareRoot));
		System.out.println(inverse(0.0).flatMap(OptionalObjectWithStreams::squareRoot));
		Optional<Double> result2 = Optional.of(-4.0)
				.flatMap(OptionalObjectWithStreams::inverse)
				.flatMap(OptionalObjectWithStreams::squareRoot);
		
	}
	
	public static Optional<Double> inverse(Double x){
		return x == 0 ? Optional.empty() : Optional.of(1 / x);
	}
	
	public static Optional<Double> squareRoot(Double x){
		return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
	}
}
