package mpjp.shared.geom;

import java.io.Serializable;


/**
 * A line segment from the previous point to the given one.
 */
public class LineTo extends Object implements Segment, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * End point in this line segment
	 */
	private Point endPoint;
	
	/**
	 * Constructor of an empty instance
	 */
	public LineTo() {
	
	}
	
	/**
	 * Constructor A line segment to the given end point
	 */
	public LineTo(Point endPoint) {
		this.endPoint = endPoint;
	}

	/**
	 * The current end point
	 * 
	 * @return endPoint
	 */
	public Point getEndPoint() {
		return endPoint;
	}

	/**
	 * Change the end point
	 * 
	 * @param endPoint - end point
	 */
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	
	
}
