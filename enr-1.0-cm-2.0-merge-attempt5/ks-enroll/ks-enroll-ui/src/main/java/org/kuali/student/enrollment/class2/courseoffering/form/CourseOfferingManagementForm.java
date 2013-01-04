package org.kuali.student.enrollment.class2.courseoffering.form;

import org.apache.commons.lang.StringUtils;
import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.student.r2.core.acal.dto.TermInfo;
import org.kuali.student.enrollment.class2.courseoffering.dto.ActivityOfferingWrapper;
import org.kuali.student.enrollment.class2.courseoffering.dto.CourseOfferingCopyWrapper;
import org.kuali.student.enrollment.class2.courseoffering.dto.CourseOfferingEditWrapper;
import org.kuali.student.enrollment.class2.courseoffering.dto.CourseOfferingListSectionWrapper;
import org.kuali.student.enrollment.courseoffering.dto.CourseOfferingInfo;

import java.util.ArrayList;
import java.util.List;

public class CourseOfferingManagementForm extends UifFormBase {
    //for authorization purpose
    private String adminOrg;

    private String termCode;
    private TermInfo termInfo;
    private String courseOfferingCode;
    private String subjectCode;
    private String subjectCodeDescription;
    private String radioSelection;
    private String inputCode;
    private String selectedOfferingAction;
    private CourseOfferingInfo theCourseOffering;
    private String coViewLinkWrapper = "View"; // temp var to hold/store the View Details Link
    private CourseOfferingEditWrapper courseOfferingEditWrapper = null;

    private List<ActivityOfferingWrapper> activityWrapperList;
    private List<ActivityOfferingWrapper> selectedToDeleteList;
    private CourseOfferingCopyWrapper courseOfferingCopyWrapper;


    /**
     * The courseOfferingResultList once created is unmodifiable. This had to be done because various
     * methods were illegally modifying the list throughout the app and it took me forever to track down.
     * Since the screen needs the list to be not null and the list.clear() method cannot be called we
     * have created an empty version of the list. There is a helper method to "clear"  courseOfferingResultList
     * which really just sets the "empty" list in it's place.
     */
    private List<CourseOfferingListSectionWrapper> courseOfferingResultList;
    private List<CourseOfferingListSectionWrapper> courseOfferingResultListEmpty;  // look at definition above.

    //For Adding Activity
    private String formatIdForNewAO;
    private String activityIdForNewAO;
    private String noOfActivityOfferings;

    private CourseOfferingInfo previousCourseOffering;
    private CourseOfferingInfo nextCourseOffering;
    private String previousCourseOfferingCodeUI;
    private String nextCourseOfferingCodeUI;

    private String toBeScheduledCourseOfferingsUI;
    private int toBeScheduledCourseOfferingsCount;
    private boolean selectedIllegalAOInDeletion = false;

    private boolean withinPortal = true;

    private boolean editAuthz;


    public CourseOfferingManagementForm (){
        activityWrapperList = new ArrayList<ActivityOfferingWrapper>();
        selectedToDeleteList = new ArrayList<ActivityOfferingWrapper>();
        courseOfferingResultList = new ArrayList<CourseOfferingListSectionWrapper>();
        courseOfferingResultListEmpty = new ArrayList<CourseOfferingListSectionWrapper>();
        setCourseOfferingCopyWrapper(null);
    }

    public String getTermCode(){
        return termCode;
    }

    public void setTermCode(String termCode){
        this.termCode = termCode;
    }

    public TermInfo getTermInfo(){
        return termInfo;    
    }
    
    public void setTermInfo(TermInfo termInfo){
        this.termInfo = termInfo;
    }
    
    public String getCourseOfferingCode(){
        return courseOfferingCode;
    }

    public void setCourseOfferingCode(String courseOfferingCode){
        this.courseOfferingCode = courseOfferingCode;
    }
    
    public String getSubjectCode(){
        return subjectCode;
    }
    
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
    
    public String getRadioSelection(){
        return radioSelection;
    } 
    
    public void setRadioSelection(String radioSelection){
        this.radioSelection = radioSelection;
    }
    
    public String getInputCode(){
        return inputCode;
    }
    
    public void setInputCode(String inputCode){
        this.inputCode = inputCode;
    }

    public String getSelectedOfferingAction() {
        return selectedOfferingAction;
    }

    public void setSelectedOfferingAction(String selectedOfferingAction) {
        this.selectedOfferingAction = selectedOfferingAction;
    }

    public CourseOfferingInfo getTheCourseOffering(){
        return theCourseOffering;
    }

    public void setTheCourseOffering(CourseOfferingInfo theCourseOffering)  {
        this.theCourseOffering = theCourseOffering;
    }

    public String getNoOfActivityOfferings() {
        return noOfActivityOfferings;
    }

    public void setNoOfActivityOfferings(String noOfActivityOfferings) {
        this.noOfActivityOfferings = noOfActivityOfferings;
    }

    public List<ActivityOfferingWrapper> getActivityWrapperList() {
        return activityWrapperList;
    }

    public void setActivityWrapperList(List<ActivityOfferingWrapper> activityWrapperList) {
        this.activityWrapperList = activityWrapperList;
    }

    public List<ActivityOfferingWrapper> getSelectedToDeleteList() {
        return selectedToDeleteList;
    }

