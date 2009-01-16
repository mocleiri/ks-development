/*
 * Copyright 2007 The Kuali Foundation Licensed under the Educational Community License, Version 1.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.opensource.org/licenses/ecl1.php Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and limitations under the License.
 */
package org.kuali.student.rules.rulemanagement.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.kuali.student.poc.common.util.UUIDHelper;

/**
 * Maps a set of Business Rule Types to form an AgendaInfo and a specif instance of Business Rules form an Agenda for this
 * AgendaInfo
 * 
 * @author Kuali Student Team (kamal.kuali@gmail.com)
 */
@Entity
@Table(name = "AgendaInfo_T")
@NamedQueries({@NamedQuery(name = "AgendaInfo.findBusinessRuleTypes", query = "SELECT a.businessRuleTypeInfoList FROM AgendaInfo a WHERE a.type = :agendaType "),
              @NamedQuery(name = "AgendaInfo.findByAgendaType", query = "SELECT a FROM AgendaInfo a WHERE a.type = :agendaType "),
              @NamedQuery(name = "AgendaInfo.findUniqueAgendaTypes", query = "SELECT DISTINCT a.type FROM AgendaInfo a ORDER BY a.type ASC")})
public class AgendaInfo {
    @Id
    private String id;

    private String type;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "agendaInfo")
    private List<AgendaDeterminationInfo> agendaDeterminationInfoList;

    //TODO: Change this to @OnetoMany relation after they fix the bug HHH-3410
    @ManyToMany(fetch = FetchType.EAGER)
    private List<BusinessRuleType> businessRuleTypeInfoList;

    private String agendaOrchestration;
    
    /**
     * AutoGenerate the Id
     */
    @PrePersist
    public void prePersist() {
        this.id = UUIDHelper.genStringUUID(this.id);
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the agendaDeterminationInfoList
     */
    public List<AgendaDeterminationInfo> getAgendaDeterminationInfoList() {
        return agendaDeterminationInfoList;
    }

    /**
     * @param agendaDeterminationInfoList the agendaDeterminationInfoList to set
     */
    public void setAgendaDeterminationInfoList(List<AgendaDeterminationInfo> agendaDeterminationInfoList) {
        this.agendaDeterminationInfoList = agendaDeterminationInfoList;
    }

    /**
     * @return the businessRuleTypeInfoList
     */
    public List<BusinessRuleType> getBusinessRuleTypeInfoList() {
        return businessRuleTypeInfoList;
    }

    /**
     * @param businessRuleTypeInfoList the businessRuleTypeInfoList to set
     */
    public void setBusinessRuleTypeInfoList(List<BusinessRuleType> businessRuleTypeInfoList) {
        this.businessRuleTypeInfoList = businessRuleTypeInfoList;
    }

    /**
     * @return the agendaOrchestration
     */
    public String getAgendaOrchestration() {
        return agendaOrchestration;
    }

    /**
     * @param agendaOrchestration the agendaOrchestration to set
     */
    public void setAgendaOrchestration(String agendaOrchestration) {
        this.agendaOrchestration = agendaOrchestration;
    }

    /**
     * 
     * This method converts the flattened out List of agendaDeterminationInfoList into a map of
     * Info Key and Info Value
     * 
     * @return
     */
    public Map<String, String> getAgendaDeterminationInfoMap() {
        Map<String, String> result = new HashMap<String, String>();
     
        for(AgendaDeterminationInfo agendaInfoElement : agendaDeterminationInfoList) {
            result.put(agendaInfoElement.getStructureKey(), agendaInfoElement.getValue());
        }
           
        return result;
    }
}
