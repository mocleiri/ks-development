package org.kuali.student.r2.core.class1.type.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.StatusInfo;
import org.kuali.student.r2.common.dto.ValidationResultInfo;
import org.kuali.student.r2.common.exceptions.AlreadyExistsException;
import org.kuali.student.r2.common.exceptions.DataValidationErrorException;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.common.exceptions.ReadOnlyException;
import org.kuali.student.r2.common.exceptions.VersionMismatchException;
import org.kuali.student.r2.common.util.constants.TypeServiceConstants;
import org.kuali.student.r2.core.class1.type.dao.TypeDao;
import org.kuali.student.r2.core.class1.type.dao.TypeTypeRelationDao;
import org.kuali.student.r2.core.class1.type.model.TypeEntity;
import org.kuali.student.r2.core.class1.type.model.TypeTypeRelationEntity;
import org.kuali.student.r2.core.type.dto.TypeInfo;
import org.kuali.student.r2.core.type.dto.TypeTypeRelationInfo;
import org.kuali.student.r2.core.type.service.TypeService;
import org.springframework.transaction.annotation.Transactional;

public class TypeServiceImpl implements TypeService {

    private TypeDao typeDao;
    private TypeTypeRelationDao typeTypeRelationDao;

    public TypeDao getTypeDao() {
        return typeDao;
    }

