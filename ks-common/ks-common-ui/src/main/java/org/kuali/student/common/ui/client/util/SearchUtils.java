package org.kuali.student.common.ui.client.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.kuali.student.common.assembly.data.Data;
import org.kuali.student.common.assembly.data.LookupMetadata;
import org.kuali.student.common.assembly.data.LookupParamMetadata;
import org.kuali.student.common.assembly.data.Data.Property;
import org.kuali.student.common.assembly.data.Data.Value;
import org.kuali.student.common.assembly.data.Metadata.WriteAccess;
import org.kuali.student.common.search.dto.SearchParam;
import org.kuali.student.common.search.dto.SearchRequest;
import org.kuali.student.common.ui.client.application.Application;
import org.kuali.student.common.ui.client.configurable.mvc.FieldDescriptor;
import org.kuali.student.common.ui.client.mvc.HasDataValue;

import com.google.gwt.core.client.GWT;

/**
 *  
 *  This is a libary of utility methods that can be used when working with the search rpc service. 
 *
 */
public class SearchUtils {

	//This class wraps the search request, with additional information related to search
	//such as constraints and if search should be deferred
	public static class SearchRequestWrapper{
		SearchRequest searchRequest;
		HashSet<String> crossConstraints = new HashSet<String>();
		boolean deferSearch = false;
		
		public SearchRequest getSearchRequest() {
			return searchRequest;
		}
		
		public void setSearchRequest(SearchRequest searchRequest) {
			this.searchRequest = searchRequest;
		}
		
		public HashSet<String> getCrossConstraints() {
			return crossConstraints;
		}
		
		public void setCrossConstraints(HashSet<String> constraints) {
			this.crossConstraints = constraints;
		}

		public boolean isDeferSearch() {
			return deferSearch;
		}

		public void setDeferSearch(boolean deferSearch) {
			this.deferSearch = deferSearch;
		}				
	}
	
	public static SearchRequest initializeSearchRequest(LookupMetadata lookup) {
		SearchRequestWrapper searchRequestWrapper = new SearchRequestWrapper();
		initializeSearchRequest(lookup, searchRequestWrapper);
		return searchRequestWrapper.getSearchRequest();
	}

	public static void initializeSearchRequest(LookupMetadata lookup, SearchRequestWrapper searchRequestWrapper) {

		HashSet<String> crossConstraints = searchRequestWrapper.getCrossConstraints();
		
		SearchRequest sr = new SearchRequest();
        List<SearchParam> params = new ArrayList<SearchParam>();

        sr.setSearchKey(lookup.getSearchTypeId());

        if (lookup.getResultSortKey() != null){
        	sr.setSortColumn(lookup.getResultSortKey());
        }

        //initialize search parameters that are hidden from the UI because they are set to default context specific values
        for(final LookupParamMetadata metaParam: lookup.getParams()){
            if(metaParam.getWriteAccess() == WriteAccess.NEVER){
                if ((metaParam.getDefaultValueString() == null || metaParam.getDefaultValueString().isEmpty())&&
                    (metaParam.getDefaultValueList() == null || metaParam.getDefaultValueList().isEmpty())&&
                    (metaParam.getFieldPath() == null || metaParam.getFieldPath().isEmpty())) {
                    //FIXME throw an exception?
                    GWT.log("Key = " + metaParam.getKey() + " has write access NEVER but has no default value!", null);
                    continue;
                }
                final SearchParam param = new SearchParam();
                param.setKey(metaParam.getKey());
                if(metaParam.getFieldPath()!=null){
                	FieldDescriptor fd = null;
                	String finalPath;
                	if(metaParam.getFieldPath().startsWith("/")){
                		finalPath=metaParam.getFieldPath().substring(1);
                	}else{
                		finalPath=Application.getApplicationContext().getParentPath()+metaParam.getFieldPath();
                	}
            		crossConstraints.add(finalPath);
            		fd = Application.getApplicationContext().getPathToFieldMapping(null, finalPath);
                	if(fd!=null){
                		if(fd.getFieldElement().getFieldWidget() instanceof HasDataValue){
                			Value value = ((HasDataValue)fd.getFieldElement().getFieldWidget()).getValue();
                			if(value!=null&&value.get()!=null){
                				if(value.get() instanceof Data){
                					ArrayList<String> listValue = new ArrayList<String>();
                					for(Iterator<Property> iter =((Data)value.get()).realPropertyIterator();iter.hasNext();){
                						listValue.add(iter.next().getValue().toString());
                					}
                					if(listValue.isEmpty()){
                						listValue.add("");
                					}
                					param.setValue(listValue);
                				}else{
                					param.setValue(value.get().toString());	
                				}
                			}else{
                				param.setValue((String)null);
                			}                				
                		}
                	}
                	searchRequestWrapper.setDeferSearch(true);
                }else if(metaParam.getDefaultValueList()==null){
                    param.setValue(metaParam.getDefaultValueString());
                }else{
                    param.setValue(metaParam.getDefaultValueList());
                }
                params.add(param);
            }
            else if(metaParam.getWriteAccess() == WriteAccess.WHEN_NULL){
                if((metaParam.getDefaultValueString() != null && !metaParam.getDefaultValueString().isEmpty())||
                   (metaParam.getDefaultValueList() != null && !metaParam.getDefaultValueList().isEmpty())||
                   (metaParam.getFieldPath() != null && !metaParam.getFieldPath().isEmpty())){
                    final SearchParam param = new SearchParam();
                    param.setKey(metaParam.getKey());
                    if(metaParam.getFieldPath()!=null){
                    	FieldDescriptor fd = null;
                    	String finalPath;
                    	if(metaParam.getFieldPath().startsWith("/")){
                    		finalPath=metaParam.getFieldPath().substring(1);
                    	}else{
                    		finalPath=Application.getApplicationContext().getParentPath()+metaParam.getFieldPath();
                    	}
                		crossConstraints.add(finalPath);
                		fd = Application.getApplicationContext().getPathToFieldMapping(null, finalPath);
                    	if(fd!=null){
                    		if(fd.getFieldElement().getFieldWidget() instanceof HasDataValue){
                    			Value value = ((HasDataValue)fd.getFieldElement().getFieldWidget()).getValue();
                    			param.setValue(value==null?null:value.get()==null?null:value.get().toString());
                    		}
                    	}
                    	searchRequestWrapper.setDeferSearch(true);
                    }else if(metaParam.getDefaultValueList()==null){
                        param.setValue(metaParam.getDefaultValueString());
                    }else{
                        param.setValue(metaParam.getDefaultValueList());
                    }
                    params.add(param);
                }
            }
        }
        sr.setParams(params);
        searchRequestWrapper.setSearchRequest(sr);
    }

}
