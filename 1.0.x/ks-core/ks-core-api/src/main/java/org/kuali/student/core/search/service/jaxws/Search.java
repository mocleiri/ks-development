
package org.kuali.student.core.search.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Fri Feb 26 11:02:00 EST 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "search", namespace = "http://student.kuali.org/wsdl/organization")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "search", namespace = "http://student.kuali.org/wsdl/organization")

public class Search {

    @XmlElement(name = "arg0")
    private org.kuali.student.core.search.dto.SearchRequest arg0;

    public org.kuali.student.core.search.dto.SearchRequest getArg0() {
        return this.arg0;
    }

    public void setArg0(org.kuali.student.core.search.dto.SearchRequest newArg0)  {
        this.arg0 = newArg0;
    }

}

