
package org.kuali.student.core.organization.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.kuali.student.core.organization.dto.OrgOrgRelationTypeInfo;

/**
 * This class was generated by Apache CXF 2.1.3
 * Fri Jan 16 11:42:39 EST 2009
 * Generated source version: 2.1.3
 */

@XmlRootElement(name = "getOrgOrgRelationTypesForOrgTypeResponse", namespace = "http://student.kuali.org/wsdl/organization")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getOrgOrgRelationTypesForOrgTypeResponse", namespace = "http://student.kuali.org/wsdl/organization")

public class GetOrgOrgRelationTypesForOrgTypeResponse {

    @XmlElement(name = "return")
    private java.util.List<OrgOrgRelationTypeInfo> _return;

    public java.util.List<OrgOrgRelationTypeInfo> getReturn() {
		if(_return==null){
			_return = new java.util.ArrayList<OrgOrgRelationTypeInfo>(0);
		}
        return this._return;
    }

    public void setReturn(java.util.List<OrgOrgRelationTypeInfo> new_return)  {
        this._return = new_return;
    }

}

