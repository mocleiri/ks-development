/*
 * Copyright 2007 The Kuali Foundation
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
package org.kuali.student.brms.repository.drools.rule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.kuali.student.brms.repository.rule.AbstractItem;
import org.kuali.student.brms.repository.rule.Rule;
import org.kuali.student.brms.repository.rule.RuleSet;
import org.kuali.student.brms.repository.util.ObjectUtil;

/**
 * This is the implementation of a <code>RuleSet</code>. 
 * 
 * @author Kuali Student Team (len.kuali@googlegroups.com)
 *
 */
public class DroolsRuleSetImpl 
    extends AbstractItem 
    implements java.io.Serializable, RuleSet {

    private final static String SEMICOLON = ";";

    /** Class serial version uid */
    private static final long serialVersionUID = 1L;
    
    /** List of rules in this rule set */
    private Map<String,Rule> rules = new LinkedHashMap<String,Rule>();
    /** Compiled rule set bye array */
    private byte[] compiledRuleSet;
    /** Compiled rule set object */
    private Serializable compiledRuleSetObject;
    /** List of header items */
    private List<String> header = new ArrayList<String>();
    /** true if this rule set is a snapshot, otherwise false */
    private boolean snapshot = false;
    /** snapshot name */
    private String snapshotName;
    /** Object utility class */
    private ObjectUtil objectUtil = ObjectUtil.getInstance();

    /**
     * Constructs a new rule set.
     * 
     * @param name Rule name
     */
    public DroolsRuleSetImpl(final String name, final String description) {
        super(name, description, DroolsConstants.FORMAT_DRL);
    }

    public DroolsRuleSetImpl(final String name, final String description, final String format) {
        super(name, description, format);
    }

    /**
     * <p>Constructs a new rule set.<p/>
     * <p>Internal use only. This is set by the repository when persisting a rule set.</p>
     * 
     * @param uuid Rule UUID - This is created by the repository
     * @param name Rule name
     * @param versionNumber Rule version number
     */
    DroolsRuleSetImpl(final String uuid, final String name, final long versionNumber) {
        super(uuid, name, versionNumber);
    }

    /**
     * @see org.kuali.student.brms.repository.rule.RuleSet#addRule(org.kuali.student.brms.repository.rule.Rule)
     */
    public void addRule(final Rule rule) {
        if ( rule == null ) {
            return;
        }
        this.rules.put(rule.getName(), rule);
    }

    /**
     * @see org.kuali.student.brms.repository.rule.RuleSet#removeRule(java.lang.String)
     */
    public Rule removeRule(final String ruleName) {
        return this.rules.remove( ruleName );
    }

    /**
     * @see org.kuali.student.brms.repository.rule.RuleSet#containsRule(java.lang.String)
     */
    public boolean containsRule(final String ruleName) {
        return this.rules.containsKey( ruleName );
    }

    /**
     * @see org.kuali.student.brms.repository.rule.RuleSet#clearRules()
     */
    public void clearRules() {
        this.rules.clear();
    }

    /**
     * @see org.kuali.student.brms.repository.rule.RuleSet#getRules()
     */
    public List<Rule> getRules() {
        try {
            return (List<Rule>) objectUtil.deepCopy(this.createList());
        } catch( Exception e ) {
            throw new RuntimeException( e );
        }
    }
    
    /**
     * Creates a <code>java.util.List<Rule></code> from a 
     * <code>Map<String,Rule></code>
     * 
     * @return A list of rules
     */
    private List<Rule> createList() {
        List<Rule> list = new ArrayList<Rule>();
        for(Rule rule : this.rules.values()) {
            list.add(rule);
        }
        return list;
    }
    
    /**
     * @see org.kuali.student.brms.repository.rule.RuleSet#addHeader(java.lang.String)
     */
    public void addHeader(final String header) {
        if ( header == null ) {
            return;
        }
        this.header.add(getProperHeader(header));
    }

    public boolean containsHeader(String header) {
        return this.header.contains(getProperHeader(header));
    }
    
    /**
     * @see org.kuali.student.brms.repository.rule.RuleSet#removeHeader(java.lang.String)
     */
    public boolean removeHeader(final String header) {
        return this.header.remove( getProperHeader(header) );
    }

    private String getProperHeader(String header) {
        return (header.endsWith(SEMICOLON) ? header : header.trim() + SEMICOLON);
    }
    /**
     * @see org.kuali.student.brms.repository.rule.RuleSet#clearHeaders()
     */
    public void clearHeaders() {
        this.header.clear();
    }

    /**
     * @see org.kuali.student.brms.repository.rule.RuleSet#getHeader()
     */
    public String getHeader() {
        StringBuilder sb = new StringBuilder();
        for(String header : this.header) {
            sb.append(getProperHeader(header));
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * Sets a list of rule set headers.
     * 
     * @param header Rule set header
     */
    public void setHeaderList(final List<String> header) {
        this.header = header;
    }

    /**
     * @see org.kuali.student.brms.repository.rule.RuleSet#getHeaderList()
     */
    public List<String> getHeaderList() {
        List<String> list = new ArrayList<String>();
        for(String header : this.header) {
            list.add(getProperHeader(header));
        }
        return list;
    }

    /**
     * Returns a copy of the compiled rule set binary;
     * 
     * @see org.kuali.student.brms.repository.rule.RuleSet#getCompiledRuleSet()
     */
    public byte[] getCompiledRuleSet() {
        return objectUtil.arrayCopy( this.compiledRuleSet );
    }

    /**
     * Sets a compiled rule set byte array. 
     * This method makes a copy of the compiled rules set.
     * 
     * @param compiledRuleSet Compiled rule set byte array
     */
    public void setCompiledRuleSet(final byte[] compiledRuleSet) {
        this.compiledRuleSet = objectUtil.arrayCopy( compiledRuleSet );
    }

    /**
     * Returns a deep copy of the compiled rule set object.
     * 
     * @see org.kuali.student.brms.repository.rule.RuleSet#getCompiledRuleSetObject()
     */
    public Object getCompiledRuleSetObject() {
        try {
            return objectUtil.deepCopy( this.compiledRuleSetObject );
        } catch( Exception e ) {
            throw new RuntimeException( e );
        }
    }

    /**
     * Sets a compiled rule set object. E.g. A Drools a <code>org.drools.rule.Package</code>.
     * This methods makes a deep copy of the <code>compiledRuleSetObject</code>.
     * 
     * @param compiledRuleSetObject A compiled rule set object
     */
    public void setCompiledRuleSetObject(final Serializable compiledRuleSetObject) {
        try {
            this.compiledRuleSetObject = (Serializable) objectUtil.deepCopy( compiledRuleSetObject );
        } catch( Exception e ) {
            throw new RuntimeException( e );
        }
    }

    /**
     * @see org.kuali.student.brms.repository.rule.RuleSet#isSnapshot()
     */
    public boolean isSnapshot() {
        return this.snapshot;
    }

    /**
     * Sets whether this rule set is a snapshot.
     * If <code>snapshot</code> is set to true then this rule set is a snapshot,
     * otherwise this rule set is not a snapshot.
     * 
     * @param snapshot True if this rule set is snapshot, otherwise false 
     */
    public void setSnapshot(final boolean snapshot) {
        this.snapshot = snapshot;
    }

    /**
     * @see org.kuali.student.brms.repository.rule.RuleSet#getContent()
     */
    public String getContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("package ");
        sb.append(super.getName());
        sb.append("\n");
        for(String header : this.header) {
            sb.append(header);
            sb.append("\n");
        }

        for(Rule rule : this.rules.values()) {
            sb.append(rule.getContent());
            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * @see org.kuali.student.brms.repository.rule.RuleSet#getSnapshotName()
     */
    public String getSnapshotName() {
        return this.snapshotName;
    }

    /**
     * @see org.kuali.student.brms.repository.rule.RuleSet#setSnapshotName(java.lang.String)
     */
    public void setSnapshotName(final String snapshotName) {
        this.snapshotName = snapshotName;
    }

    /**
     * Overrides hashCode
     * 
     * @see org.kuali.student.brms.repository.rule.AbstractItem#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + super.hashCode();
        result = prime * result + ( this.header == null ? 0 : this.header.hashCode() );
        result = prime * result + ( this.rules == null ? 0 : this.rules.hashCode() );
        return result;
    }

    /**
     * Overrides equals.
     * 
     * @see org.kuali.student.brms.repository.rule.AbstractItem#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( this.getClass() != obj.getClass() ) {
            return false;
        }
        if ( this.getName() == null ) {
            return false;
        }
        
        final DroolsRuleSetImpl ruleSet = (DroolsRuleSetImpl) obj;
        
        if ( ruleSet.getName() == null ) {
            return false;
        }
        if ( header == null && ruleSet.header != null  ) {
            return false;
        } else if ( header != null && ruleSet.header == null  ) {
            return false;
        } else if ( header != null && ruleSet.header != null && !header.equals( ruleSet.header ) ) {
            return false;
        }
        
        if ( rules == null && ruleSet.rules != null ) {
            return false;
        } else if ( rules != null && ruleSet.rules == null ) {
            return false;
        } else if ( rules != null && ruleSet.rules != null && !rules.equals( ruleSet.rules ) ) {
            return false;
        }
        
        if ( !getName().equals( ruleSet.getName() ) ) {
            return false;
        }
        if ( ruleSet.getUUID() != null && !ruleSet.getUUID().equals( this.getUUID() ) ) {
            return false;
        }
        if ( ruleSet.getVersionNumber() != this.getVersionNumber() ) {
            return false;
        }
        
        return true;
    }

}
