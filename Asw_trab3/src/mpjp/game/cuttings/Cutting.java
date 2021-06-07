package mpjp.game.cuttings;


import mpjp.shared.geom.PieceShape;
import mpjp.game.PuzzleStructure;
import java.util.Map;

/**
 * A Cutting provides a method to trace the boundaries of jigsaw puzzle pieces.
 *
 */
public interface Cutting {
	
	/**
	 * Produce a map of piece ID(Integer) to PieceShape
	 * 
	 * @param structure
	 * @return
	 */
	Map<Integer,PieceShape> getShapes(PuzzleStructure structure);
	
}