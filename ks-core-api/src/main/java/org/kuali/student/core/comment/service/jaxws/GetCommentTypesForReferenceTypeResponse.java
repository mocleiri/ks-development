
package org.kuali.student.core.comment.service.jaxws;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.kuali.student.core.comment.dto.CommentTypeInfo;

/**
 * This class was generated by Apache CXF 2.2
 * Fri Jun 05 15:33:47 EDT 2009
 * Generated source version: 2.2
 */

@XmlRootElement(name = "getCommentTypesForReferenceTypeResponse", namespace = "http://student.kuali.org/wsdl/commentService")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCommentTypesForReferenceTypeResponse", namespace = "http://student.kuali.org/wsdl/commentService")

public class GetCommentTypesForReferenceTypeResponse {

    @XmlElement(name = "return")
    private java.util.List<CommentTypeInfo> _return;

    public java.util.List<CommentTypeInfo> getReturn() {
    	if (_return == null) {
    		_return = new ArrayList<CommentTypeInfo>(0);
    	}
        return this._return;
    }

    public void setReturn(java.util.List<CommentTypeInfo> new_return)  {
        this._return = new_return;
    }

}

