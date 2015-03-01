package com.wrightm.tutorials.java8.lambdaexpressions;

import java.util.Arrays;
import java.util.Comparator;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

@SuppressWarnings("restriction")
public class OldStyle extends Application {

	public static void main(String[] args){
		Worker w = new Worker();
		new Thread(w).start();
		
		class LengthComparator implements Comparator<String> {
			public int compare(String first, String second){
				return Integer.compare(first.length(), second.length());
			}
		}
		
		String[] strings = "Mary had a little lamb".split(" ");
	    Arrays.sort(strings, new LengthComparator());
	    System.out.println(Arrays.toString(strings));
	    
	    launch(args);
	}

	public void start(Stage stage) throws Exception {
		Button button = new Button("Click me!");
	      button.setOnAction(new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent event) {
	               System.out.println("Thanks for clicking!");
	            }
	         });

	      stage.setScene(new Scene(button));
	      stage.show();
	}
}