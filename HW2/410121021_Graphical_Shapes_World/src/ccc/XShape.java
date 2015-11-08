package ccc;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Shape;

public class XShape  extends MyShape {
	private Polygon polygon;
	private int polygonSize; 
	
	// Construtor	
	public XShape(int x, int y){
		int[] arrX = new int[]{-1, -2, -1, 1, 2, 1, 0, 1, -1, 0}; 
		int[] arrY = new int[]{3, -1, -2, -2, -1, 3, 2, -1, -1, 2}; 
		
		for(int i=0; i<arrX.length; i++){
			// Move
			arrX[i] += x; 
			arrY[i] += y; 
		}
		polygon = new Polygon(arrX, arrY, arrX.length); 
		polygonSize = 12; 	
	}

	public XShape(int x, int y, int size){
		// Set the Shape's polygon
		int[] arrX = new int[]{-1, -2, -1, 1, 2, 1, 0, 1, -1, 0}; 
		int[] arrY = new int[]{3, -1, -2, -2, -1, 3, 2, -1, -1, 2}; 
		
		for(int i=0; i<arrX.length; i++){
			// Change size
			arrX[i] *= size;  
			arrY[i] *= size; 
			
			// Move
			arrX[i] += x; 
			arrY[i] += y; 
		}
		polygon = new Polygon(arrX, arrY, arrX.length); 
		polygonSize = 12 * size * size; 	
	}
	
	// Calculate the area
	public double calcArea(){
		return polygonSize; 
	}
	
	// Draw the shape
	public void draw(Graphics g){
		g.drawPolygon(polygon); 
		
	}

	// Fill the shape
	public void fill(Graphics g) {
		g.fillPolygon(polygon); 
	}

	// Return the polygon with Shape type
	public Shape getShape(){
		return polygon; 
	}
}
