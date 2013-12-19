/**
 * Copyright 2005-2013 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 1.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.kuali.student.cm.course.form;

import java.util.LinkedList;
import java.util.List;

/**
 * Marker interface for having arbitrary course data in a collection displayed in stacks.
 *
 * @author OpenCollab/rSmart KRAD CM Conversion Alliance!
 */
public class ReviewInfo implements java.io.Serializable {

    private CourseInfoWrapper courseInfo;
    private GovernanceInfoWrapper governanceInfo;
    private CourseLogisticsInfoWrapper courseLogisticsInfo;
    private LearningObjectivesInfoWrapper learningObjectivesInfo;
    private ActiveDatesInfoWrapper activeDatesInfo;
    private AuthorsAndCollaboratorsInfoWrapper authorsAndCollaboratorsInfo;
    private SupportingDocumentsInfoWrapper supportingDocumentsInfo;

    public CourseInfoWrapper getCourseInfo() {
        if (this.courseInfo == null) {
            courseInfo = new CourseInfoWrapper();
        }
        return courseInfo;
    }

    public GovernanceInfoWrapper getGovernanceInfo() {
        if (this.governanceInfo == null) {
            governanceInfo = new GovernanceInfoWrapper();
        }
        return governanceInfo;
    }

    public CourseLogisticsInfoWrapper getCourseLogisticsInfo() {
        if (this.courseLogisticsInfo == null) {
            courseLogisticsInfo = new CourseLogisticsInfoWrapper();
        }
        return courseLogisticsInfo;
    }


    public LearningObjectivesInfoWrapper getLearningObjectivesInfo() {
        if (this.learningObjectivesInfo == null) {
            learningObjectivesInfo = new LearningObjectivesInfoWrapper();
        }
        return learningObjectivesInfo;
    }

    public ActiveDatesInfoWrapper getActiveDatesInfo() {
        if (this.activeDatesInfo == null) {
            activeDatesInfo = new ActiveDatesInfoWrapper();
        }
        return activeDatesInfo;
    
    }

    public AuthorsAndCollaboratorsInfoWrapper getAuthorsAndCollaboratorsInfo() {
        if (this.authorsAndCollaboratorsInfo == null) {
            authorsAndCollaboratorsInfo = new AuthorsAndCollaboratorsInfoWrapper();
        }
        return authorsAndCollaboratorsInfo;
    
    }

    public SupportingDocumentsInfoWrapper getSupportingDocumentsInfo() {
        if (this.supportingDocumentsInfo == null) {
            supportingDocumentsInfo = new SupportingDocumentsInfoWrapper();
        }
        return supportingDocumentsInfo;
    
    }

    public class CourseInfoWrapper implements java.io.Serializable {
        private String proposalName;
        private String courseTitle;
        private String transcriptTitle;
        private String subjectArea;
        private String courseNumberSuffix;
        private List<String> instructors;

        private String description;
        private String rationale;
        private List<String> crossListings;
        private List<String> variations;

        public String getProposalName() {
            if (this.proposalName == null) {
                proposalName = new String();
            }
            return proposalName;
        }

        public String getCourseTitle() {
            if (this.courseTitle == null) {
                courseTitle = new String();
            }
            return courseTitle;
        }

        public String getTranscriptTitle() {
            if (this.transcriptTitle == null) {
                transcriptTitle = new String();
            }
            return transcriptTitle;
        }

        public String getSubjectArea() {
            if (this.subjectArea == null) {
                subjectArea = new String();
            }
            return subjectArea;
        }

        public String getCourseNumberSuffix() {
            if (this.courseNumberSuffix == null) {
                courseNumberSuffix = new String();
            }
            return courseNumberSuffix;
        }

        public List<String> getInstructors() {
            if (this.instructors == null) {
                instructors = new LinkedList<String>();
            }
            return instructors;
        }

        public List<String> getCrossListings() {
            if (this.crossListings == null) {
                crossListings = new LinkedList<String>();
            }
            return crossListings;
        }

        public List<String> getVariations() {
            if (this.variations == null) {
                variations = new LinkedList<String>();
            }
            return variations;
        }

        public String getDescription() {
            if (this.description == null) {
                description = new String();
            }
            return description;
        }

        public String getRationale() {
            if (this.rationale == null) {
                rationale = new String();
            }
            return rationale;
        }
    }

    public class GovernanceInfoWrapper implements java.io.Serializable {
        
    }

    public class CourseLogisticsInfoWrapper implements java.io.Serializable {
    }

    public class LearningObjectivesInfoWrapper implements java.io.Serializable {
    }

    public class ActiveDatesInfoWrapper implements java.io.Serializable {
        
    }

    public class AuthorsAndCollaboratorsInfoWrapper implements java.io.Serializable {
        
    }

    public class SupportingDocumentsInfoWrapper implements java.io.Serializable {
        
    }
}
