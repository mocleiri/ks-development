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

package org.kuali.student.lum.lo.service.impl;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.kuali.student.core.dictionary.dto.ObjectStructure;
import org.kuali.student.core.dictionary.service.DictionaryService;
import org.kuali.student.core.dto.StatusInfo;
import org.kuali.student.core.enumerable.dto.EnumeratedValue;
import org.kuali.student.core.exceptions.AlreadyExistsException;
import org.kuali.student.core.exceptions.CircularReferenceException;
import org.kuali.student.core.exceptions.DataValidationErrorException;
import org.kuali.student.core.exceptions.DependentObjectsExistException;
import org.kuali.student.core.exceptions.DoesNotExistException;
import org.kuali.student.core.exceptions.InvalidParameterException;
import org.kuali.student.core.exceptions.MissingParameterException;
import org.kuali.student.core.exceptions.OperationFailedException;
import org.kuali.student.core.exceptions.PermissionDeniedException;
import org.kuali.student.core.exceptions.UnsupportedActionException;
import org.kuali.student.core.exceptions.VersionMismatchException;
import org.kuali.student.core.search.dto.QueryParamValue;
import org.kuali.student.core.search.dto.Result;
import org.kuali.student.core.search.dto.SearchCriteriaTypeInfo;
import org.kuali.student.core.search.dto.SearchResultTypeInfo;
import org.kuali.student.core.search.dto.SearchTypeInfo;
import org.kuali.student.core.search.service.impl.SearchManager;
import org.kuali.student.core.validation.dto.ValidationResultContainer;
import org.kuali.student.lum.lo.dao.LoDao;
import org.kuali.student.lum.lo.dto.LoCategoryInfo;
import org.kuali.student.lum.lo.dto.LoHierarchyInfo;
import org.kuali.student.lum.lo.dto.LoInfo;
import org.kuali.student.lum.lo.dto.LoTypeInfo;
import org.kuali.student.lum.lo.entity.Lo;
import org.kuali.student.lum.lo.entity.LoCategory;
import org.kuali.student.lum.lo.entity.LoHierarchy;
import org.kuali.student.lum.lo.entity.LoType;
import org.kuali.student.lum.lo.service.LearningObjectiveService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Kuali Student team
 *
 */
@WebService(endpointInterface = "org.kuali.student.lum.lo.service.LearningObjectiveService", serviceName = "LearningObjectiveService", portName = "LearningObjectiveService", targetNamespace = "http://student.kuali.org/lum/lo")
@Transactional(rollbackFor={Throwable.class})
public class LearningObjectiveServiceImpl implements LearningObjectiveService {
    private LoDao loDao;
	private SearchManager searchManager;
    private DictionaryService dictionaryServiceDelegate;

	public LoDao getLoDao() {
        return loDao;
    }

    public void setLoDao(LoDao dao) {
        this.loDao = dao;
    }

	public void setSearchManager(SearchManager searchManager) {
		this.searchManager = searchManager;
	}

    public void setDictionaryServiceDelegate(DictionaryService dictionaryServiceDelegate) {
        this.dictionaryServiceDelegate = dictionaryServiceDelegate;
    }

