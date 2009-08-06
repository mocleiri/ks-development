
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

@XmlRootElement(name = "searchForDocuments", namespace = "http://student.kuali.org/wsdl/document")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchForDocuments", namespace = "http://student.kuali.org/wsdl/document")

public class SearchForDocuments {

    @XmlElement(name = "documentCriteria")
    private org.kuali.student.core.document.dto.DocumentCriteriaInfo documentCriteria;

    public org.kuali.student.core.document.dto.DocumentCriteriaInfo getDocumentCriteria() {
        return this.documentCriteria;
    }

    public void setDocumentCriteria(org.kuali.student.core.document.dto.DocumentCriteriaInfo newDocumentCriteria)  {
        this.documentCriteria = newDocumentCriteria;
    }

}

