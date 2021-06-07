package mpjp.shared;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 	Current puzzle layout, the status (position, rotation) of each piece, 
 * and the blocks pieces fit together.
 */
public class PuzzleLayout extends Object implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Map from block IDs (integers) to the list IDs of the pieces it contains
	 */
	private Map<Integer,List<Integer>> blocks;
	/**
	 * Percentage of the puzzle already solved ([0 - 100])
	 */
	private int percentageSolved;
	/**
	 * Map from piece IDs (integers) to piece status
	 */
	private Map<Integer,PieceStatus> pieces;
	
	public PuzzleLayout(){
		
	}
	
	public PuzzleLayout(Map<Integer, PieceStatus> pieces, Map<Integer, List<Integer>> blocks, int percentageSolved) {
			this.pieces = pieces;
			this.blocks = blocks;
			this.percentageSolved = percentageSolved;
	}
	
	/**
	 * Piece status indexed by their IDs
	 * 
	 * @return map of piece IDs to the status
	 */
	public Map<Integer, PieceStatus> getPieces() {
		return pieces;
	}

	/**
	 * The list of pieces belonging to a block indexed by bloc id (a positive integer)
	 * 
	 * @return map of block IDs to lists of piece IDs
	 */
	public Map<Integer, List<Integer>> getBlocks() {
		return blocks;
	}
	
	/**The puzzle is complete when it has a single block When 2 pieces are fit together, 
	 * they become part of the same block, as all the other pieces belonging to their blocks
	 * 
	 * @return true if solved; false otherwise
	 */
	public boolean isSolved() {
		return blocks.size()==1;
	}

	/**
	 * @param blocks the blocks to set
	 */
	public void setBlocks(Map<Integer, List<Integer>> blocks) {
		this.blocks = blocks;
	}

	/**
	 * @return the percentageSolved
	 */
	public int getPercentageSolved() {
		return percentageSolved;
	}
	
	

	
	
	
	
	
}