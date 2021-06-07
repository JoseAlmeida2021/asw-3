package mpjp.client.panels;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

import mpjp.client.ManagerServiceAsync;
import mpjp.shared.PuzzleSelectInfo;

public class PoolPanel extends Composite {
	
	final VerticalPanel poolPanel = new VerticalPanel();

	public PoolPanel(ManagerServiceAsync managerService) {
		
		poolPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);	
		
		managerService.getAvailableWorkspaces(new AsyncCallback<Map<String, PuzzleSelectInfo>>(){

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.toString());
				
			}

			@Override
			public void onSuccess(Map<String, PuzzleSelectInfo> result) {
				Iterator<String> it = result.keySet().iterator();
				poolPanel.add(new HTML("Workspaces available"));
				while(it.hasNext())  {
					String key= it.next();  
					poolPanel.add(new HTML("ID : "+ key + " PuzzleInfo  :  "+result.get(key)));
				}
			}
			
		});
		
		initWidget(poolPanel);
	}

}
