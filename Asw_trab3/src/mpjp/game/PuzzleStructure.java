package mpjp.game;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mpjp.shared.MPJPException;
import mpjp.shared.PuzzleInfo;
import mpjp.shared.geom.Point;



/**
 * A PuzzleStructure is responsible for connecting neighboring pieces.
 */
public class PuzzleStructure extends Object implements Iterable<Integer> {
	
	private int rows;
	private int columns;
	private double width;
	private double height;
	
	
	/**
	 * Create an instance from raw data 
	 * 
	 * @param rows - in puzzle's panel
	 * @param columns - in puzzle's panel 
	 * @param width - of puzzle
	 * @param height - of puzzle
	 */
	public PuzzleStructure(int rows, int columns,double width, double height){
		this.rows=rows;
		this.columns=columns;
		this.width=width;
		this.height=height;
		
	}
	
	/**
	 * Create instance from data in PuzzleInfo
	 * 
	 * @param info - containing data for instantiation
	 */
	public PuzzleStructure(PuzzleInfo info) {
		this(info.getRows(),info.getColumns(), info.getWidth(), info.getHeight());
	}
	
	
	void init(int rows,
			int columns,
			double width,
			double height) {
	}
	
	/**
	 * Number of pieces in this piece structures 
	 * 
	 * @return pieceCount
	 */
	public int getPieceCount() {
		return rows*columns;
	}
	
	/**
	 * Current number of rows
	 * 
	 * @return rows
	 */
	public int getRows() {
		return rows;
	}
	
	/**
	 * Change number of rows
	 * 
	 * @param rows - to change
	 */
	public void setRows(int rows) {
		this.rows=rows;
	}
	
	/**
	 * Current number of columns
	 * 
	 * @return columns
	 */
	public int getColumns() {
		return columns;
	}
	
	/**
	 * Change number of columns
	 * 
	 * @param columns - to c
	 */
	public void setColumns(int columns) {
		this.columns=columns;
		
	}
	/**
	 * Current width
	 * 
	 * @return width
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * Change width 
	 * 
	 * @param width - to change
	 */
	public void setWidth(double width) {
		this.width=width;
	}
	
	/**
	 * Current height
	 * 
	 * @return height
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Change height
	 * 
	 * @param height - to change
	 */
	public void setHeight(double height) {
		this.height=height;
	}
	
	/**
	 * Width of a panel cell assigned to a piece.
	 * 
	 * @return - to change
	 */
	public double getPieceWidth() {
		return width/columns;
	}
	
	/**
	 * Height of a panel cell assigned to a piece.
	 * 
	 * @return pieceHeight
	 */
	public double getPieceHeight() {
		return height/rows;
	}
	
	/**
	 * The ID of the piece facing in the given direction.
	 * 
	 * @param direction - where returned piece is facing
	 * @param id - of the piece used as reference
	 * @return if of facing piece, or null if no piece is facing in that direction;
	 */
	public Integer getPieceFacing(Direction direction,Integer id) {
		
		try {
			if( (this.getPieceColumn(id) == this.getColumns() -1 && direction.getSignalX() == 1 ) ||
			  ( this.getPieceRow(id) ==this.getRows() -1 && direction.getSignalY() == 1 ) || 
			  ( this.getPieceColumn(id) == 0 && direction.getSignalX() == -1 ) ||
			  ( this.getPieceRow(id) == 0 && direction.getSignalY() == -1 ) )
				return null;
		} catch (MPJPException e) {
			e.printStackTrace();
		}
		
		if(direction.getSignalY() == 0 ) {
			
			id += direction.getSignalX();
			
			return id;
		}
		
		else {

			id+=direction.getSignalY() * this.getColumns();
			
			return id;
		}
		  

	}
	
