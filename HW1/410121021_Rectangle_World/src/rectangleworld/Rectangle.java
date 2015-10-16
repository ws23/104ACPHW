package rectangleworld;

import java.awt.geom.Point2D;

public class Rectangle implements Comparable<Rectangle>{
	// Inner class: Vector
	private class Vector {
		double x, y; 
	
		// Constructor: set a vector from p1 to p2
		public Vector(double p1x, double p1y, double p2x, double p2y){
			this.setVector(p1x, p1y, p2x, p2y); 
		}
		
		// Constructor: set a vector from p1 to p2
		public Vector(Point2D p1, Point2D p2){
			this.setVector(p1, p2); 
		}

		// Setter: set a vector from p1 to p2
		public void setVector(double p1x, double p1y, double p2x, double p2y){
			x = p2x - p1x; 
			y = p2y - p1y; 
		}
		
		// Setter: set a vector from p1 to p2
		public void setVector(Point2D p1, Point2D p2){
			x = p2.getX() - p1.getX(); 
			y = p2.getY() - p1.getY(); 
		}
		
		// Getter
		public double getX(){
			return x; 
		}
		public double getY(){
			return y; 
		}
		
		// to get the projection point
		public Point2D.Double getProjectionPoint(Point2D.Double p){
			double tmp1, tmp2, tmp;
			tmp1 = p.getX() * this.getX() + p.getY() * this.getY(); 
			tmp2 = this.getX() * this.getX() + this.getY() * this.getY();
			tmp = tmp1/tmp2; 
			return (new Point2D.Double(tmp*this.getX(), tmp*this.getY())); 
		}
		
		// To calculate the scalar value
		private double getScalarValue(Point2D.Double p){
			return p.getX() * this.getX() + p.getY() * this.getY();  
		}
		
		// inner product
		public double innerProduct(Vector v2){
			return this.getX()*v2.getX() + this.getY()*v2.getY(); 
		}
		
		//  Judge if two vector is right angle or not 		
		public boolean isRightAngle(Vector v2){
			if ( innerProduct(v2) <= 0.0000001 && innerProduct(v2) >= -0.0000001 ) // Equal 0 is right angle, but program has round-off error 
				return true; 
			else
				return false; 
		}
	}
	
	
	
	
	// Member variables 
	private Point2D.Double oriPoints[] = new Point2D.Double[3]; 
	private Point2D.Double points[] = new Point2D.Double[4]; 
	
	// Constructor 
	public Rectangle(){
		for(int i=0; i<4; i++)
			points[i] = new Point2D.Double(); 
	}
	public Rectangle(double x1, double y1, double x2, double y2, double x3, double y3){
		for(int i=0; i<4; i++){
			points[i] = new Point2D.Double();
			if(i<3)
				oriPoints[i] = new Point2D.Double(); 
		}
		setRectangle(x1, y1, x2, y2, x3, y3); 
	}
	
	// Setter 
	public void setRectangle(double x1, double y1, double x2, double y2, double x3, double y3){
		
		// Store the origin point sequence
		oriPoints[0].setLocation(x1, y1); 
		oriPoints[1].setLocation(x2, y2); 
		oriPoints[2].setLocation(x3, y3);
		
		// Store the point that points[1] is right angle
		if(new Vector(x2, y2, x1, y1).isRightAngle(new Vector(x2, y2, x3, y3)) == true){
			points[0].setLocation(x1, y1); 
			points[1].setLocation(x2, y2); 
			points[2].setLocation(x3, y3); 
		}
		else if(new Vector(x3, y3, x2, y2).isRightAngle(new Vector(x3, y3, x1, y1)) == true){
			points[0].setLocation(x1, y1); 
			points[1].setLocation(x3, y3); 
			points[2].setLocation(x2, y2); 
		}
		else if(new Vector(x1, y1, x2, y2).isRightAngle(new Vector(x1, y1, x3, y3)) == true){
			points[0].setLocation(x2, y2); 
			points[1].setLocation(x1, y1); 
			points[2].setLocation(x3, y3); 
		}
		
		// Use vector to get points[3]
		Vector v = new Vector(points[1], points[2]);
		points[3].setLocation(points[0].getX() + v.getX(), points[0].getY() + v.getY());  			
	}
	

	// Get the area of the rectangle 
	public double getArea(){
		double edge1 = this.getPoints(0).distance(this.getPoints(1));
		double edge2 = this.getPoints(1).distance(this.getPoints(2)); 
		double area = edge1 * edge2; 
		return area; 
	}
	
	public Point2D.Double getPoints(int index){
		return points[index]; 
	}
	// According this comparator  to do sorting.  
	public int compareTo(Rectangle compareRectangle){
		double compare = compareRectangle.getArea(); 
		double mine = this.getArea(); 
		if(compare>mine)
			return 1; 
		else
			return -1;   
	}
	
	// To detect collision
	public boolean detectCollision(Rectangle r2){
		Vector axis[][] = new Vector[2][2]; 
		axis[0][0] = new Vector(this.getPoints(1), this.getPoints(2)); 
		axis[0][1] = new Vector(this.getPoints(1), this.getPoints(0)); 
		axis[1][0] = new Vector(r2.getPoints(1), r2.getPoints(2)); 
		axis[1][1] = new Vector(r2.getPoints(1), r2.getPoints(0)); 
		
		Point2D.Double tmp, min1, min2, max1, max2; 
		for(int i=0; i<2; i++){ // which rectangle
			for(int j=0; j<2; j++){ // which axis
				max1 = min1 = axis[i][j].getProjectionPoint(this.getPoints(0));
				max2 = min2 = axis[i][j].getProjectionPoint(r2.getPoints(0)); 
				for(int k=1; k<4; k++){ // which point
					tmp = axis[i][j].getProjectionPoint(this.getPoints(k));
					if(axis[i][j].getScalarValue(tmp) < axis[i][j].getScalarValue(min1))
						min1 = tmp; 
					else if(axis[i][j].getScalarValue(tmp) > axis[i][j].getScalarValue(max1))
						max1 = tmp; 
					
					tmp = axis[i][j].getProjectionPoint(r2.getPoints(k)); 
					if(axis[i][j].getScalarValue(tmp) < axis[i][j].getScalarValue(min2))
						min2 = tmp; 
					else if(axis[i][j].getScalarValue(tmp) > axis[i][j].getScalarValue(max2))
						max2 = tmp; 					
				}
				// Use scalar value to judge the relation of each points
				double min1v = axis[i][j].getScalarValue(min1); 
				double max1v = axis[i][j].getScalarValue(max1); 
				double min2v = axis[i][j].getScalarValue(min2); 
				double max2v = axis[i][j].getScalarValue(max2);
				if(min1v<min2v){
					if(min2v>max1v)
						return false;  
				}
				else{
					if(min1v>max2v)
						return false; 
				}
			}
		}
		return true;
	}
	
	// To print the information
	public void printRectangle(){
		for(int i=0; i<3; i++){
			System.out.printf("%.6f %.6f ", oriPoints[i].getX(), oriPoints[i].getY()); 
		}
		System.out.printf("A=%.6f\n", this.getArea());
	}
}
