package org.kuali.student.common.ui.client.widgets;

import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;

public class KSInfoPopupPanel extends KSPopupPanel{
		
	public KSInfoPopupPanel(){
		super();
		super.setModal(false);
		
		Window.addResizeHandler(new ResizeHandler(){
			public void onResize(ResizeEvent event) {
				if(isShowing()){
					show();
				}
			}
		});
		setupDefaultStyle();
	}
	
	private void setupDefaultStyle(){
		super.addStyleName(KSStyles.KS_INFO_POPUP);
	}
	
	public void show(){
		super.center();
	}
	

	
}
