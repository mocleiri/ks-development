/**
 * Copyright 2010 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.kuali.student.r1.common.ui.client.widgets.list;

import java.util.List;

import org.kuali.student.r1.common.ui.client.mvc.Callback;
import org.kuali.student.r1.common.ui.client.widgets.list.impl.KSCheckBoxListImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.HasBlurHandlers;
import com.google.gwt.event.dom.client.HasFocusHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;


/**
 * This is a description of what this class does - Will Gomes don't forget to fill this in. 
 * 
 * @author Kuali Student Team 
 *
 */
public class KSCheckBoxList extends KSSelectItemWidgetAbstract implements HasBlurHandlers, HasFocusHandlers {
    private KSCheckBoxListImpl selectItemWidget = GWT.create(KSCheckBoxListImpl.class);

    
	public KSCheckBoxList(String name) {
        initWidget(selectItemWidget);
        selectItemWidget.setName(name);
	}
	
    public KSCheckBoxList() {
        initWidget(selectItemWidget);
    }

	/**
	 * @see org.kuali.student.r1.common.ui.client.widgets.list.KSSelectItemWidgetAbstract#deSelectItem(java.lang.String)
	 */
	public void deSelectItem(String id) {
	    selectItemWidget.deSelectItem(id);	
	}

	/**
	 * @see org.kuali.student.r1.common.ui.client.widgets.list.KSSelectItemWidgetAbstract#getSelectedItems()
	 */
	public List<String> getSelectedItems() {
	    return selectItemWidget.getSelectedItems();
	}

	/**
	 * @see org.kuali.student.r1.common.ui.client.widgets.list.KSSelectItemWidgetAbstract#selectItem(java.lang.String)
	 */
	public void selectItem(String id) {
	    selectItemWidget.selectItem(id);
	}

    public void setListItems(ListItems listItems) {
        selectItemWidget.setListItems(listItems);      
    }

    /**
     * Use to set number of columns to use when displaying list
     * 
     */
    public void setColumnSize(int cols){
        selectItemWidget.setColumnSize(cols);
    }
        
    public void setMultipleSelect(boolean isMultipleSelect) {}

    /**
     * This overridden method is not used
     * 
     * @see org.kuali.student.r1.common.ui.client.widgets.list.KSSelectItemWidgetAbstract#onLoad()
     */
    @Override
    public void onLoad() {}
   
    public HandlerRegistration addSelectionChangeHandler(SelectionChangeHandler handler) {
        return selectItemWidget.addSelectionChangeHandler(handler);
    }

    public ListItems getListItems() {
        return selectItemWidget.getListItems();
    }

    public String getName() {
        return selectItemWidget.getName();
    }

    public void setName(String name) {
        selectItemWidget.setName(name);
    }

    @Override
    public void setEnabled(boolean b) {
        selectItemWidget.setEnabled(b);
    }

    @Override
    public boolean isEnabled() {
        return selectItemWidget.isEnabled();
    }

    @Override
    public boolean isMultipleSelect() {
        return selectItemWidget.isMultipleSelect();
    }

    @Override
    public void redraw() {
        selectItemWidget.redraw();
    }

    @Override
    public void clear() {
        selectItemWidget.clear();
    }

	@Override
	public HandlerRegistration addBlurHandler(BlurHandler handler) {
		return selectItemWidget.addBlurHandler(handler);
	}

	@Override
	public HandlerRegistration addFocusHandler(FocusHandler handler) {
		return selectItemWidget.addFocusHandler(handler);
	}

    public void addWidgetReadyCallback(Callback<Widget> callback) {
        selectItemWidget.addWidgetReadyCallback(callback);
    }

    public boolean isInitialized() {
        return selectItemWidget.isInitialized();
    }

    public void setInitialized(boolean initialized) {
        selectItemWidget.setInitialized(initialized);
    }
    
    /**
     * By default if the list items used by the checkbox has multiple attributes, the checkbox
     * generated will display all attributes as columns. Set this property to true if this
     * behavior is not desired.
     * 
     * @param ignoreMultiple
     */
    public void setIgnoreMultipleAttributes(boolean ignoreMultiple){
    	selectItemWidget.setIgnoreMultipleAttributes(ignoreMultiple);
    }
}


