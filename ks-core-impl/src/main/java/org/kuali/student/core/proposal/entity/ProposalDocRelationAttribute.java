/*
 * Copyright 2009 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl1.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.core.proposal.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.kuali.student.core.entity.Attribute;

/**
 * This is a description of what this class does - lindholm don't forget to fill this in.
 *
 * @author Kuali Rice Team (kuali-rice@googlegroups.com)
 *
 */
@Entity
@Table(name = "KSCO_PROPOSAL_DOCREL_ATTR")
public class ProposalDocRelationAttribute extends Attribute<ProposalDocRelation> {
    @ManyToOne
    @JoinColumn(name = "OWNER")
    private ProposalDocRelation owner;

    @Override
    public ProposalDocRelation getOwner() {
        return owner;
    }

    @Override
    public void setOwner(ProposalDocRelation owner) {
        this.owner = owner;
    }

}
