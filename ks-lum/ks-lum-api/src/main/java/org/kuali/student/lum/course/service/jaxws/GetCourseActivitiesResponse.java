
package org.kuali.student.lum.course.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.kuali.student.lum.course.dto.ActivityInfo;

/**
 * This class was generated by Apache CXF 2.2
 * Tue May 18 13:33:13 PDT 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "getCourseActivitiesResponse", namespace = "http://student.kuali.org/wsdl/course")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCourseActivitiesResponse", namespace = "http://student.kuali.org/wsdl/course")

public class GetCourseActivitiesResponse {

    @XmlElement(name = "return")
    private java.util.List<ActivityInfo> _return;

    public java.util.List<ActivityInfo> getReturn() {
        return this._return;
    }

    public void setReturn(java.util.List<ActivityInfo> new_return)  {
        this._return = new_return;
    }

}