	/**
	 * The center of a matching piece facing in the given direction with given center.
	 * @param direction - where returned piece is facing
	 * @param point - at the center of the piece used as reference
	 * @return center of matching piece
	 */
	Point getPieceCenterFacing(Direction direction,Point point) {

		Point pieceCenter = new Point(point.getX(), point.getY());
		
		int facingPieceX = (int) (pieceCenter.getX() + (direction.getSignalX() * this.getPieceWidth()));
		int facingPieceY = (int) (pieceCenter.getY() + (direction.getSignalY() * this.getPieceHeight()));
		
		 pieceCenter.setX(facingPieceX);
		 pieceCenter.setY(facingPieceY);
		
		return pieceCenter;
	}
	
	/**
	 * The row of the given piece ID
	 * 
	 * @param id - of the piece
	 * @return row
	 * @throws MPJPException - if id is invalid
	 */
	public int getPieceRow(int id) throws MPJPException{
		if(id < 0 || id >= this.getPieceCount())
			throw new MPJPException("Invalid id");
		return id/this.getColumns();
	}
	
	/**
	 * The column of the given piece ID
	 * 
	 * @param id - of the piece
	 * @return column
	 * @throws MPJPException - if id is invalid
	 */
	public int getPieceColumn(int id) throws MPJPException{
		if(id < 0 || id >= this.getPieceCount())
			throw new MPJPException("Invalid id");
		return id%this.getColumns();
		
	}
	
	/**
	 * Locations of a given piece in the final position, 
	 * assuming the origin at (0,0) on the upper left corner
	 * 
	 * @return map of IDs to locations
	 */
	public Map<Integer, Point> getStandardLocation(){
		Map<Integer, Point> map = new HashMap<Integer,Point>();
		
		for(int i = 0; i < this.getPieceCount(); ++i) {
			Point center = new Point();
			try {
				center=this.getPieceStandardCenter(i);
			} catch (MPJPException e) {
		
				e.printStackTrace();
			}
			
			map.put(i,center);
			
		}
		return map;
	}
	
	/**
	 * Center of given piece in the final position,
	 *  assuming the origin at (0,0) on the uper left corner
	 *  
	 * @param id - of piece
	 * @return center as Point
	 * @throws MPJPException - if id is invalid
	 */
	public Point getPieceStandardCenter(int id) throws MPJPException{
		
		if(id < 0 || id >= this.getPieceCount()) 
			throw new MPJPException("Invalid id");
		
		Point standardCenter = new Point(this.getPieceWidth()/2 ,this.getPieceHeight()/2 );
		
		 int finalPositionX = (int) (standardCenter.getX() + (this.getPieceWidth() * this.getPieceColumn(id)));
		 int finalPositionY = (int) (standardCenter.getY() + (this.getPieceHeight() *  this.getPieceRow(id)));
		
		 standardCenter.setX(finalPositionX);
		 standardCenter.setY(finalPositionY);
		
		return standardCenter;
	}
	
	/**
	 * Set of pieces where a point might be located in complete puzzle.
	 * Center of coordinates in to top left corner of the puzzle.
	 * 
	 * @param point - in piece
	 * @return set of piece Ids that may contain given point
	 */
	public Set<Integer> getPossiblePiecesStandarFor(Point point) {
		Set<Integer> possiblePieces = null;
		
		return possiblePieces;

	}
	
	/**
	 * A random point in the standard puzzle, with origin(0,0) at the upper left corner and bottom right corner
	 * 
	 * @return point in standard puzzle
	 */
	public Point getRandomPointInStandardPuzzle() {
		
		double x = Math.random() * this.getWidth();
		double y = Math.random() * this.getHeight();
		
		Point randomPoint = new Point(x,y);
		
		return randomPoint;

	}
	
	/**
	 * Iterator over piece ids, an integer from 0 (inclusive) to the number of pieces (exclusive), in ascending order
	 */
	@Override
	public Iterator<Integer> iterator() { 
		List<Integer> idList = new LinkedList<>();
		for (int i = 0; i < this.getPieceCount(); i++) {
			idList.add(i);
		}
		return idList.iterator();

	}

	
		
	}
	
