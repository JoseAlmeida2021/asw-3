package mpjp.game.cuttings;

import java.util.HashMap;
import java.util.Map;

import mpjp.game.PuzzleStructure;
import mpjp.shared.geom.PieceShape;
import mpjp.shared.geom.Point;
import mpjp.shared.geom.LineTo;

/**
 * This is a very simple cutting where each piece is just a rectangle with its center at the origin (0,0)
 * 
 *
 */
public class StraightCutting implements Cutting {
	
	
	StraightCutting() {
		
	}
	
	/**
	 * Produce a map of piece Id(Integer) to PieceShape
	 * 
	 * @param - structure - an instance of PuzzleStructure
	 * @return map
	 */
	@Override
	public Map<Integer, PieceShape> getShapes(PuzzleStructure structure) {
		
		Map<Integer, PieceShape> map = new HashMap<Integer,PieceShape>();
		
		int count = structure.getPieceCount();
		double width = structure.getPieceWidth();
		double height = structure.getPieceHeight();
		
		Point bottomLeft = new Point(-width/2,-height/2);
		Point bottomRight = new Point(width/2,-height/2);
		Point topLeft = new Point(-width/2,height/2);
		Point topRight = new Point(width/2,height/2);
		
		for(int i = 0 ; i < count ; i++) {
			PieceShape straightPiece = new PieceShape(bottomLeft)
				.addSegment(new LineTo(bottomRight)).addSegment(new LineTo(topRight))
				.addSegment(new LineTo(topLeft)).addSegment(new LineTo(bottomLeft));
				
				map.put(i,straightPiece);
			}
		
		return map;
		

	}

}
