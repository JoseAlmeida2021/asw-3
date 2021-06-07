package mpjp.shared.geom;

import java.io.Serializable;

/**
 * A segment of a quadratic curve from the previous point to the given one.
 */
public class QuadTo extends Object implements Segment, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The control point of this quadratic curve segment
	 */
	private Point controlPoint;
	/**
	 * The end point of this quadratic curve segment
	 */
	private Point endPoint;
	
	/**
	 * An empty instance
	 */
	public QuadTo() {

	}
	
	/**
	 * A quadratic segment from given control point and end point
	 * 
	 * @param controlPoint - control point
	 * endPoint - end point
	 */
	public QuadTo(Point controlPoint, Point endPoint) {
		this.controlPoint = controlPoint;
		this.endPoint = endPoint;
	}

	/**
	 * Current control point
	 * 
	 * @return the controlPoint
	 */
	public Point getControlPoint() {
		return controlPoint;
	}

	/**
	 * Change control point
	 * 
	 * @param controlPoint - control point
	 */
	public void setControlPoint(Point controlPoint) {
		this.controlPoint = controlPoint;
	}

	/**
	 * The current end point
	 * 
	 * @return the endPoint
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
