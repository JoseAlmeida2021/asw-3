package mpjp.game;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import mpjp.shared.MPJPException;
import mpjp.shared.PuzzleInfo;
import mpjp.shared.PuzzleSelectInfo;

public class WorkspacePool extends Object {
	
	
	private static String SERIALIZATION_SUFFIX=".ser";
	private static File poolDirectory = new File(".");
	
	private static Map<String,Workspace> availableWorkspaces;
	private static Map<String,File> availablePuzzleInfo;

	
	public WorkspacePool() {
		availableWorkspaces = new HashMap<String,Workspace>();
		availablePuzzleInfo = new HashMap<String,File>();
	}
	

	public static File getPoolDirectory() {
		return poolDirectory;
	}
	
	public static void setPoolDirectory(File poolDirectory) {
		WorkspacePool.poolDirectory=poolDirectory;
	}
	
	static void setPoolDirectory(String pathname) {
		poolDirectory = new File(pathname);
	}
	
	String createWorkspace(PuzzleInfo info) throws MPJPException {
		Workspace workspace = new Workspace(info);
		availableWorkspaces.put(workspace.getId(), workspace);
		try{
			backup(workspace.getId(), workspace);
			return workspace.getId();
		}catch(Exception e) {
			throw new MPJPException("");
		}
	}
	
	Workspace getWorkspace(String id) {
		return availableWorkspaces.get(id);
	}

	Map<String,PuzzleSelectInfo> getAvailableWorkspaces() {
		return null;
	}
	
	private File getFile(String workspaceId) {
		return null;
	}
		
	private void backup(String workspaceId, Workspace workspace)  throws MPJPException {
	}
		
	private Workspace recover(String workspaceId) throws MPJPException {
		return null;
	}
		
	private void reset() {
		poolDirectory = new File(".");
		availableWorkspaces = new HashMap<String,Workspace>();
	}
		
		
}
