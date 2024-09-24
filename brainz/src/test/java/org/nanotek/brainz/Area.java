package org.nanotek.brainz;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.nanotek.brainz.base.entity.mutable.MutableAreaIdEntity;
import org.nanotek.brainz.base.entity.mutable.MutableAreaNameEntity;
import org.nanotek.brainz.base.entity.mutable.MutableGidEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Area implements
MutableAreaIdEntity<Long>,
MutableGidEntity<UUID>,
MutableAreaNameEntity<String>{

	private Long areaId; 
	
	private  UUID gid;
	
	private String areaName;
	
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss[.SSSSSS][.SSSSS][.SSSS][.SSS][.SS][.S]+00")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime lastUpdated;
	
	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", gid=" + gid + ", areaName=" + areaName + ", lastUpdated=" + lastUpdated
				+ "]";
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
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
	public UUID getGid() {
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
