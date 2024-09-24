package org.nanotek.brainz.base.entity;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.nanotek.brainz.base.entity.mutable.MutableAreaEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="area")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Area 
extends SequenceLongBase<Long>
implements
MutableAreaEntity{

	@Column(name="areaId")
	private Long areaId; 
	
	@Column(name="gid")
	private  UUID gid;
	
	@Column(name="areaName")
	private String areaName;
	
	
	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", gid=" + gid + ", areaName=" + areaName + 
				"]";
	}

	public Area() {
		super();
	}
	
	public Area(Long areaId, UUID gid, String areaName) {
		super();
		this.areaId = areaId;
		this.gid = gid;
		this.areaName = areaName;
	}


	@JsonProperty(value="areaId")
	public Long areaId() {
		return areaId;
	}

	public Optional<Long> areaId(Long areaId) {
		return Optional.of(this.areaId = areaId);
	}

	@JsonProperty(value="gid")
	public UUID gid() {
		return gid;
	}

	public Optional<UUID> gid(UUID gid) {
	   return Optional.of(	this.gid = gid);
	}

	@JsonProperty(value="areaName")
	public String areaName() {
		return areaName;
	}

	public Optional<String> areaName(String areaName) {
		return Optional.of(this.areaName = areaName);
	}

}
