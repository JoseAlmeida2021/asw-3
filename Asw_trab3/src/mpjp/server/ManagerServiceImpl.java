package mpjp.server;

import mpjp.client.ManagerService;
import mpjp.game.Images;
import mpjp.game.Manager;
import mpjp.game.WorkspacePool;
import mpjp.shared.MPJPException;
import mpjp.shared.PuzzleInfo;
import mpjp.shared.PuzzleLayout;
import mpjp.shared.PuzzleSelectInfo;
import mpjp.shared.PuzzleView;
import mpjp.shared.geom.Point;

import java.io.File;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ManagerServiceImpl extends RemoteServiceServlet implements ManagerService {
	
	Manager manager = Manager.getInstance();

	  @Override
	    public void init() throws ServletException {
	        super.init();
	        ServletContext context = getServletContext();
	        File base = new File(context.getRealPath("/"));

	        File imagesdir = new File(base,"WEB-INF/classes/mpjp/resources");
	        File poolDir = new File(base,"WEB-INF/pool");

	        if(!poolDir.exists())
	            poolDir.mkdir();

	        Images.setImageDirectory(imagesdir);
	        WorkspacePool.setPoolDirectory(poolDir);
	    }
	@Override
	public Set<String> getAvailableCuttings() {
		return manager.getAvailableCuttings();
	}

	@Override
	public Set<String> getAvailableImages() {
		return manager.getAvailableImages();
	}

	@Override
	public Map<String, PuzzleSelectInfo> getAvailableWorkspaces() {
		return manager.getAvailableWorkspaces();
	}

	@Override
	public String createWorkspace(PuzzleInfo info) throws MPJPException {
		return manager.createWorkspace(info);
	}

	@Override
	public Integer selectPiece(String workspaceId, Point point) throws MPJPException {
		return manager.selectPiece(workspaceId, point);
	}

	@Override
	public PuzzleLayout connect(String workspaceId, int pieceId, Point point) throws MPJPException {
		return manager.connect(workspaceId, pieceId, point);
	}

	@Override
	public PuzzleView getPuzzleView(String workspaceId) throws MPJPException {
		return manager.getPuzzleView(workspaceId);
	}

	@Override
	public PuzzleLayout getCurrentLayout(String workspaceId) throws MPJPException {
		return manager.getCurrentLayout(workspaceId);
	}
}
