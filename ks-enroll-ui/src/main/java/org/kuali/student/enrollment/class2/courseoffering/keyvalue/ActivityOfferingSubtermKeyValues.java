/**
 * Copyright 2013 The Kuali Foundation Licensed under the
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
 *
 * Created by vgadiyak on 6/18/13
 */
package org.kuali.student.enrollment.class2.courseoffering.keyvalue;

import org.apache.commons.lang.StringUtils;
import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.kuali.rice.krad.uif.view.ViewModel;
import org.kuali.rice.krad.web.form.InquiryForm;
import org.kuali.rice.krad.web.form.MaintenanceDocumentForm;
import org.kuali.student.enrollment.class2.acal.dto.AcademicTermWrapper;
import org.kuali.student.enrollment.class2.courseoffering.dto.ActivityOfferingWrapper;
import org.kuali.student.r2.common.constants.CommonServiceConstants;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.core.acal.dto.TermInfo;
import org.kuali.student.r2.core.acal.service.AcademicCalendarService;
import org.kuali.student.r2.core.class1.type.dto.TypeInfo;
import org.kuali.student.r2.core.class1.type.service.TypeService;
import org.kuali.student.r2.core.constants.TypeServiceConstants;
import org.kuali.student.r2.core.enumerationmanagement.dto.EnumeratedValueInfo;

import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class //TODO ...
 *
 * @author Kuali Student Team
 */
public class ActivityOfferingSubtermKeyValues extends UifKeyValuesFinderBase implements Serializable {

    private static final long serialVersionUID = 1L;

    private transient TypeService typeService;
    private transient AcademicCalendarService acalService;

    @Override
    public List<KeyValue> getKeyValues(ViewModel model) {

        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(new ConcreteKeyValue("", "None"));

        ActivityOfferingWrapper wrapper = null;
        if (model instanceof MaintenanceDocumentForm) {
            MaintenanceDocumentForm form = (MaintenanceDocumentForm)model;
            wrapper = (ActivityOfferingWrapper)form.getDocument().getNewMaintainableObject().getDataObject();
        } else if (model instanceof InquiryForm) {
            InquiryForm form = (InquiryForm)model;
            wrapper = (ActivityOfferingWrapper)form.getDataObject();
        }
        String parentTermType = wrapper.getTerm().getId();

        List<TermInfo> terms = new ArrayList<TermInfo>();
        try {
            ContextInfo context = new ContextInfo();
            terms = getAcademicCalendarService().getIncludedTermsInTerm(parentTermType, context);

            if(terms.size() > 1) {
                Collections.sort(terms, new SubtermComparator());
            }

            for (TermInfo term : terms) {
                ConcreteKeyValue keyValue = new ConcreteKeyValue();
                TypeInfo type = getTypeService().getType(term.getTypeKey(), context);
                keyValue.setKey(term.getId());
                keyValue.setValue(type.getName());
                keyValues.add(keyValue);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return keyValues;
    }

    private static class SubtermComparator implements Comparator, Serializable {
        @Override
        public int compare(Object o1, Object o2) {
            String value1 = ((TermInfo) o1).getId();
            String value2 = ((TermInfo) o2).getId();

            int result = value1.compareToIgnoreCase(value2);
            return result;
        }
    }

    public TypeService getTypeService() {
        if(typeService == null) {
            typeService = (TypeService) GlobalResourceLoader.getService(new QName(TypeServiceConstants.NAMESPACE, TypeServiceConstants.SERVICE_NAME_LOCAL_PART));
        }
        return this.typeService;
    }

    public AcademicCalendarService getAcademicCalendarService() {
        if(acalService == null) {
            acalService = (AcademicCalendarService) GlobalResourceLoader.getService(new QName(CommonServiceConstants.REF_OBJECT_URI_GLOBAL_PREFIX + "acal", "AcademicCalendarService"));
        }
        return this.acalService;
    }

}