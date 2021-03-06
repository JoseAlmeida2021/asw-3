package mpjp.shared.geom;

import java.io.Serializable;

//import java.io.Serializable;


/**
 * A pair or integer coordinates in the plane.
 */
public class Point extends Object implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *The horizontal coordinate of this point
	 */
	private double x;
	/**
	 *The vertical coordinate of this point
	 */
	private double y;
	
	/**
	 * Constructor 
	 * 
	 * Create point at origin
	 */
	public Point() {
		this.x=0;
		this.y=0;
	} 
	
	/**Constructor 
	 * 
	 * Create point from coordinates
	 * @param x-coordinate y-coordinate
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 *  The X coordinate of this point
	 *  
	 * @return x
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * The Y coordinate of this point
	 * 
	 * @return y
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * 
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 *
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}
