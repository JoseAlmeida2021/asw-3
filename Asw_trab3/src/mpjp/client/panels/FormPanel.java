package mpjp.client.panels;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IndexedPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import mpjp.client.ManagerService;
import mpjp.client.ManagerServiceAsync;
import mpjp.shared.MPJPException;
import mpjp.shared.PuzzleInfo;
import mpjp.shared.PuzzleView;

public class FormPanel extends Composite {

	final VerticalPanel formPanel = new VerticalPanel();
	
	
	
	public FormPanel(final ManagerServiceAsync managerService) {
		
		formPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);		
	
		formPanel.add(new HTML("Puzzle Columns"));
		ListBox lb = new ListBox();
		lb.addItem("1");
		lb.addItem("2");
		lb.addItem("3");
		lb.addItem("4");
		formPanel.add(lb);
		formPanel.add(new HTML("Puzzle Rows"));
		ListBox lb1 = new ListBox();
		lb1.addItem("1");
		lb1.addItem("2");
		lb1.addItem("3");
		lb1.addItem("4");
		formPanel.add(lb1);
		
		formPanel.add(new HTML("Puzzle Width"));
		formPanel.add(new TextBox());
		
		formPanel.add(new HTML("Puzzle Heigth"));
		formPanel.add(new TextBox());
		
		HorizontalPanel panel = new HorizontalPanel();
		
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
		
		button1.addClickHandler(imageClick(managerService,formPanel));
		button2.addClickHandler(imageClick(managerService, formPanel));
		button3.addClickHandler(imageClick(managerService, formPanel));
		
		formPanel.add(panel);
		formPanel.add(new HTML("Cutting"));
		ListBox lb2 = new ListBox();
		lb2.addItem("Straight");
		formPanel.add(lb2);
		Button createB = new Button("Create");
		formPanel.add(createB);
		initWidget(formPanel);
		
		createB.addClickHandler(createClick(managerService,formPanel));

	}



	private ClickHandler createClick(ManagerServiceAsync managerService, VerticalPanel panel) {
		ClickHandler handler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				int nrCol = Integer.valueOf(((ListBox) panel.getWidget(1)).getSelectedValue());
				int nrRow = Integer.valueOf(((ListBox) panel.getWidget(3)).getSelectedValue());
				
				String PWidth = ((TextBox) panel.getWidget(5)).getSelectedText();
				double PW = 0;
				String PHeigth = ((TextBox) panel.getWidget(7)).getSelectedText();
				double PH = 0;
				if(PWidth.length()!=0)
					PW = Double.valueOf(PWidth);
				if(PHeigth.length()!=0)
					PH = Double.valueOf(PHeigth);
				
				int nrImage = ((HorizontalPanel) panel.getWidget(8)).getWidgetCount();
				String name = "";
				for(int i = 0; i< nrImage;i++) {
					if(((Button) ((HorizontalPanel) panel.getWidget(8)).getWidget(i)).isEnabled()) {
						name = ((Button) ((HorizontalPanel) panel.getWidget(8)).getWidget(i)).getTitle();
					}
				}
				String cutting = ((ListBox) panel.getWidget(10)).getSelectedValue();
				try {
					initGame(nrCol,nrRow,PW,PH,name,cutting,managerService);
				} catch (MPJPException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			private void initGame(int nrCol, int nrRow, double pW, double pH, String name, String cutting, ManagerServiceAsync managerService) throws MPJPException {
				PuzzleInfo pInfo = new PuzzleInfo(name,cutting,nrCol,nrRow, pW, pH);
				managerService.createWorkspace(pInfo, new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.toString());
						
					}

					@Override
					public void onSuccess(String result) {	
						String workspaceID = result;
						
					}
					
				});

				
			}
		};
		return handler;
	}



	private ClickHandler imageClick(ManagerServiceAsync managerService, VerticalPanel panel) {
		ClickHandler handler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String name = ((Button)event.getSource()).getTitle();
				for(int i = 0; i<3;i++) {
					String n = ((HorizontalPanel) formPanel.getWidget(8)).getWidget(i).getTitle();
					if(n != name)
						((Button) ((HorizontalPanel) formPanel.getWidget(8)).getWidget(i)).setEnabled(false);	
				}
			}
			
		};
		return handler;
	}

}
