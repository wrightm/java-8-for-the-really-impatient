package com.wrightm.tutorials.java8.streams;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

class City {
   private String name;
   private String state;
   private int population;

   public City(String name, String state, int population) {
      this.name = name;
      this.state = state;
      this.population = population;
   }

   public String getName() { return name; }
   public String getState() { return state; }
   public int getPopulation() { return population; }
}


public class GroupByPartitioningBy {

	public static Stream<City> readCities(String filename) throws IOException {
		return Files.lines(Paths.get(filename)).map(l -> l.split(", ")).map(a -> new City(a[0], a[1], Integer.parseInt(a[2]))); 
	}
	
	public static void main(String[] args){
		
	}
}
