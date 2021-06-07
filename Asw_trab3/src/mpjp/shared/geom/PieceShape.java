package mpjp.shared.geom;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Representation of the boundary if a piece 
 * as an initial Point followed by by a list of Segment.
 */
public class PieceShape extends Object implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * List of segments, each starting at the end of the preceding one, or the start point.
	 */
	private List<Segment> segments;
	/**
	 * Start point of this shape
	 */
	private Point startPoint;
	
	/**
	 * Create an empty piece shape
	 */
	public PieceShape() {
		segments = new LinkedList<Segment>();
	}
	
	/**
	 * Create a piece shape with an initial point.
	 * 
	 * @param startPoint - start point
	 */
	public PieceShape(Point startPoint) {
		this.startPoint = startPoint;
		segments = new LinkedList<Segment>();
	}
	
	/**
	 * Create a complete shape from an initial point as a list of segments
	 * 
	 * @param startPoint - start point
	 * segments - list of Segment
	 */
	public PieceShape(Point startPoint, List<Segment> segments) {
		this.startPoint = startPoint;
		this.segments = segments;
	}

	/**
	 * The current starting point
	 * 
	 * @return point
	 */
	public Point getStartPoint() {
		return startPoint;
	}


	/**
	 * Change the starting point
	 * 
	 * @param startPoint - start point
	 */
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	/**
	 * The current list of segments
	 * 
	 * @return the segments
	 */
	public List<Segment> getSegments() { 
		return segments;
	}

	/**
	 * Change the list of segments
	 * 
	 * @param segments - list of Segment
	 */
	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}
	
	/**
	 * Add a segment to this shape
	 * 
	 * @param segment - to be added
	 * @return this instance, to allow chaining
	 */
	public PieceShape addSegment(Segment segment) {
		
		segments.add(segment);
			
		return this;
	}
	
}