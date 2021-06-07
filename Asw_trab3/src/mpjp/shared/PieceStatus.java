package mpjp.shared;

import java.io.Serializable;

import mpjp.shared.geom.Point;

/**
 * The current status of a single puzzle's piece.
 */
public class PieceStatus extends Object implements HasPoint, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ID of the block this piece belongs to
	 */
	private int block;
	/**
	 * ID of a piece, a non-negative integer less than the number of pieces
	 */
	private int id;
	/**
	 * Current position of this piece
	 */
	private Point position;
	/**
	 * Rotation of this piece (unused in this prototype)
	 */
	private double rotation=0;
	//valor default por enquanto
	
	
	/**
	 * Constructor
	 */
	public PieceStatus() {
	
	}

	/**
	 * Constructor
	 */
	public PieceStatus(int id, Point position) {
		this.id = id;
		this.position = position;
	}

	/**
	 * The immutable id of this piece (i.e. cannot be changed)
	 * 
	 * @return id of this piece
	 */
	public Integer getId() {
		return id;
	}
	
	
	//getX in interface HasPoint -> alterar depois de implementar quad trees
	public double getX() {
		
		return position.getX();
		
	}
	
	//getY in interface HasPoint -> same
	public double getY() {
		
		return position.getY();
		
	}
	
	/**
	 * The current position of the piece "center" in the workspace
	 * 
	 * @return center
	 */
	public Point getPosition() {
		return position;
	}
	
	/**
	 * Change the position of the piece "center" in the workspace
	 * 
	 * @param position - of the piece's "center"
	 */
	public void setPosition(Point position) {
		this.position = position;
	}
	
	
	/**
	 * The ID block of connected pieces that this currently piece belongs to.
	 * 
	 * @return block
	 */
	public int getBlock() {
		return block;
	}
	
	/**
	 * Change the block ID this piece currently belongs to
	 * 
	 * @param block - id of this pieces's block
	 */
	public void setBlock(int block) {
		this.block=block;
	}

	
	
	/**
	 * Current rotation of this piece, in radians.
	 * 
	 * @return rotation
	 */
	public double getRotation() {
		return rotation;
	}
	
	
	/**
	 * Change the rotation of this piece.
	 * 
	 * @param rotation - of the piece
	 */
	public void setRotation(double rotation) {
		this.rotation = rotation;
	}



}
