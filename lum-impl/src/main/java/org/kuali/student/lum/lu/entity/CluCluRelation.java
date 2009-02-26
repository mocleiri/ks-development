package org.kuali.student.lum.lu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.kuali.student.core.entity.AttributeOwner;
import org.kuali.student.core.entity.MetaEntity;

@Entity
@Table(name = "KSLU_CLUCLU_RELTN")
public class CluCluRelation extends MetaEntity implements
		AttributeOwner<CluCluRelationAttribute> {
	
	@Id
	@Column(name="ID")
	private String id;
	
	@ManyToOne
	@JoinColumn(name="CLU_ID")
	private Clu clu;
	
	@ManyToOne
	@JoinColumn(name="RELATED_CLU_ID")
	private Clu relatedClu;
	
	@ManyToOne
	@JoinColumn(name="LU_RELTN_TYPE_ID")
	private LuLuRelationType luLuRelationType;
	
	@Column(name = "CLU_RELTN_REQ")
	private boolean cluRelationRequired;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EFF_DT")
    private Date effectiveDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIR_DT")
	private Date expirationDate;

	@Column(name = "ST")
	private String state;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "OWNER")
	private List<CluCluRelationAttribute> attributes;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Clu getClu() {
		return clu;
	}

	public void setClu(Clu clu) {
		this.clu = clu;
	}

	public Clu getRelatedClu() {
		return relatedClu;
	}

	public void setRelatedClu(Clu relatedClu) {
		this.relatedClu = relatedClu;
	}

	public LuLuRelationType getLuLuRelationType() {
		return luLuRelationType;
	}

	public void setLuLuRelationType(LuLuRelationType luLuRelationType) {
		this.luLuRelationType = luLuRelationType;
	}

	public boolean isCluRelationRequired() {
		return cluRelationRequired;
	}

	public void setCluRelationRequired(boolean cluRelationRequired) {
		this.cluRelationRequired = cluRelationRequired;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public List<CluCluRelationAttribute> getAttributes() {
		if (attributes == null) {
			attributes = new ArrayList<CluCluRelationAttribute>();
		}
		return attributes;
	}

	public void setAttributes(List<CluCluRelationAttribute> attributes) {
		this.attributes = attributes;
	}
}
