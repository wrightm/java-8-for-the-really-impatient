package com.wrightm.tutorials.java8.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConcurrentGrouping {

	public static void main(String[] args) throws IOException
    {
		final String filename = "src/main/java/com/wrightm/tutorials/java8/streams/alice.txt";
        String contents = new String(Files.readAllBytes(
                Paths.get(filename)), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("[\\P{L}]+"));
        Map<Integer, List<String>> result = wordList.stream().collect(
           Collectors.groupingByConcurrent(String::length));

        System.out.println(result.get(14));

        result = wordList.stream().parallel().collect(
           Collectors.groupingByConcurrent(String::length));

        System.out.println(result.get(14));
    }
}
