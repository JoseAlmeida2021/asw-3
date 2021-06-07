package mpjp.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import mpjp.client.ManagerService;
import mpjp.game.cuttings.CuttingFactoryImplementation;
import mpjp.shared.MPJPException;
import mpjp.shared.PuzzleInfo;
import mpjp.shared.PuzzleLayout;
import mpjp.shared.PuzzleSelectInfo;
import mpjp.shared.PuzzleView;
import mpjp.shared.geom.LineTo;
import mpjp.shared.geom.PieceShape;
import mpjp.shared.geom.Point;

public class Manager extends Object implements ManagerService{
	
	private WorkspacePool workspacePool;
	static Manager instance = null;
	
	private Manager() {
		this.workspacePool= new WorkspacePool();
		instance = null;
	}
	
	
	public static Manager getInstance() {
		
		if (instance == null) {
			instance = new Manager();
			return instance;
		}
		return instance;
	}
	
	void reset() {
		instance = new Manager();
		
	}
	
	@Override
	public Set<String> getAvailableCuttings() {
		return new CuttingFactoryImplementation().getAvaliableCuttings();
	}
	
	@Override
	public Set<String> getAvailableImages() {
		return Images.getAvailableImages();
	}
	
	@Override
	public Map<String,PuzzleSelectInfo> getAvailableWorkspaces() {
		return workspacePool.getAvailableWorkspaces();
	}
	
	@Override
	public String createWorkspace(PuzzleInfo info ) throws MPJPException {
		return workspacePool.createWorkspace(info);
	}
	
	/**
	 * Select a piece in the given workspace, with its "center" near the given point.
	 * 
	 * @param workspaceId; point;
	 */
	@Override
	public Integer selectPiece(String workspaceId,Point point) throws MPJPException {
		return 1;
		//return availableWorkspaces.get(workspaceId).selectPiece(point);
	}
	
	@Override
	public PuzzleLayout connect(String workspaceId, int pieceId, Point point) throws MPJPException {
		return workspacePool.getWorkspace(workspaceId).connect(pieceId, point);
	}
	
	@Override
	public PuzzleView getPuzzleView(String workspaceId) throws MPJPException {
		PuzzleInfo pi = new PuzzleInfo();
		PuzzleSelectInfo pzi = new PuzzleSelectInfo();
		
		PieceShape square = new PieceShape(new Point(100,100))
	    	      .addSegment(new LineTo(new Point(100,-100)))
	    	      .addSegment(new LineTo(new Point(-100,-100)))
	    	      .addSegment(new LineTo(new Point(-100,100)))
	    	      .addSegment(new LineTo(new Point(100,100))); 
		
		Map <Integer, PieceShape> pieceSizeMap = new HashMap<Integer, PieceShape>();
		pieceSizeMap.put(1, square);
		pieceSizeMap.put(2, square);
		
		
		Map <Integer, Point> positionMap = new HashMap<Integer, Point>();
		Point pX = new Point(1,1);
		Point pY = new Point(2,2);
		positionMap.put(1, pX);
		positionMap.put(2, pY);
		
		PuzzleView puzzleView = new PuzzleView(pzi.getStart(), 100, 100, 2, 2,1, 1, "url", pieceSizeMap, positionMap);
		
		return puzzleView;
		//return workspacePool.getWorkspace(workspaceId).getPuzzleView();
	}
	
	@Override
	public PuzzleLayout getCurrentLayout(String workspaceId) throws MPJPException {
		return workspacePool.getWorkspace(workspaceId).getCurrentLayout();

	}
}
