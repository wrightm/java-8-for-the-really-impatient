package com.wrightm.tutorials.java8.programmingwithlambdas;

import java.util.concurrent.*;
import java.util.function.*;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;

public class ParrelImageTransforms extends Application {

	public static Color[][] parallelTransform(Color[][] in, UnaryOperator<Color> f){
		int n = Runtime.getRuntime().availableProcessors();
		System.out.println("I am running on "+n+" processors");
		int height = in.length;
		int width = in[0].length;
		Color[][] out = new Color[height][width];
		try {
			ExecutorService pool = Executors.newCachedThreadPool();
			for(int i = 0; i < n; i++){
				int fromY = i * height/n;
				int toY = (i+1) * height /n;
				pool.submit(() -> {
					System.out.printf("%s %d...%d\n", Thread.currentThread(), fromY, toY - 1);
					for(int x = 0; x < width; x++){
						for(int y = fromY; y < toY; y++){
							out[y][x] = f.apply(in[y][x]);
						}
					}
				});
			}
			pool.shutdown();
	        pool.awaitTermination(1, TimeUnit.HOURS);
		}
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
		return out;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		final String filename = "src/main/java/com/wrightm/tutorials/java8/programmingwithlambdas/eiffel-tower.jpg";
		Image image = new Image(filename);
	      int width = (int) image.getWidth();
	      int height = (int) image.getHeight();
	      Color[][] pixels = new Color[height][width];
	      for (int x = 0; x < width; x++)
	         for (int y = 0; y < height; y++)
	            pixels[y][x] = image.getPixelReader().getColor(x, y);
	      pixels = parallelTransform(pixels, Color::grayscale);
	      WritableImage result = new WritableImage(
	         width, height);
	      for (int x = 0; x < width; x++)
	         for (int y = 0; y < height; y++)
	            result.getPixelWriter().setColor(x, y, pixels[y][x]);
	      stage.setScene(new Scene(new HBox(
	               new ImageView(image),
	               new ImageView(result))));
	      stage.show();
	}

}
