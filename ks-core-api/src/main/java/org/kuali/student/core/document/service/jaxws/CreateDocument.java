
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

@XmlRootElement(name = "createDocument", namespace = "http://student.kuali.org/wsdl/document")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createDocument", namespace = "http://student.kuali.org/wsdl/document", propOrder = {"documentTypeKey","documentCategoryKey","documentInfo"})

public class CreateDocument {

    @XmlElement(name = "documentTypeKey")
    private java.lang.String documentTypeKey;
    @XmlElement(name = "documentCategoryKey")
    private java.lang.String documentCategoryKey;
    @XmlElement(name = "documentInfo")
    private org.kuali.student.core.document.dto.DocumentInfo documentInfo;

    public java.lang.String getDocumentTypeKey() {
        return this.documentTypeKey;
    }

    public void setDocumentTypeKey(java.lang.String newDocumentTypeKey)  {
        this.documentTypeKey = newDocumentTypeKey;
    }

    public java.lang.String getDocumentCategoryKey() {
        return this.documentCategoryKey;
    }

    public void setDocumentCategoryKey(java.lang.String newDocumentCategoryKey)  {
        this.documentCategoryKey = newDocumentCategoryKey;
    }

    public org.kuali.student.core.document.dto.DocumentInfo getDocumentInfo() {
        return this.documentInfo;
    }

    public void setDocumentInfo(org.kuali.student.core.document.dto.DocumentInfo newDocumentInfo)  {
        this.documentInfo = newDocumentInfo;
    }

}

