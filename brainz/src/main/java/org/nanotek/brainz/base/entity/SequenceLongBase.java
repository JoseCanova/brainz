package org.nanotek.brainz.base.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

import org.nanotek.brainz.base.Base;
import org.nanotek.brainz.base.entity.immutables.BaseSequenceLongBaseEntity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;

@MappedSuperclass
//@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class)
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SequenceLongBase
<ID extends Serializable>
implements  BaseSequenceLongBaseEntity<SequenceLongBase<ID>, ID>{

	private static final long serialVersionUID = 1932266128563675834L;
	
	@Id
	@org.springframework.data.annotation.Id
	@NotNull(groups = {Default.class})
	@Column(name="id",nullable=false,unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)//,generator="sequence_id_seq")
	//@SequenceGenerator(name = "sequence_id_seq", sequenceName = "sequence_id_seq",allocationSize = 1, initialValue= 1)
	protected ID id;

	public SequenceLongBase() {
		super();
	}
	
	public SequenceLongBase(ID id) {
		this.id = id;
	}
	
	public ID getId() {
		return this.id;
	}

	public void setId(ID id) {
		this.id = id;
	}
	
	@Override
	public int compareTo(SequenceLongBase<ID> to) {
		return withUUID().compareTo(to.withUUID());
	}
	
	@Override
	public boolean equals(Object obj) {
			boolean b = Optional.ofNullable(obj).isPresent();
			if (b) {
				SequenceLongBase<ID> theBase = this.getClass().cast(obj);
				return this.compareTo(theBase) == 0;}
			return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
