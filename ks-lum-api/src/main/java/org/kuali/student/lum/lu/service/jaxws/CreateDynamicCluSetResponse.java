
package org.kuali.student.lum.lu.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.1.4
 * Tue Feb 24 12:25:30 EST 2009
 * Generated source version: 2.1.4
 */

@XmlRootElement(name = "createDynamicCluSetResponse", namespace = "http://student.kuali.org/lum/lu")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createDynamicCluSetResponse", namespace = "http://student.kuali.org/lum/lu")

public class CreateDynamicCluSetResponse {

    @XmlElement(name = "return")
    private org.kuali.student.lum.lu.dto.CluSetInfo _return;

    public org.kuali.student.lum.lu.dto.CluSetInfo getReturn() {
        return this._return;
    }

    public void setReturn(org.kuali.student.lum.lu.dto.CluSetInfo new_return)  {
        this._return = new_return;
    }

}

