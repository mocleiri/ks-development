
package org.kuali.student.core.statement.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Thu Jul 22 13:21:32 PDT 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "getStatementTreeViewForNlUsageTypeResponse", namespace = "http://student.kuali.org/wsdl/statement")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStatementTreeViewForNlUsageTypeResponse", namespace = "http://student.kuali.org/wsdl/statement")

public class GetStatementTreeViewForNlUsageTypeResponse {

    @XmlElement(name = "return")
    private org.kuali.student.core.statement.dto.StatementTreeViewInfo _return;

    public org.kuali.student.core.statement.dto.StatementTreeViewInfo getReturn() {
        return this._return;
    }

    public void setReturn(org.kuali.student.core.statement.dto.StatementTreeViewInfo new_return)  {
        this._return = new_return;
    }

}

