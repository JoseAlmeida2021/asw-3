package mpjp.client;

import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.rpc.AsyncCallback;

import mpjp.shared.MPJPException;
import mpjp.shared.PuzzleInfo;
import mpjp.shared.PuzzleLayout;
import mpjp.shared.PuzzleSelectInfo;
import mpjp.shared.PuzzleView;
import mpjp.shared.geom.Point;


/**
 * The async counterpart of <code>ManagerService</code>.
 */
public interface ManagerServiceAsync {	
	
	void getAvailableCuttings(AsyncCallback<Set<String>> callback);
	void  getAvailableImages(AsyncCallback<Set<String>> callback);
	void  getAvailableWorkspaces(AsyncCallback<Map<String, PuzzleSelectInfo>> callback);
	void  createWorkspace(PuzzleInfo info,AsyncCallback<String> callback) throws MPJPException;
	void  selectPiece(String workspaceId, Point point,AsyncCallback<Integer> callback) throws MPJPException;
	void  connect(String workspaceId, int pieceId, Point point,AsyncCallback<PuzzleLayout> callback) throws MPJPException;
	void  getPuzzleView(String workspaceId,AsyncCallback<PuzzleView> callback) throws MPJPException;
	void  getCurrentLayout(String workspaceId,AsyncCallback<PuzzleLayout> callback) throws MPJPException;
}
