package org.kuali.student.lum.bo.options;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.kuali.rice.core.resourceloader.GlobalResourceLoader;
import org.kuali.rice.core.util.KeyLabelPair;
import org.kuali.rice.kns.lookup.keyvalues.KeyValuesBase;
import org.kuali.student.core.organization.service.OrganizationService;
import org.kuali.student.core.search.dto.SearchRequest;
import org.kuali.student.core.search.dto.SearchResultCell;
import org.kuali.student.core.search.dto.SearchResultRow;

public class RemoteOrganizationValuesFinder extends KeyValuesBase {

    private static final Logger LOG = Logger.getLogger(RemoteOrganizationValuesFinder.class);
    
    private OrganizationService organizationService;
    
    @Override
    public List<KeyLabelPair> getKeyValues() {
        List<KeyLabelPair> departments = new ArrayList<KeyLabelPair>();

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setSearchKey("org.search.generic");

        try {
            for (SearchResultRow result : getOrganizationService().search(searchRequest).getRows()) {
                String orgId = "";
                String orgShortName = "";
                String orgOptionalLongName = "";
                String orgType = "";
                for (SearchResultCell resultCell : result.getCells()) {
                    if ("org.resultColumn.orgId".equals(resultCell.getKey())) {
                        orgId = resultCell.getValue();
                    } else if ("org.resultColumn.orgShortName".equals(resultCell.getKey())) {
                        orgShortName = resultCell.getValue();
                    } else if ("org.resultColumn.orgOptionalLongName".equals(resultCell.getKey())) {
                        orgOptionalLongName = resultCell.getValue();
                    } else if ("org.resultColumn.orgType".equals(resultCell.getKey())) {
                        orgType = resultCell.getValue();
                    }
                }
                departments.add(buildKeyLabelPair(orgId, orgShortName, orgOptionalLongName, orgType));
            }

        } catch (Exception e) {
            LOG.error("Error building KeyValues List", e);
            // swallow exception for now, in case we want to run without ks up
            // throw new RuntimeException(e);
        }

        return departments;
    }

    protected OrganizationService getOrganizationService() {
        if (organizationService == null) {
            organizationService = (OrganizationService) GlobalResourceLoader
                .getService(new QName("http://student.kuali.org/wsdl/organization","OrganizationService"));
        }
        return organizationService;
    }
    
    /**
     * Builds a valid {@link KeyLabelPair} object for use in Student system KeyValue classes. Will throw an {@link IllegalArgumentException}
     * if the parameters needed are not passed.
     * 
     * @param orgId
     * @param orgShortName
     * @param orgLongName
     * @param orgType
     * @return
     */
    protected KeyLabelPair buildKeyLabelPair(String orgId, String orgShortName, String orgLongName, String orgType) {
        if (StringUtils.isBlank(orgShortName)) {
            throw new IllegalArgumentException("Blank value for orgShortName is invalid.");
        }
        
        return new KeyLabelPair(orgId, (StringUtils.isNotBlank(orgLongName) ? orgLongName : orgShortName) );
    }

}
