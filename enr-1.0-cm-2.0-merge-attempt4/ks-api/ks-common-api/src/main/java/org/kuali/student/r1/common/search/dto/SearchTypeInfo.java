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

package org.kuali.student.r1.common.search.dto;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Deprecated
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchTypeInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlElement
	private String name; 
	@XmlElement
	private String desc; 
	@XmlElement
	private SearchResultTypeInfo searchResultTypeInfo; 
	@XmlElement
	private SearchCriteriaTypeInfo searchCriteriaTypeInfo; 
	@XmlAttribute
	private String key; 
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getDesc(){
		return desc;
	}
	public void setDesc(String desc){
		this.desc = desc;
	}
	public SearchResultTypeInfo getSearchResultTypeInfo(){
		return searchResultTypeInfo;
	}
	public void setSearchResultTypeInfo(SearchResultTypeInfo searchResultTypeInfo){
		this.searchResultTypeInfo = searchResultTypeInfo;
	}
	public SearchCriteriaTypeInfo getSearchCriteriaTypeInfo(){
		return searchCriteriaTypeInfo;
	}
	public void setSearchCriteriaTypeInfo(SearchCriteriaTypeInfo searchCriteriaTypeInfo){
		this.searchCriteriaTypeInfo = searchCriteriaTypeInfo;
	}
	public String getKey(){
		return key;
	}
	public void setKey(String key){
		this.key = key;
	}
}
