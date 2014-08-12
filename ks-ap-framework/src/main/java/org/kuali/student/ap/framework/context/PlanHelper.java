package org.kuali.student.ap.framework.context;

import org.kuali.student.ap.academicplan.constants.AcademicPlanServiceConstants.ItemCategory;
import org.kuali.student.ap.academicplan.dto.LearningPlanInfo;
import org.kuali.student.ap.academicplan.dto.PlanItemInfo;
import org.kuali.student.ap.academicplan.infc.Placeholder;
import org.kuali.student.ap.academicplan.infc.PlaceholderInstance;
import org.kuali.student.ap.academicplan.infc.PlanItem;
import org.kuali.student.ap.academicplan.infc.TypedObjectReference;
import org.kuali.student.ap.academicplan.service.AcademicPlanService;
import org.kuali.student.enrollment.academicrecord.dto.StudentCourseRecordInfo;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.core.acal.infc.Term;
import org.kuali.student.r2.lum.course.infc.Course;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Helper that handles configurable actions for accessing learning plans and Plan items.
 */
public interface PlanHelper {

    /**
     * Retrieves the default learning plan.
     *
     * @return Default Learning Plan
     */
    public LearningPlanInfo getDefaultLearningPlan();

    /**
     * Update the default learning plan for the current session.
     *
     * @param learningPlanId learning plan ID
     */
    public void setDefaultLearningPlan(String learningPlanId);

    /**
     * Retrieves a learning plan for the current student by ID.
     *
     * @param learningPlanId plan ID
     * @return Learning Plan
     */
    public LearningPlanInfo getLearningPlan(String learningPlanId);

    /**
     * Gets the plan items in a learning plan.
     *
     * @param planId The learning plan ID.
     * @return Default Learning Plan
     */
    public List<PlanItem> getPlanItems(String planId);

    /**
     * Load a plan item from any of the student's learning plans by ID.
     *
     * @param planItemId plan item ID
     * @return a plan item from one of the student's learning plans by ID
     */
    public PlanItem getPlanItem(String planItemId);

    /**
     * Adds a plan item to a learning plan.
     *
     * @param learningPlanId learning plan ID
     * @param category item category
     * @param descr plan item description (course note)
     * @param units number of credits/units
     * @param termIds planned term IDs
     * @param ref course/placeholder reference data
     * @return
     */
    public PlanItem addPlanItem(String learningPlanId, ItemCategory category, String descr, BigDecimal units,
                         List<String> termIds, TypedObjectReference ref);

    /**
     * Updates a plan item in a learning plan.
     *
     * <p>
     * In addition to calling {@link AcademicPlanService#updatePlanItem(String, PlanItemInfo, ContextInfo)}, this
     * method should ensure that session state and cached data are updated accordingly. and/or cleared as needed to
     * reflect the update.
     * </p>
     *
     * @param item plan item
     */
    public PlanItem updatePlanItem(PlanItem item);

    /**
     * Removes a plan item.
     *
     * <p>
     * In addition to calling {@link AcademicPlanService#deletePlanItem(String, ContextInfo)}, this method should
     * ensure that session state and cached data are updated accordingly. and/or cleared as needed to reflect the
     * update.
     * </p>
     *
     * @param planItemId plan item ID
     */
    public void removePlanItem(String planItemId);

    /**
     * Updates a term note for a learning plan.
     *
     * @param learningPlanId
     *            learning plan ID
     * @param termId
     *            term ID
     * @param note
     *            updated term note. May be null to remove the note.
     */
    public void editTermNote(String learningPlanId, String termId, String note);

    /**
     * Gets the completed course records (via AcademicRecordService) for the student by ID.
     *
     * @return completed course records
     */
    public List<StudentCourseRecordInfo> getCompletedRecords();

    /**
     * Gets the id of the term that the planner should display first.
     *
     * @return Term Id
     */
    public String getPlannerFirstTermId();

    /**
     * Determines if two typed object references refer to the same object.
     *
     * @param ref1 typed reference
     * @param ref2 typed reference
     * @return True if ref1 and ref2 both refer to the same typed object.
     */
    public boolean isSame(TypedObjectReference ref1, TypedObjectReference ref2);

    /**
     * Determines if one typed object reference is encompassed by another.
     *
     * @param inner typed reference
     * @param outer typed reference
     * @return True if all courses referred to by inner are also referred to by
     *         outer.
     */
    public boolean isEncompassed(TypedObjectReference inner, TypedObjectReference outer);

    /**
     * Gets the list of Terms to use in the Planner Calendar using a Start Term.
     *
     * @param startTerm - Term that the calendar starts around
     * @return A full List of terms to display in the calendar.
     */
    public List<Term> getPlannerCalendarTerms(Term startTerm);

    /**
     * Retrieve the list of plan items for this course in the student's plan
     *
     * @param courseId - Id of course that is being displayed
     * @return A List of plan items related to the course.
     */
    List<PlanItem> loadStudentsPlanItemsForCourse(String courseId);

    /**
     * Retrieve the list of plan items for this course in the student's plan
     *
     * @param course - Course that is being displayed
     * @return A List of plan items related to the course.
     */
    public List<PlanItem> loadStudentsPlanItemsForCourse(Course course);

    /**
     * Get the course from a TypedOjbectReference
     *
     * @param ref
     * @return course or null if the reference is not for a placeholder.
     */
    public Course getCourse(TypedObjectReference ref);

    /**
     * Get the placeholder from a TypedOjbectReference
     *
     * @param ref
     * @return placeholder or null if the reference is not for a placeholder.
     */
    public Placeholder getPlaceHolder(TypedObjectReference ref);

    /**
     * Get the placeholder instance from a TypedOjbectReference
     *
     * @param ref
     * @return placeholder instance or null if the reference is not for a placeholder instance.
     */

    public PlaceholderInstance getPlaceHolderInstance(TypedObjectReference ref);

    /**
     * Get the course IDs for courses that satisfy a given PlaceHolder
     *
     * @param placeholder the Placeholder to resolve
     * @return a set of one or more course IDs
     */
    public Set<String> getCourseIdsForPlaceHolder(Placeholder placeholder);

    /**
     * Creates a message regarding the Planned status of the course to be displayed on the page
     *
     * @param planItems - The list of plan items related to the course
     * @return - Formatted message if bookmarked, "" if not planned
     */
    public String createPlanningStatusMessages(List<PlanItem> planItems);

    /**
     * Creates a message regarding the Bookmark status of the course to be displayed on the page
     *
     * @param planItems - The list of plan items related to the course
     * @return - Formatted message if bookmarked, "" if not bookmarked
     */
    public String createBookmarkStatusMessages(List<PlanItem> planItems);


}
