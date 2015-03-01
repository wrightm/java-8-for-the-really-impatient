package com.wrightm.tutorials.java8.lambdaexpressions;

import java.util.*;
import javafx.event.*;


public class Lambdas {

	public static void main(String[] args){
		Comparator<String> comp = (String first, String second) -> Integer.compare(first.length(), second.length());
		comp = (String first, String second) -> {
			if(first.length() < second.length()) {
				return -1;
			} else if(first.length() > second.length()){
				return 1;
			} else {
				return 0;
			}
		};
		
		Runnable runner = () -> {
			for(int i = 0; i < 1000; i++){
				doWork();
			}
		};
		
		comp = (first, second) -> Integer.compare(first.length(), second.length());
		
		EventHandler<ActionEvent> listener = (event) -> {
			System.out.println(event.getTarget());
		};
	}
	
	public static void doWork(){
	}
}
