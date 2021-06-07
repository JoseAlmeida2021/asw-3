package mpjp.client.panels;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;

import mpjp.client.ManagerServiceAsync;

public class AvailablePanel extends Composite {
	
	HorizontalPanel panel = new HorizontalPanel();
	
	
	public AvailablePanel(ManagerServiceAsync managerService) {
		
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		Image img1 = new Image("/img/exterior2.jpg");
		Button button1 = new Button();
		img1.setWidth("100%");
		button1.setTitle("exterior2.jpg");
		button1.getElement().appendChild(img1.getElement());
		panel.add(button1);
		
		Image img2 = new Image("/img/exterior3.jpg");
		img2.setWidth("100%");
		Button button2 = new Button();
		button2.setTitle("exterior3.jpg");
		button2.getElement().appendChild(img2.getElement());
		panel.add(button2);
		
		Image img3 = new Image("/img/exterior7.jpg");
		img3.setWidth("100%");
		Button button3 = new Button();
		button3.setTitle("exterior7.jpg");
		button3.getElement().appendChild(img3.getElement());
		panel.add(button3);
		
		button1.addClickHandler(imageClick(managerService));
		button2.addClickHandler(imageClick(managerService));
		button3.addClickHandler(imageClick(managerService));
		
		initWidget(panel);
	}


	private ClickHandler imageClick(ManagerServiceAsync managerService) {
		ClickHandler handler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				((TabLayoutPanel) RootLayoutPanel.get().getWidget(0)).selectTab(0);
			}
			
		};
		return handler;
	}
}
