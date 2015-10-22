package ccc;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Shape;

public class XShape  extends MyShape {
	private Polygon polygon; 
	
	public XShape(){
		polygon = new Polygon();
		
	}
	
	public double calcArea(){
		return 0; 
	}
	
	public void draw(Graphics g){
		g.drawPolygon(polygon); 
	}

	public void fill(Graphics g) {
		g.fillPolygon(polygon); 
	}

	public Shape getShape(){
		return polygon; 
	}
}
