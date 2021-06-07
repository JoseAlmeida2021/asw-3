package mpjp.shared;

import java.util.Map;

import mpjp.shared.geom.PieceShape;
import mpjp.shared.geom.Point;

import java.io.Serializable;
import java.util.Date;

/**
 * 	
 * Instances of this class provide the static data required to render a jigsaw puzzle 
 * on the client side,namely the workspace dimensions (width and height), puzzle dimensions, 
 * the image, the pieces' shape and locations in the complete (all pieces connected) puzzle.
 */
public class PuzzleView extends Object implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Name of the image on the puzzle background
	 */
	private String image;
	/**
	 *Map of pieces IDs to their location on the standard puzzle 
	 *(all pieces connected and with upper left corner at the origin).
	 */
	private Map<Integer,Point> locations;
	/**
	 * Height of piece rectangle on the puzzle structure
	 */
	private double pieceHeight;
	/**
	 * Width of piece rectangle on the puzzle structure
	 */
	private double pieceWidth;
	/**
	 * Height of the puzzle
	 */
	private double puzzleHeight;
	/**
	 * Width of the puzzle
	 */
	private double puzzleWidth;
	/**
	 * Map of pieces IDs to their shapes
	 */
	private Map<Integer,PieceShape> shapes;
	/**
	 * Moment when the jigsaw puzzle started being solved
	 */
	private Date start;
	/**
	 * Height of the workspace where the puzzle is solved
	 */
	double workspaceHeight;
	/**
	 * Width of the workspace where the puzzle is solved
	 */
	double workspaceWidth;
	
	/**
	 * Constructor
	 */
	public PuzzleView(Date start, 

			double workspaceWidth, 
			double workspaceHeight, 
			double puzzleWidth, 
			double puzzleHeight, 
			double pieceWidth, 
			double pieceHeight, 
			String image, 
			Map<Integer, PieceShape> shapes,
			Map<Integer, Point> locations) {
		this.start = start;
		this.workspaceWidth = workspaceWidth;
		this.workspaceHeight = workspaceHeight;
		this.puzzleWidth = puzzleWidth;
		this.puzzleHeight = puzzleHeight;
		this.pieceWidth = pieceWidth;
		this.pieceHeight = pieceHeight;
		this.image = image;
		this.shapes = shapes;
		this.locations = locations;
		
	}
	public PuzzleView() {};
		
	
	/**
	 * Date when this puzzle was started being solved
	 * 
	 * @return start Date
	 */
	public Date getStart() {
		return start;
	}
	
	/**
	 * Width of the workspace where the puzzle is solved
	 * 
	 * @return width
	 */
	public double getWorkspaceWidth() {
		return workspaceWidth;
	}
	
	/**
	 * Height of the workspace where the puzzle is solved
	 * 
	 * @return height
	 */
	public double getWorkspaceHeight() {
		return workspaceHeight;
	}
	
	/**
	 * Width of the puzzle being solved
	 * 
	 * @return width
	 */
	public double getPuzzleWidth() {
		return puzzleWidth;
	}
	
	/**
	 * Height of the puzzle being solved
	 * 
	 * @return height
	 */
	public double getPuzzleHeight() {
		return puzzleHeight;
	}
	
	/**
	 * Width of the puzzle being solved
	 * 
	 * @return width
	 */
	public double getPieceWidth() {
		return pieceWidth;
	}
	
	/**
	 * Height of the puzzle being solved
	 * 
	 * @return height
	 */
	public double getPieceHeight() {
		return pieceHeight;
	}

	
	/**
	 * Image on the puzzle. It may be null for a blank puzzle.
	 * 
	 * @return image
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * Shape of piece with given id.
	 * 
	 * @param id - of piece
	 * @return PieceShape
	 */
	public PieceShape getPieceShape(int id) {
		
		return shapes.get(id);
		
	}

	
	/**
	 * Location of piece in the complete puzzle (with pieces connected). 
	 * Position (0,0) is the top left corner.
	 * 
	 * @param id - of piece
	 * @return Point
	 */
	public Point getStandardPieceLocation(int id) {
		
		return locations.get(id);
		
	}


}
