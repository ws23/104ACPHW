package rectangleworld;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		RectangleWorld recWorld = new RectangleWorld(); 
		
		// To read the file to get the input data
		recWorld.readFile(); 
		// To sort the rectangles by area
		recWorld.sortByArea();
		// To detect the collision of each rectangles to the largest one
		recWorld.detectCollision(); 
		// To print the world
		recWorld.printRectangleWorld(); 
		
	}

}