    public void setSelectedToDeleteList(List<ActivityOfferingWrapper> selectedToDeleteList) {
        this.selectedToDeleteList = selectedToDeleteList;
    }

    public String getFormatIdForNewAO() {
        return formatIdForNewAO;
    }

    public void setFormatIdForNewAO(String formatIdForNewAO) {
        this.formatIdForNewAO = formatIdForNewAO;
    }

    public String getActivityIdForNewAO() {
        return activityIdForNewAO;
    }

    public void setActivityIdForNewAO(String activityIdForNewAO) {
        this.activityIdForNewAO = activityIdForNewAO;
    }

    public String getCoViewLinkWrapper() {
        return coViewLinkWrapper;
    }

    public void setCoViewLinkWrapper(String coViewLinkWrapper) {
        this.coViewLinkWrapper = coViewLinkWrapper;
    }

    public CourseOfferingCopyWrapper getCourseOfferingCopyWrapper() {
        return courseOfferingCopyWrapper;
    }

    public void setCourseOfferingCopyWrapper(CourseOfferingCopyWrapper courseOfferingCopyWrapper) {
        this.courseOfferingCopyWrapper = courseOfferingCopyWrapper;
    }

    public String getPreviousCourseOfferingCodeUI() {
        return previousCourseOfferingCodeUI;
    }

    public void setPreviousCourseOfferingCodeUI(String previousCourseOfferingCodeUI) {
        this.previousCourseOfferingCodeUI = previousCourseOfferingCodeUI;
    }

    public String getNextCourseOfferingCodeUI() {
        return nextCourseOfferingCodeUI;
    }

    public void setNextCourseOfferingCodeUI(String nextCourseOfferingCodeUI) {
        this.nextCourseOfferingCodeUI = nextCourseOfferingCodeUI;
    }

    public CourseOfferingInfo getPreviousCourseOffering() {
        return previousCourseOffering;
    }

    public void setPreviousCourseOffering(CourseOfferingInfo previousCourseOffering) {
        this.previousCourseOffering = previousCourseOffering;
        if (previousCourseOffering != null){
            setPreviousCourseOfferingCodeUI(previousCourseOffering.getCourseOfferingCode());
        }else{
            setPreviousCourseOfferingCodeUI(StringUtils.EMPTY);
        }
    }

    public CourseOfferingInfo getNextCourseOffering() {
        return nextCourseOffering;
    }

    public String getSubjectCodeDescription() {
        return subjectCodeDescription;
    }

    public void setSubjectCodeDescription(String subjectCodeDescription) {
        this.subjectCodeDescription = subjectCodeDescription;
    }

    public void setNextCourseOffering(CourseOfferingInfo nextCourseOffering) {
        this.nextCourseOffering = nextCourseOffering;
        if (nextCourseOffering != null){
            setNextCourseOfferingCodeUI(nextCourseOffering.getCourseOfferingCode());
        }else{
            setNextCourseOfferingCodeUI(StringUtils.EMPTY);
        }
    }

    public String getToBeScheduledCourseOfferingsUI() {
        return toBeScheduledCourseOfferingsUI;
    }

    public void setToBeScheduledCourseOfferingsUI(String toBeScheduledCourseOfferingsUI) {
        this.toBeScheduledCourseOfferingsUI = toBeScheduledCourseOfferingsUI;
    }

    public int getToBeScheduledCourseOfferingsCount() {
        return toBeScheduledCourseOfferingsCount;
    }

    public void setToBeScheduledCourseOfferingsCount(int toBeScheduledCourseOfferingsCount) {
        this.toBeScheduledCourseOfferingsCount = toBeScheduledCourseOfferingsCount;
    }

    public boolean isSelectedIllegalAOInDeletion() {
        return selectedIllegalAOInDeletion;
    }

    public void setSelectedIllegalAOInDeletion(boolean selectedIllegalAOInDeletion) {
        this.selectedIllegalAOInDeletion = selectedIllegalAOInDeletion;
    }

    public boolean isWithinPortal() {
        return withinPortal;
    }

    public void setWithinPortal(boolean withinPortal) {
        this.withinPortal = withinPortal;
    }

    public String getAdminOrg() {
        return adminOrg;
    }

    public void setAdminOrg(String adminOrg) {
        this.adminOrg = adminOrg;
    }
    
    public List<CourseOfferingListSectionWrapper> getCourseOfferingResultList() {
        return courseOfferingResultList;
    }
    public void setCourseOfferingResultList(List<CourseOfferingListSectionWrapper> courseOfferingResultList) {
        this.courseOfferingResultList = courseOfferingResultList;
    }
    public void clearCourseOfferingResultList(){
        this.courseOfferingResultList = courseOfferingResultListEmpty;
    }

    public CourseOfferingEditWrapper getCourseOfferingEditWrapper() {
        return courseOfferingEditWrapper;
    }

    public void setCourseOfferingEditWrapper(CourseOfferingEditWrapper courseOfferingEditWrapper) {
        this.courseOfferingEditWrapper = courseOfferingEditWrapper;
    }
    public boolean getEditAuthz(){
        return editAuthz;
    }
    public void setEditAuthz(boolean editAuthz){
        this.editAuthz=editAuthz;
    }
}
