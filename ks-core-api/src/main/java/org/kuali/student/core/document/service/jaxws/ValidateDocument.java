
package org.kuali.student.core.document.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Tue Jun 16 14:57:19 EDT 2009
 * Generated source version: 2.2
 */

@XmlRootElement(name = "validateDocument", namespace = "http://student.kuali.org/wsdl/document")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validateDocument", namespace = "http://student.kuali.org/wsdl/document", propOrder = {"validationType","documentInfo"})

public class ValidateDocument {

    @XmlElement(name = "validationType")
    private java.lang.String validationType;
    @XmlElement(name = "documentInfo")
    private org.kuali.student.core.document.dto.DocumentInfo documentInfo;

    public java.lang.String getValidationType() {
        return this.validationType;
    }

    public void setValidationType(java.lang.String newValidationType)  {
        this.validationType = newValidationType;
    }

    public org.kuali.student.core.document.dto.DocumentInfo getDocumentInfo() {
        return this.documentInfo;
    }

    public void setDocumentInfo(org.kuali.student.core.document.dto.DocumentInfo newDocumentInfo)  {
        this.documentInfo = newDocumentInfo;
    }

}

