/**
 * Copyright 2010 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */


package org.kuali.student.lum.lu.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Thu Jan 21 10:05:23 PST 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "updateCluResult", namespace = "http://student.kuali.org/wsdl/lu")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateCluResult", namespace = "http://student.kuali.org/wsdl/lu", propOrder = {"cluResultId","cluResultInfo"})

public class UpdateCluResult {

    @XmlElement(name = "cluResultId")
    private java.lang.String cluResultId;
    @XmlElement(name = "cluResultInfo")
    private org.kuali.student.lum.lu.dto.CluResultInfo cluResultInfo;

    public java.lang.String getCluResultId() {
        return this.cluResultId;
    }

    public void setCluResultId(java.lang.String newCluResultId)  {
        this.cluResultId = newCluResultId;
    }

    public org.kuali.student.lum.lu.dto.CluResultInfo getCluResultInfo() {
        return this.cluResultInfo;
    }

    public void setCluResultInfo(org.kuali.student.lum.lu.dto.CluResultInfo newCluResultInfo)  {
        this.cluResultInfo = newCluResultInfo;
    }

}

