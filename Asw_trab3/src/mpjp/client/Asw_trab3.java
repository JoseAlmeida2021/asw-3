package mpjp.client;

import mpjp.client.panels.AvailablePanel;
import mpjp.client.panels.FormPanel;
import mpjp.client.panels.PoolPanel;
import mpjp.client.panels.SolverPanel;
import mpjp.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Asw_trab3 implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final ManagerServiceAsync managerService = GWT.create(ManagerService.class);

	@Override
	public void onModuleLoad() {
		
		final PoolPanel poolPanel = new PoolPanel(managerService);
		final AvailablePanel availablePanel = new AvailablePanel(managerService);
		final FormPanel formPanel = new FormPanel(managerService);
		final SolverPanel solverPanel = new SolverPanel(managerService);

		// Create a three-item tab panel, with the tab area 2em tall.
		TabLayoutPanel p = new TabLayoutPanel(10, Unit.EM);
		
		p.add(formPanel, "Create new Puzzle");
		p.add(poolPanel, "Workspace Pool");
		p.add(availablePanel, "Available Workspaces");
		p.add(solverPanel, "Solving Puzzle");

		RootLayoutPanel.get().add(p);
	}
}