    /* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#addChildLoToLo(java.lang.String, java.lang.String)
	 */
	@Override
	public StatusInfo addChildLoToLo(String loId, String parentLoId)
			throws AlreadyExistsException, CircularReferenceException,
			DoesNotExistException, InvalidParameterException,
			MissingParameterException, OperationFailedException,
			PermissionDeniedException, UnsupportedActionException {
	    checkForMissingParameter(loId, "loId");
	    checkForMissingParameter(parentLoId, "parentLoId");
	    StatusInfo statusInfo = new StatusInfo();
	    statusInfo.setSuccess(loDao.addChildLoToLo(loId, parentLoId));
		return statusInfo;
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#addEquivalentLoToLo(java.lang.String, java.lang.String)
	 */
	@Override
	public StatusInfo addEquivalentLoToLo(String loId, String equivalentLoId)
			throws AlreadyExistsException, DoesNotExistException,
			InvalidParameterException, MissingParameterException,
			OperationFailedException, PermissionDeniedException {
	    checkForMissingParameter(loId, "loId");
	    checkForMissingParameter(equivalentLoId, "equivalentLoId");
        StatusInfo statusInfo = new StatusInfo();
        statusInfo.setSuccess(loDao.addEquivalentLoToLo(loId, equivalentLoId));
        return statusInfo;
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#addLoCategoryToLo(java.lang.String, java.lang.String)
	 */
	@Override
	public StatusInfo addLoCategoryToLo(String loCategoryId, String loId)
			throws AlreadyExistsException, DoesNotExistException,
			InvalidParameterException, MissingParameterException,
			OperationFailedException, PermissionDeniedException,
			UnsupportedActionException {
	    checkForMissingParameter(loCategoryId, "loCategoryId");
	    checkForMissingParameter(loId, "loId");
        StatusInfo statusInfo = new StatusInfo();
        statusInfo.setSuccess(loDao.addLoCategoryToLo(loCategoryId, loId));
        return statusInfo;
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#createLo(java.lang.String, java.lang.String, org.kuali.student.lum.lo.dto.LoInfo)
	 */
	@Override
	public LoInfo createLo(String parentLoId, String loType, LoInfo loInfo)
			throws DataValidationErrorException, DoesNotExistException,
			InvalidParameterException, MissingParameterException,
			OperationFailedException, PermissionDeniedException {
	    // checkForMissingParameter(parentLoId, "parentLoId");
	    checkForMissingParameter(loType, "loType");
	    checkForMissingParameter(loInfo, "loInfo");
	    
	    LoType type = loDao.fetch(LoType.class, loType);
	    Lo parent = null;
	    if (null != parentLoId) {
		    parent = loDao.fetch(Lo.class, parentLoId); // Leaving this in so we can fail before create
	    }
	    
	    Lo lo = LearningObjectiveServiceAssembler.toLo(loInfo, loDao);
	    lo.setLoType(type);
	    loDao.create(lo);
	    
	    if (null != parent) {
	    	try {
			    loDao.addChildLoToLo(lo.getId(), parent.getId());
	    	} catch (AlreadyExistsException aee) {
	    		throw new OperationFailedException("createLo() failed.", aee);
	    	}
	    }
		return LearningObjectiveServiceAssembler.toLoInfo(lo);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#createLoCategory(java.lang.String, org.kuali.student.lum.lo.dto.LoCategoryInfo)
	 */
	@Override
	public LoCategoryInfo createLoCategory(String loHierarchyKey,
			LoCategoryInfo loCategoryInfo) throws DataValidationErrorException,
			DoesNotExistException, InvalidParameterException,
			MissingParameterException, OperationFailedException,
			PermissionDeniedException {
	    checkForMissingParameter(loHierarchyKey, "loHierarchyKey");
	    checkForMissingParameter(loCategoryInfo, "loCategoryInfo");
	    
	    LoHierarchy hierarchy = loDao.fetch(LoHierarchy.class, loHierarchyKey);
	    
	    LoCategory category = LearningObjectiveServiceAssembler.toLoCategory(loCategoryInfo, loDao);
	    category.setLoHierarchy(hierarchy);
	    loDao.create(category);
	    
		return LearningObjectiveServiceAssembler.toLoCategoryInfo(category);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#deleteLo(java.lang.String)
	 */
	@Override
	public StatusInfo deleteLo(String loId)
			throws DependentObjectsExistException, DoesNotExistException,
			InvalidParameterException, MissingParameterException,
			OperationFailedException, PermissionDeniedException {
	    checkForMissingParameter(loId, "loId");
	    
	    StatusInfo returnStatus = new StatusInfo();
	    returnStatus.setSuccess(loDao.deleteLo(loId));
		return returnStatus;
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#deleteLoCategory(java.lang.String)
	 */
	@Override
	public StatusInfo deleteLoCategory(String loCategoryId)
			throws DependentObjectsExistException, DoesNotExistException,
			InvalidParameterException, MissingParameterException,
			OperationFailedException, PermissionDeniedException {
	    checkForMissingParameter(loCategoryId, "loCategoryId");
	    
	    loDao.deleteLoCategory(loCategoryId);
	    
		return new StatusInfo();
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#getAllDescendants(java.lang.String)
	 */
	@Override
	public List<String> getAllDescendants(String loId)
			throws DoesNotExistException, InvalidParameterException,
			MissingParameterException, OperationFailedException {
	    checkForMissingParameter(loId, "loId");
		List<String> allDescendantLoIds = loDao.getAllDescendantLoIds(loId);
		if(allDescendantLoIds == null || allDescendantLoIds.isEmpty())
		    throw new DoesNotExistException(loId);
        return allDescendantLoIds;
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#getAncestors(java.lang.String)
	 */
	@Override
	public List<String> getAncestors(String loId) throws DoesNotExistException,
			InvalidParameterException, MissingParameterException,
			OperationFailedException {
	    checkForMissingParameter(loId, "loId");
	    List<String> ancestors = loDao.getAncestors(loId);
	    if(ancestors == null || ancestors.isEmpty())
	        throw new DoesNotExistException(loId);
		return ancestors;
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#getEquivalentLos(java.lang.String)
	 */
	@Override
	public List<LoInfo> getEquivalentLos(String loId)
			throws DoesNotExistException, InvalidParameterException,
			MissingParameterException, OperationFailedException {
	    checkForMissingParameter(loId, "loId");
	    
	    List<Lo> equivalentLos = loDao.getEquivalentLos(loId);
	    if (equivalentLos == null) { // should at least return an empty List
	        throw new OperationFailedException(loId);
	    } 
		return LearningObjectiveServiceAssembler.toLoInfos(equivalentLos);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#getLo(java.lang.String)
	 */
	@Override
	public LoInfo getLo(String loId) throws DoesNotExistException,
			InvalidParameterException, MissingParameterException,
			OperationFailedException {
	    checkForMissingParameter(loId, "loId");
	    
		return LearningObjectiveServiceAssembler.toLoInfo(loDao.fetch(Lo.class, loId));
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#getLoByIdList(java.util.List)
	 */
	@Override
	public List<LoInfo> getLoByIdList(List<String> loIds)
			throws InvalidParameterException, MissingParameterException,
			OperationFailedException {
	    checkForMissingParameter(loIds, "loId");
	    checkForEmptyList(loIds, "loId");
	    List<Lo> los = loDao.getLoByIdList(loIds);
		return LearningObjectiveServiceAssembler.toLoInfos(los);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#getLoCategories(java.lang.String)
	 */
	@Override
	public List<LoCategoryInfo> getLoCategories(String loHierarchyKey)
			throws DoesNotExistException, InvalidParameterException,
			MissingParameterException, OperationFailedException {
	    checkForMissingParameter(loHierarchyKey, "loHierarchyKey");
	    List<LoCategory> categories = loDao.getLoCategories(loHierarchyKey);
        return LearningObjectiveServiceAssembler.toLoCategoryInfos(categories);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#getLoCategoriesForLo(java.lang.String)
	 */
	@Override
	public List<LoCategoryInfo> getLoCategoriesForLo(String loId)
			throws DoesNotExistException, InvalidParameterException,
			MissingParameterException, OperationFailedException {
	    checkForMissingParameter(loId, "loId");
	    List<LoCategory> categories = loDao.getLoCategoriesForLo(loId);
		return LearningObjectiveServiceAssembler.toLoCategoryInfos(categories);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#getLoCategory(java.lang.String)
	 */
	@Override
	public LoCategoryInfo getLoCategory(String loCategoryId)
			throws DoesNotExistException, InvalidParameterException,
			MissingParameterException, OperationFailedException {
	    checkForMissingParameter(loCategoryId, "loCategoryId");
	    
		return LearningObjectiveServiceAssembler.toLoCategoryInfo(loDao.fetch(LoCategory.class, loCategoryId));
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#getLoChildren(java.lang.String)
	 */
	@Override
	public List<LoInfo> getLoChildren(String loId)
			throws DoesNotExistException, InvalidParameterException,
			MissingParameterException, OperationFailedException {
	    checkForMissingParameter(loId, "loId");
	    List<Lo> loChildren = loDao.getLoChildren(loId);
		return LearningObjectiveServiceAssembler.toLoInfos(loChildren);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#getLoEquivalents(java.lang.String)
	 */
	@Override
	public List<LoInfo> getLoEquivalents(String loId)
			throws DoesNotExistException, InvalidParameterException,
			MissingParameterException, OperationFailedException {
	    checkForMissingParameter(loId, "loId");
	    List<Lo> loEquivalents = loDao.getLoEquivalents(loId);
		return LearningObjectiveServiceAssembler.toLoInfos(loEquivalents);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#getLoHierarchies()
	 */
	@Override
	public List<LoHierarchyInfo> getLoHierarchies()
			throws OperationFailedException {
	    List<LoHierarchy> hierarchies = loDao.find(LoHierarchy.class);
		return LearningObjectiveServiceAssembler.toLoHierarchyInfos(hierarchies);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#getLoHierarchy(java.lang.String)
	 */
	@Override
	public LoHierarchyInfo getLoHierarchy(String loHierarchyKey)
			throws DoesNotExistException, InvalidParameterException,
			MissingParameterException, OperationFailedException {
	    checkForMissingParameter(loHierarchyKey, "loHierarchyKey");
	    LoHierarchy fetch = loDao.fetch(LoHierarchy.class, loHierarchyKey);
		return LearningObjectiveServiceAssembler.toLoHierarchyInfo(fetch);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#getLoParents(java.lang.String)
	 */
	@Override
	public List<LoInfo> getLoParents(String loId) throws DoesNotExistException,
			InvalidParameterException, MissingParameterException,
			OperationFailedException {
	    checkForMissingParameter(loId, "loId");
	    List<Lo> loParents = loDao.getLoParents(loId);
		return LearningObjectiveServiceAssembler.toLoInfos(loParents);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#getLoType(java.lang.String)
	 */
	@Override
	public LoTypeInfo getLoType(String loTypeKey) throws DoesNotExistException,
			InvalidParameterException, MissingParameterException,
			OperationFailedException {
	    checkForMissingParameter(loTypeKey, "loTypeKey");
	    LoType fetch = loDao.fetch(LoType.class, loTypeKey);
		return LearningObjectiveServiceAssembler.toLoTypeInfo(fetch);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#getLoTypes()
	 */
	@Override
	public List<LoTypeInfo> getLoTypes() throws OperationFailedException {
	    List<LoType> find = loDao.find(LoType.class);
		return LearningObjectiveServiceAssembler.toLoTypeInfos(find);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#getLosByLoCategory(java.lang.String)
	 */
	@Override
	public List<LoInfo> getLosByLoCategory(String loCategoryId)
			throws DoesNotExistException, InvalidParameterException,
			MissingParameterException, OperationFailedException {
	    checkForMissingParameter(loCategoryId, "loCategoryId");
	    List<Lo> los = loDao.getLosByLoCategory(loCategoryId);
		return LearningObjectiveServiceAssembler.toLoInfos(los);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#isDescendant(java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean isDescendant(String loId, String descendantLoId)
			throws DoesNotExistException, InvalidParameterException,
			MissingParameterException, OperationFailedException {
	    checkForMissingParameter(loId, "loId");
	    checkForMissingParameter(descendantLoId, "descendantLoId");
		return loDao.isDescendant(loId, descendantLoId);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#isEquivalent(java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean isEquivalent(String loId, String equivalentLoId)
			throws DoesNotExistException, InvalidParameterException,
			MissingParameterException, OperationFailedException {
	    checkForMissingParameter(loId, "loId");
	    checkForMissingParameter(equivalentLoId, "equivalentLoId");
		return loDao.isEquivalent(loId, equivalentLoId);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#removeChildLoFromLo(java.lang.String, java.lang.String)
	 */
	@Override
	public StatusInfo removeChildLoFromLo(String loId, String parentLoId)
			throws DependentObjectsExistException, DoesNotExistException,
			InvalidParameterException, MissingParameterException,
			OperationFailedException, PermissionDeniedException {
	    checkForMissingParameter(loId, "loId");
	    checkForMissingParameter(parentLoId, "parentLoId");
	    
	    StatusInfo statusInfo = new StatusInfo();
	    statusInfo.setSuccess(loDao.removeChildLoFromLo(loId, parentLoId));
		return statusInfo;
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#removeEquivalentLoFromLo(java.lang.String, java.lang.String)
	 */
	@Override
	public StatusInfo removeEquivalentLoFromLo(String loId,
			String equivalentLoId) throws DoesNotExistException,
			InvalidParameterException, MissingParameterException,
			OperationFailedException, PermissionDeniedException {
	    checkForMissingParameter(loId, "loId");
	    checkForMissingParameter(equivalentLoId, "equivalentLoId");
	    
        StatusInfo statusInfo = new StatusInfo();
        statusInfo.setSuccess(loDao.removeEquivalentLoFromLo(loId, equivalentLoId));
        return statusInfo;
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#removeLoCategoryFromLo(java.lang.String, java.lang.String)
	 */
	@Override
	public StatusInfo removeLoCategoryFromLo(String loCategoryId, String loId)
			throws DoesNotExistException, InvalidParameterException,
			MissingParameterException, OperationFailedException,
			PermissionDeniedException, UnsupportedActionException {
	    checkForMissingParameter(loCategoryId, "loCategoryId");
	    checkForMissingParameter(loId, "loId");
	    
        StatusInfo statusInfo = new StatusInfo();
        statusInfo.setSuccess(loDao.removeLoCategoryFromLo(loCategoryId, loId));
        return statusInfo;
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#updateLo(java.lang.String, org.kuali.student.lum.lo.dto.LoInfo)
	 */
	@Override
	public LoInfo updateLo(String loId, LoInfo loInfo)
			throws DataValidationErrorException, DoesNotExistException,
			InvalidParameterException, MissingParameterException,
			OperationFailedException, PermissionDeniedException,
			VersionMismatchException {
	    checkForMissingParameter(loId, "loId");
	    checkForMissingParameter(loInfo, "loInfo");

	    Lo lo = loDao.fetch(Lo.class, loId);
        
        if (!String.valueOf(lo.getVersionInd()).equals(loInfo.getMetaInfo().getVersionInd())){
            throw new VersionMismatchException("LO to be updated is not the current version");
        }
        
        lo = LearningObjectiveServiceAssembler.toLo(lo, loInfo, loDao);
        loDao.update(lo);
        return LearningObjectiveServiceAssembler.toLoInfo(lo);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#updateLoCategory(java.lang.String, org.kuali.student.lum.lo.dto.LoCategoryInfo)
	 */
	@Override
	public LoCategoryInfo updateLoCategory(String loCategoryId,
			LoCategoryInfo loCategoryInfo) throws DataValidationErrorException,
			DoesNotExistException, InvalidParameterException,
			MissingParameterException, OperationFailedException,
			PermissionDeniedException, VersionMismatchException {
	    checkForMissingParameter(loCategoryId, "loCategoryId");
	    checkForMissingParameter(loCategoryInfo, "loCategoryInfo");
	    
	    LoCategory loCategory = loDao.fetch(LoCategory.class, loCategoryId);
        
        if (!String.valueOf(loCategory.getVersionInd()).equals(loCategoryInfo.getMetaInfo().getVersionInd())){
            throw new VersionMismatchException("LO to be updated is not the current version");
        }
        
        loCategory = LearningObjectiveServiceAssembler.toLoCategory(loCategory, loCategoryInfo, loDao);
        loDao.update(loCategory);
        return LearningObjectiveServiceAssembler.toLoCategoryInfo(loCategory);
	}

	//
	// TODO - copy/adapt these from LuServiceImpl
	//
	
	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#validateLo(java.lang.String, org.kuali.student.lum.lo.dto.LoInfo)
	 */
	@Override
	public List<ValidationResultContainer> validateLo(String validationType,
			LoInfo loInfo) throws DoesNotExistException,
			InvalidParameterException, MissingParameterException,
			OperationFailedException {
	    checkForMissingParameter(validationType, "validationType");
	    checkForMissingParameter(loInfo, "loInfo");
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.lum.lo.service.LearningObjectiveService#validateLoCategory(java.lang.String, org.kuali.student.lum.lo.dto.LoCategoryInfo)
	 */
	@Override
	public List<ValidationResultContainer> validateLoCategory(String validationType,
			LoCategoryInfo loCategoryInfo) throws DoesNotExistException,
			InvalidParameterException, MissingParameterException,
			OperationFailedException {
	    checkForMissingParameter(validationType, "validationType");
	    checkForMissingParameter(loCategoryInfo, "loCategoryInfo");
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * Check for missing parameter and throw localized exception if missing
     *
     * @param param
     * @param parameter name
     * @throws MissingParameterException
     */
    private void checkForMissingParameter(Object param, String paramName)
            throws MissingParameterException {
        if (param == null) {
            throw new MissingParameterException(paramName + " can not be null");
        }
    }

    /**
     * @param param
     * @param paramName
     * @throws MissingParameterException
     */
    private void checkForEmptyList(Object param, String paramName)
            throws MissingParameterException {
        if (param != null && param instanceof List && ((List<?>)param).size() == 0) {
            throw new MissingParameterException(paramName + " can not be an empty list");
        }
    }



	/* (non-Javadoc)
	 * @see org.kuali.student.core.dictionary.service.DictionaryService#getObjectStructure(java.lang.String)
	 */
	@Override
	public ObjectStructure getObjectStructure(String objectTypeKey) {
        return dictionaryServiceDelegate.getObjectStructure(objectTypeKey);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.core.dictionary.service.DictionaryService#getObjectTypes()
	 */
	@Override
	public List<String> getObjectTypes() {
        return dictionaryServiceDelegate.getObjectTypes();
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.core.dictionary.service.DictionaryService#validateObject(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean validateObject(String objectTypeKey, String stateKey, String info) {
        return dictionaryServiceDelegate.validateObject(objectTypeKey, stateKey, info);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.core.dictionary.service.DictionaryService#validateStructureData(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean validateStructureData(String objectTypeKey, String stateKey, String info) {
        return dictionaryServiceDelegate.validateStructureData(objectTypeKey, stateKey, info);
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.core.enumerable.service.EnumerableService#getEnumeration(java.lang.String, java.lang.String, java.lang.String, java.util.Date)
	 */
	@Override
	public List<EnumeratedValue> getEnumeration(String enumerationKey,
			String enumContextKey, String contextValue, Date contextDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.kuali.student.core.search.service.SearchService#getSearchCriteriaType(java.lang.String)
	 */
    @Override
    public SearchCriteriaTypeInfo getSearchCriteriaType(
            String searchCriteriaTypeKey) throws DoesNotExistException,
            InvalidParameterException, MissingParameterException,
            OperationFailedException {

        return searchManager.getSearchCriteriaType(searchCriteriaTypeKey);
    }

	/* (non-Javadoc)
	 * @see org.kuali.student.core.search.service.SearchService#getSearchCriteriaTypes()
	 */
    @Override
    public List<SearchCriteriaTypeInfo> getSearchCriteriaTypes()
    throws OperationFailedException {
        return searchManager.getSearchCriteriaTypes();
    }

	/* (non-Javadoc)
	 * @see org.kuali.student.core.search.service.SearchService#getSearchResultType(java.lang.String)
	 */
    @Override
    public SearchResultTypeInfo getSearchResultType(String searchResultTypeKey)
    throws DoesNotExistException, InvalidParameterException,
    MissingParameterException, OperationFailedException {
        checkForMissingParameter(searchResultTypeKey, "searchResultTypeKey");
        return searchManager.getSearchResultType(searchResultTypeKey);
    }

	/* (non-Javadoc)
	 * @see org.kuali.student.core.search.service.SearchService#getSearchResultTypes()
	 */
    @Override
    public List<SearchResultTypeInfo> getSearchResultTypes()
    throws OperationFailedException {
        return searchManager.getSearchResultTypes();
    }

	/* (non-Javadoc)
	 * @see org.kuali.student.core.search.service.SearchService#getSearchType(java.lang.String)
	 */
    @Override
    public SearchTypeInfo getSearchType(String searchTypeKey)
    throws DoesNotExistException, InvalidParameterException,
    MissingParameterException, OperationFailedException {
        checkForMissingParameter(searchTypeKey, "searchTypeKey");
        return searchManager.getSearchType(searchTypeKey);
    }

	/* (non-Javadoc)
	 * @see org.kuali.student.core.search.service.SearchService#getSearchTypes()
	 */
    @Override
    public List<SearchTypeInfo> getSearchTypes()
    throws OperationFailedException {
        return searchManager.getSearchTypes();
    }

	/* (non-Javadoc)
	 * @see org.kuali.student.core.search.service.SearchService#getSearchTypesByCriteria(java.lang.String)
	 */
    @Override
    public List<SearchTypeInfo> getSearchTypesByCriteria(
            String searchCriteriaTypeKey) throws DoesNotExistException,
            InvalidParameterException, MissingParameterException,
            OperationFailedException {
        checkForMissingParameter(searchCriteriaTypeKey, "searchCriteriaTypeKey");
        return searchManager.getSearchTypesByCriteria(searchCriteriaTypeKey);
    }

	/* (non-Javadoc)
	 * @see org.kuali.student.core.search.service.SearchService#getSearchTypesByResult(java.lang.String)
	 */
    @Override
    public List<SearchTypeInfo> getSearchTypesByResult(
            String searchResultTypeKey) throws DoesNotExistException,
            InvalidParameterException, MissingParameterException,
            OperationFailedException {
        checkForMissingParameter(searchResultTypeKey, "searchResultTypeKey");
        return searchManager.getSearchTypesByResult(searchResultTypeKey);
    }

	/* (non-Javadoc)
	 * @see org.kuali.student.core.search.service.SearchService#searchForResults(java.lang.String, java.util.List)
	 */
	@Override
	public List<Result> searchForResults(String searchTypeKey,
			List<QueryParamValue> queryParamValues)
			throws DoesNotExistException, InvalidParameterException,
			MissingParameterException, OperationFailedException,
			PermissionDeniedException {
        checkForMissingParameter(searchTypeKey, "searchTypeKey");
        checkForMissingParameter(queryParamValues, "queryParamValues");

        return searchManager.searchForResults(searchTypeKey, queryParamValues, loDao);
	}
}
