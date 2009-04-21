package org.kuali.student.lum.ui.requirements.client.view;

import org.kuali.student.common.ui.client.mvc.Controller;
import org.kuali.student.common.ui.client.mvc.Model;
import org.kuali.student.common.ui.client.mvc.ModelChangeEvent;
import org.kuali.student.common.ui.client.mvc.ModelChangeHandler;
import org.kuali.student.common.ui.client.mvc.ModelRequestCallback;
import org.kuali.student.common.ui.client.mvc.ViewComposite;
import org.kuali.student.common.ui.client.widgets.KSButton;
import org.kuali.student.common.ui.client.widgets.KSLabel;
import org.kuali.student.lum.lu.ui.main.client.controller.LUMApplicationManager.LUMViews;
import org.kuali.student.lum.lu.ui.main.client.events.ChangeViewStateEvent;
import org.kuali.student.lum.ui.requirements.client.controller.CoreqManager;
import org.kuali.student.lum.ui.requirements.client.controller.PrereqManager;
import org.kuali.student.lum.ui.requirements.client.controller.PrereqManager.PrereqViews;
import org.kuali.student.lum.ui.requirements.client.model.CourseRuleInfo;
import org.kuali.student.lum.ui.requirements.client.model.PrereqInfo;
import org.kuali.student.lum.ui.requirements.client.model.StatementVO;
import org.kuali.student.lum.ui.requirements.client.service.RequirementsService;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class CourseRequisiteView extends ViewComposite {

    private final SimplePanel mainPanel = new SimplePanel();
    private final SimplePanel viewPanel = new SimplePanel();
    private KSButton AddPrerequisiteRule = new KSButton("Add Pre-Requisite Rule");
    private KSButton EditPrerequisiteRule = new KSButton("Edit Pre-Requisite Rule");  
    private KSButton AddCoreqRule = new KSButton("Add Co-Requisite Rule");
    private KSButton EditCoreqRule = new KSButton("Edit Co-Requisite Rule"); 
    
    private String selectedCourseId = null;
    private Model<CourseRuleInfo> courseData;    
    private final Model<PrereqInfo> model = new Model<PrereqInfo>();
    private final PrereqManager prereqManager = new PrereqManager(model);
    private final CoreqManager coreqManager = new CoreqManager();
    private ButtonEventHandler handler = new ButtonEventHandler();    
    
    public CourseRequisiteView(Controller controller, String courseId) {
        super(controller, "Course Requisites");
        super.initWidget(mainPanel);
        this.selectedCourseId = courseId;
        mainPanel.add(viewPanel);        
        
        //set prereq for this course    
        courseData = new Model<CourseRuleInfo>();
        
        //TODO move elsewhere
        RequirementsService.Util.getInstance().getCourseInfo(courseId, new AsyncCallback<CourseRuleInfo>() {
            
            PrereqInfo prereqInfo = new PrereqInfo();
            
            public void onFailure(Throwable caught) {
                // just re-throw it and let the uncaught exception handler deal with it
                Window.alert(caught.getMessage());
                // throw new RuntimeException("Unable to load BusinessRuleInfo objects", caught);
            }

            public void onSuccess(final CourseRuleInfo courseRuleInfo) {                
                courseData.add(courseRuleInfo);
                prereqInfo.setId(courseData.get(getCourseId()).getId());
                prereqInfo.setNaturalLanguage("This is natural language for this statement");
                prereqInfo.setRationale("The course supplements Biology 100 level courses.");
               // prereqInfo.setStatementVO(new StatementVO(courseData.get(getCourseId()).getLuStatementByType("kuali.luStatementType.prereqAcademicReadiness")));
                
                RequirementsService.Util.getInstance().getStatementVO("CLU-NL-1", "kuali.luStatementType.prereqAcademicReadiness", new AsyncCallback<StatementVO>() {
                    public void onFailure(Throwable caught) {
                        Window.alert(caught.getMessage());
                        caught.printStackTrace();
                    }
                    
                    public void onSuccess(final StatementVO statementVO) {
                        setPrereqInfo(prereqInfo);                    
                        layoutMainPanel(viewPanel);
                    } 
                });                

            }
        });                      
    }
    
    public void initializeView() {
        mainPanel.clear();
        mainPanel.add(viewPanel);
    }    
    
    private class ButtonEventHandler implements ClickHandler{

        @Override
        public void onClick(ClickEvent event) {
            Widget sender = (Widget) event.getSource();
            
            if(sender == AddPrerequisiteRule){
                //CreateCreditCoursePanel.this.getController().fireApplicationEvent(new ChangeViewStateEvent<LUMViews>(LUMViews.CREATE_COURSE));
            } else if (sender == EditPrerequisiteRule) {
                mainPanel.clear();
                mainPanel.add(prereqManager.getMainPanel());
                prereqManager.showDefaultView();
            }
        }       
    }    
    
    public void setPrereqInfo(PrereqInfo prereqInfo) {
        if (model.getValues() != null && !model.getValues().isEmpty()) {
            for (PrereqInfo oldPrereqInfo : model.getValues()) {
                model.remove(oldPrereqInfo);
            }
        }
        model.add(prereqInfo);
    }
    
    private void layoutMainPanel(Panel parentPanel) {
        VerticalPanel verticalPanel = new VerticalPanel();
        KSLabel preReqHeading = new KSLabel("Pre-requisite Rule");
        preReqHeading.setStyleName("KS-ReqMgr-Heading");
        verticalPanel.add(preReqHeading);
        if ((selectedCourseId == null) || (selectedCourseId.isEmpty())) {
            KSLabel preReqText = new KSLabel("No pre-requisite rule has been defined. To add one, click Add Pre-Requisite Rule.");
            preReqText.setStyleName("KS-ReqMgr-NoRuleText");
            verticalPanel.add(preReqText);
            verticalPanel.add(AddPrerequisiteRule);
            AddPrerequisiteRule.setStyleName("KS-Rules-Standard-Button");
            AddPrerequisiteRule.addClickHandler(handler);
        } else {
            verticalPanel.add(getNaturalLanguage());
            verticalPanel.add(EditPrerequisiteRule);
            EditPrerequisiteRule.setStyleName("KS-Rules-Standard-Button");            
            EditPrerequisiteRule.addClickHandler(handler);
        }
        verticalPanel.add(new RowBreak());

        KSLabel coReqHeading = new KSLabel("Co-requisite Rule");
        coReqHeading.setStyleName("KS-ReqMgr-Heading");
        verticalPanel.add(coReqHeading);        
        //if ((this.courseId == null) || (this.courseId.isEmpty())) {
            KSLabel coReqText = new KSLabel("No co-requisite rule has been defined. To add one, click Add Co-Requisite Rule.");
            coReqText.setStyleName("KS-ReqMgr-NoRuleText");
            verticalPanel.add(coReqText);
            verticalPanel.add(AddCoreqRule);
            AddCoreqRule.setStyleName("KS-Rules-Standard-Button");             
            AddCoreqRule.addClickHandler(handler);
        //} else {
            //todo show the rule
        //    verticalPanel.add(EditCoreqRule);
        //    EditCoreqRule.setStyleName("KS-Rules-Standard-Button");             
        //    EditCoreqRule.addClickHandler(handler);
        //}                
        verticalPanel.add(coreqManager);
        parentPanel.add(verticalPanel);
        parentPanel.setStyleName("Content-Margin");
    }
    
    private Widget getNaturalLanguage() {
        PrereqInfo reqInfo = model.get(selectedCourseId);
        return new KSLabel(reqInfo.getNaturalLanguage());
    }
    
    public void setCourseId(String courseId) {
        this.selectedCourseId = courseId;        
    }
    
    public String getCourseId() {
        return selectedCourseId;        
    }
    
    private class RowBreak extends Composite{
        private HorizontalPanel row = new HorizontalPanel();
        private HTML hr = new HTML("<HR />");
        public RowBreak(){
            row.addStyleName("Home-Horizontal-Break");
            row.add(hr);
            this.initWidget(row);
        }
    }    
}
