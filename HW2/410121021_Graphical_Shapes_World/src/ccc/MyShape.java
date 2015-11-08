package ccc;
import java.awt.Shape;
import java.awt.geom.Area;

/** MyShape is an abstract class for deriving different classes of shapes. 
 * This abstract class implements the <b> IShapeAnalyzer </b> which does some
 * analyses of shapes.
 * @author ccchiang
 *
 */
public abstract class MyShape implements IShapeAnalyzer {
	protected double area; // the shape area
	private boolean collided; // the flag of collision

	public MyShape() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * Check if the shape collides with other shape 
	 * @return: true if collision
	 */
	public boolean isCollided() {
		return collided;
	}

	/** 
	 * Change the flag of collision
	 * @param collided: the flag of collision
	 */
	public void setCollided(boolean collided) {
		this.collided = collided;
	}

	/** 
	 * Return the area of the shape
	 * @return: the area
	 */
	public double getArea() {
		return area;
	}

	/** 
	 * Change the area of the shape
	 * @param area: the new area
	 */
	public void setArea(double area) {
		this.area = area;
	}

	/** 
	 * Return the associated java.awt.Shape object (Polygon or Ellipse2D) 
	 * @return: the associated java.awt.Shape object
	 */
	public abstract Shape getShape();

	@Override
	public int compareTo(MyShape s) {
		// TODO Auto-generated method stub
		if (this.calcArea() > s.calcArea())
			return 1;
		else if (this.calcArea() < s.calcArea())
			return -1;
		return 0;
	}

	@Override
	public boolean collide(MyShape s) {
		Area s1 = new Area(this.getShape()); 
		Area s2 = new Area(s.getShape()); 
		s1.intersect(s2);
		if(s1.isEmpty())
			return false; 
		return true;
	}

}