    public void setTypeDao(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    public TypeTypeRelationDao getTypeTypeRelationDao() {
        return typeTypeRelationDao;
    }

    public void setTypeTypeRelationDao(TypeTypeRelationDao typeTypeRelationDao) {
        this.typeTypeRelationDao = typeTypeRelationDao;
    }

    @Override
    @Transactional(readOnly = true, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public TypeInfo getType(String typeKey, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException,
            PermissionDeniedException {
        TypeEntity entity = typeDao.find(typeKey);
        if (entity == null) {
            throw new DoesNotExistException(typeKey);
        }
        return entity.toDto();
    }

    @Override
    @Transactional(readOnly = true, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public List<TypeInfo> getTypesByKeys(List<String> typeKeys, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException,
            PermissionDeniedException {
        List<TypeInfo> typeInfoList = new ArrayList<TypeInfo>();
        for (TypeEntity type : typeDao.findByIds(typeKeys)) {
            typeInfoList.add(type.toDto());
        }
        return typeInfoList;
    }

    @Override
    @Transactional(readOnly = true, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public List<TypeInfo> getAllowedTypesForType(String ownerTypeKey, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        List<TypeTypeRelationInfo> rels = getTypeTypeRelationsByOwnerAndType(ownerTypeKey, TypeServiceConstants.TYPE_TYPE_RELATION_ALLOWED_TYPE_KEY, contextInfo);
        List<TypeInfo> typeInfoList = new ArrayList<TypeInfo>(rels.size());
        for (TypeTypeRelationInfo rel : rels) {
            if (this.isRelationshipActive(rel)) {
                typeInfoList.add(this.getType(rel.getRelatedTypeKey(), contextInfo));
            }
        }
        return typeInfoList;
    }

    private boolean isRelationshipActive(TypeTypeRelationInfo rel) {
        if (!rel.getStateKey().equals(TypeServiceConstants.TYPE_TYPE_RELATION_ACTIVE_STATE_KEY)) {
            return false;
        }
        if (rel.getEffectiveDate() != null) {
            if (rel.getEffectiveDate().after(new Date())) {
                return false;
            }
        }
        if (rel.getExpirationDate() != null) {
            if (rel.getExpirationDate().before(new Date())) {
                return false;
            }
        }
        return true;
    }

    @Override
    @Transactional(readOnly = true, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public List<TypeInfo> getTypesForGroupType(String groupTypeKey, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        List<TypeTypeRelationInfo> rels = getTypeTypeRelationsByOwnerAndType(groupTypeKey, TypeServiceConstants.TYPE_TYPE_RELATION_GROUP_TYPE_KEY, contextInfo);
        List<TypeInfo> typeInfoList = new ArrayList<TypeInfo>(rels.size());
        for (TypeTypeRelationInfo rel : rels) {
            if (this.isRelationshipActive(rel)) {
                typeInfoList.add(this.getType(rel.getRelatedTypeKey(), contextInfo));
            }
        }
        return typeInfoList;
    }

    @Override
    public List<ValidationResultInfo> validateType(String validationTypeKey, TypeInfo typeInfo, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        return new ArrayList<ValidationResultInfo>();
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public TypeInfo createType(String typeKey, TypeInfo typeInfo, ContextInfo contextInfo) throws AlreadyExistsException, DataValidationErrorException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        TypeEntity entity = typeDao.find(typeKey);
        if (entity != null) {
            throw new AlreadyExistsException(typeKey);
        }
        if (!typeKey.equals(typeInfo.getKey())) {
            throw new InvalidParameterException(typeKey + " does not match the key in the info object " + typeInfo.getKey());
        }
        entity = new TypeEntity(typeInfo);
        entity.setId(typeKey);
       
        entity.setEntityCreated(contextInfo);
        
        typeDao.persist(entity);
        return entity.toDto();
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public TypeInfo updateType(String typeKey, TypeInfo typeInfo, ContextInfo contextInfo) throws DataValidationErrorException, DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException, VersionMismatchException {
        TypeEntity entity = typeDao.find(typeKey);
        if (entity == null) {
            throw new DoesNotExistException(typeKey);
        }
        entity.fromDto(typeInfo);

        entity.setEntityUpdated(contextInfo);
        
        typeDao.merge(entity);
        return entity.toDto();
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo deleteType(String typeKey, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException,
            PermissionDeniedException {

        TypeEntity entity = typeDao.find(typeKey);
        if (entity == null) {
            throw new DoesNotExistException(typeKey);
        }
        typeDao.remove(entity);
        StatusInfo deleteStatus = new StatusInfo();
        deleteStatus.setSuccess(true);
        return deleteStatus;
    }

    @Override
    @Transactional(readOnly = true, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public TypeTypeRelationInfo getTypeTypeRelation(String typeTypeRelationKey, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        TypeTypeRelationEntity entity = typeTypeRelationDao.find(typeTypeRelationKey);
        if (entity == null) {
            throw new DoesNotExistException(typeTypeRelationKey);
        }
        return entity.toDto();
    }

    @Override
    @Transactional(readOnly = true, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public List<TypeTypeRelationInfo> getTypeTypeRelationsByOwnerAndType(String ownerTypeKey, String relationTypeKey, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        List<TypeTypeRelationEntity> typeTypeEntities = typeTypeRelationDao.getTypeTypeRelationsByOwnerAndRelationType(ownerTypeKey, relationTypeKey);
        List<TypeTypeRelationInfo> typeTypeRealtionInfo = new ArrayList<TypeTypeRelationInfo>(typeTypeEntities.size());
        for (TypeTypeRelationEntity typeTypeEntity : typeTypeEntities) {
            typeTypeRealtionInfo.add(typeTypeEntity.toDto());
        }
        return typeTypeRealtionInfo;
    }

    
    @Override
    @Transactional(readOnly = true, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public List<TypeTypeRelationInfo> getTypeTypeRelationsByRelatedTypeAndType(String relatedTypeKey, String relationTypeKey, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        List<TypeTypeRelationEntity> typeTypeEntities = typeTypeRelationDao.getTypeTypeRelationsByRelatedTypeAndRelationType(relatedTypeKey, relationTypeKey);
        List<TypeTypeRelationInfo> typeTypeRealtionInfo = new ArrayList<TypeTypeRelationInfo>(typeTypeEntities.size());
        for (TypeTypeRelationEntity typeTypeEntity : typeTypeEntities) {
            typeTypeRealtionInfo.add(typeTypeEntity.toDto());
        }
        return typeTypeRealtionInfo;
    }

    
    @Override
    public List<ValidationResultInfo> validateTypeTypeRelation(String validationTypeKey, String typeKey, String typePeerKey, String typeTypeRelationTypeKey, TypeTypeRelationInfo typeTypeRelationInfo,
            ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return new ArrayList<ValidationResultInfo>();
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public TypeTypeRelationInfo createTypeTypeRelation(String typeTypeRelationTypeKey,
            String ownerTypeKey,
            String relatedTypeKey,
            TypeTypeRelationInfo typeTypeRelationInfo,
            ContextInfo contextInfo)
            throws DoesNotExistException, DataValidationErrorException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
        if (!typeTypeRelationTypeKey.equals(typeTypeRelationInfo.getTypeKey())) {
            throw new InvalidParameterException(typeTypeRelationTypeKey + " does not match " + typeTypeRelationInfo.getTypeKey());
        }
        if (!ownerTypeKey.equals(typeTypeRelationInfo.getOwnerTypeKey())) {
            throw new InvalidParameterException(ownerTypeKey + " does not match " + typeTypeRelationInfo.getOwnerTypeKey());
        }
        if (!relatedTypeKey.equals(typeTypeRelationInfo.getRelatedTypeKey())) {
            throw new InvalidParameterException(relatedTypeKey + " does not match " + typeTypeRelationInfo.getRelatedTypeKey());
        }
        TypeTypeRelationEntity entity = new TypeTypeRelationEntity(typeTypeRelationInfo);
        entity.setType(typeTypeRelationTypeKey);
        entity.setOwnerTypeId(ownerTypeKey);
        entity.setRelatedTypeId(relatedTypeKey);
      
        entity.setEntityCreated(contextInfo);
        
        typeTypeRelationDao.persist(entity);
        return entity.toDto();
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public TypeTypeRelationInfo updateTypeTypeRelation(String typeTypeRelationKey, TypeTypeRelationInfo typeTypeRelationInfo, ContextInfo contextInfo) throws DataValidationErrorException,
            DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException, VersionMismatchException {

        TypeTypeRelationEntity entity = typeTypeRelationDao.find(typeTypeRelationKey);
        if (entity == null) {
            throw new DoesNotExistException(typeTypeRelationKey);
        }
        entity.fromDto(typeTypeRelationInfo);

        entity.setEntityUpdated(contextInfo);
        
        typeTypeRelationDao.merge(entity);
        return entity.toDto();

    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo deleteTypeTypeRelation(String typeTypeRelationKey, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        TypeTypeRelationEntity typeEntityToRemove = typeTypeRelationDao.find(typeTypeRelationKey);
        if (typeEntityToRemove == null) {
            throw new DoesNotExistException (typeTypeRelationKey);
        }
        typeTypeRelationDao.remove(typeEntityToRemove);
        StatusInfo deleteStatus = new StatusInfo();
        deleteStatus.setSuccess(true);
        return deleteStatus;
    }

    @Override
    @Transactional(readOnly = true, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public List<String> getRefObjectUris(ContextInfo contextInfo) 
            throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return typeDao.getAllRefObjectUris();

    }

    @Override
    @Transactional(readOnly = true, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public List<TypeInfo> getTypesByRefObjectUri(String refObjectUri, ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        List<TypeEntity> typeEntities = typeDao.getTypesByRefObjectUri(refObjectUri);
        List<TypeInfo> typDTOs = new ArrayList<TypeInfo>(typeEntities.size());
        for (TypeEntity typeEntity : typeEntities) {
            typDTOs.add(typeEntity.toDto());
        }
        return typDTOs;
    }

    @Override
    @Transactional(readOnly = true, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public List<TypeTypeRelationInfo> getTypeTypeRelationsByIds(List<String> typeTypeRelationIds, ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        List<TypeTypeRelationInfo> typeRelationInfos = new ArrayList<TypeTypeRelationInfo>();
        for (String relId : typeTypeRelationIds) {
            typeRelationInfos.add(this.getTypeTypeRelation(relId, contextInfo));
        }
        return typeRelationInfos;
    }
}
