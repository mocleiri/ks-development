
package org.kuali.student.lum.course.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2.9
 * Thu Nov 04 11:39:27 EDT 2010
 * Generated source version: 2.2.9
 */

@XmlRootElement(name = "createCourseStatement", namespace = "http://student.kuali.org/wsdl/course")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createCourseStatement", namespace = "http://student.kuali.org/wsdl/course", propOrder = {"courseId", "statementTreeViewInfo"})

public class CreateCourseStatement {

    @XmlElement(name = "courseId")
    private java.lang.String courseId;
    @XmlElement(name = "statementTreeViewInfo")
    private org.kuali.student.core.statement.dto.StatementTreeViewInfo statementTreeViewInfo;

    public java.lang.String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(java.lang.String newCourseId)  {
        this.courseId = newCourseId;
    }

    public org.kuali.student.core.statement.dto.StatementTreeViewInfo getStatementTreeViewInfo() {
        return this.statementTreeViewInfo;
    }

    public void setStatementTreeViewInfo(org.kuali.student.core.statement.dto.StatementTreeViewInfo newStatementTreeViewInfo)  {
        this.statementTreeViewInfo = newStatementTreeViewInfo;
    }

}

