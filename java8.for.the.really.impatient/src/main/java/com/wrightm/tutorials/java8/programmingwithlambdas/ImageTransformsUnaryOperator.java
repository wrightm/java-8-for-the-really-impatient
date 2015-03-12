package com.wrightm.tutorials.java8.programmingwithlambdas;

import java.awt.font.TransformAttribute;
import java.util.function.*;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;

@FunctionalInterface
interface ColorTransformer {
	Color apply(int x, int y, Color colorAtXY);
}


public class ImageTransformsUnaryOperator extends Application {

	public static Image transform(Image in, UnaryOperator<Color> f){
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		
		for(int x=0; x < width; x++){
			for(int y=0; y < height; y++){
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}
	
	public static Image transform(Image in, ColorTransformer f) {
	      int width = (int) in.getWidth();
	      int height = (int) in.getHeight();
	      WritableImage out = new WritableImage(
	         width, height);
	      for (int x = 0; x < width; x++)
	         for (int y = 0; y < height; y++)
	            out.getPixelWriter().setColor(x, y, 
	               f.apply(x, y, in.getPixelReader().getColor(x, y)));
	      return out;
	   }
	
	public static UnaryOperator<Color> brighten(double factor) {
	      return c -> c.deriveColor(0, 1, factor, 1); 
	 }
	
	public static <T> UnaryOperator<T> compose(UnaryOperator<T> op1,
		      UnaryOperator<T> op2) {
      return t -> op2.apply(op1.apply(t));
   }
	
	@Override
	public void start(Stage stage) throws Exception {
		final String filename = "src/main/java/com/wrightm/tutorials/java8/programmingwithlambdas/queen-mary.png";
		Image image = new Image(filename);
	    Image brightenedImage = transform(image, brighten(1.2));
	    Image image3 = transform(image, compose(Color::brighter, Color::grayscale));
	    Image image2 = transform(image, 
	         (x, y, c) -> (x / 10) % 2 == (y / 10) % 2 ? Color.GRAY : c);
	    
	    stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(brightenedImage), new ImageView(image2))));
	    stage.show();
	}
	
	public static void main(String[] args){
		ImageTransformsUnaryOperator imageTransformsUnaryOperator = new ImageTransformsUnaryOperator();
		
	}
}
