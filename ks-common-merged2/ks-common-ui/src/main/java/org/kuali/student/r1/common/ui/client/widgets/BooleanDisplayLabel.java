package org.kuali.student.r1.common.ui.client.widgets;

import org.kuali.student.r1.common.ui.client.application.Application;

public class BooleanDisplayLabel extends KSLabel{
	@Override
	public void setText(String text) {
		if(text.equalsIgnoreCase("true")){
			text = Application.getApplicationContext().getMessage("booleanTrue");
		}
		else{
			text = Application.getApplicationContext().getMessage("booleanFalse");
		}
		super.setText(text);
	}
}
