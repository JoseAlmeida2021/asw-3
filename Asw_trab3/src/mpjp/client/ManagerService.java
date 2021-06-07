package mpjp.client;

import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import mpjp.shared.MPJPException;
import mpjp.shared.PuzzleInfo;
import mpjp.shared.PuzzleLayout;
import mpjp.shared.PuzzleSelectInfo;
import mpjp.shared.PuzzleView;
import mpjp.shared.geom.Point;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("game")
public interface ManagerService extends RemoteService {
	Set<String> getAvailableCuttings();
	Set<String> getAvailableImages();
	Map<String, PuzzleSelectInfo> getAvailableWorkspaces();
	String createWorkspace(PuzzleInfo info) throws MPJPException;
	/**
	 * Select a piece in the given workspace, with its "center" near the given point.
	 * 
	 * @param workspaceId; point;
	 */
	Integer selectPiece(String workspaceId, Point point) throws MPJPException;

	PuzzleLayout connect(String workspaceId, int pieceId, Point point) throws MPJPException;

	PuzzleView getPuzzleView(String workspaceId) throws MPJPException;

	PuzzleLayout getCurrentLayout(String workspaceId) throws MPJPException;
}
