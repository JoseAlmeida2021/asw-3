package mpjp.game;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import mpjp.shared.MPJPException;
import mpjp.shared.PieceStatus;
import mpjp.shared.PuzzleInfo;
import mpjp.shared.PuzzleLayout;
import mpjp.shared.PuzzleSelectInfo;
import mpjp.shared.PuzzleView;
import mpjp.shared.geom.PieceShape;
import mpjp.shared.geom.Point;

public class Workspace extends Object implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PuzzleInfo info;
	PuzzleStructure currentStructure;
	private Date start;
	
	static double widthFactor;
	static double heightFactor;
	static double radius;
	

	
	
	Workspace(PuzzleInfo info) throws MPJPException {
		this.info = info;
		this.currentStructure = new PuzzleStructure(this.info);
		this.start=new Date();
		widthFactor=2;
		heightFactor=2;
		radius=getSelectRadius()*2;
		this.scatter();
	}
	
	public static double getWidthFactor() {
		return widthFactor;
	}
	
	public static void setWidthFactor(double widthFactor) {
		Workspace.widthFactor=widthFactor;
	}
	
	public static double getHeightFactor() {
		return heightFactor;
	}
	
	public static void setHeightFactor(double heightFactor) {
		Workspace.heightFactor=heightFactor;
	}
	
	public static double getRadius() {
		return radius;
	}
	
	public static void setRadius(double radius) {
		Workspace.radius=radius;
	}
	
	public static String getId() {
		return "";
	}
	
	public static double getSelectRadius() {
		return radius;
		
	}
	
	 PuzzleSelectInfo getPuzzleSelectInfo() {
		return new PuzzleSelectInfo();
	}
	
	 int getPercentageSolved() {
		 return 100;
		//return puzzleLayout.getPercentageSolved();
	
	}
	
	PuzzleView getPuzzleView () {
		return new PuzzleView(); 
		//return puzzleView;
	}
	
	PuzzleLayout getCurrentLayout() {
		return new PuzzleLayout();
	};
	
	void scatter() {
		
	}
	
	void restore() {
		
	}
	
	void selectPiece(){
		
	}
	
	PuzzleLayout connect(int moveId, Point point) throws MPJPException{

		PieceStatus pieaceStatus1 = new PieceStatus(1, new Point(1,1));
		PieceStatus pieaceStatus2 = new PieceStatus(2, new Point(2,2));
		
		Map <Integer, PieceStatus> pieces = new HashMap<Integer, PieceStatus>();
		pieces.put(1, pieaceStatus1);
		pieces.put(2, pieaceStatus2);
		
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		
		Map <Integer, List<Integer>> blocks = new HashMap<Integer, List<Integer>>();
		blocks.put(1, list);
		blocks.put(2, list);
		
		PuzzleLayout solvedPuzzle = new PuzzleLayout(pieces,blocks,100);
		
		return solvedPuzzle;
	}
	
	PuzzleStructure getPuzzleStructure() {
		return currentStructure;
	}
}
