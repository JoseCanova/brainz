package org.nanotek.brainz.base.record;

import java.util.UUID;

import org.nanotek.brainz.base.entity.immutables.AreaEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown=true)
public record AreaRecord(
		@NotNull Long areaId, 
		@NotNull UUID gid, 
		@NotNull @NotEmpty String areaName) 
implements AreaEntity{
	
	@JsonCreator
	public AreaRecord(@JsonProperty(value="areaId")Long areaId ,
				@JsonProperty(value="gid")	UUID gid ,
				@JsonProperty(value="areaName")   String areaName) {
		this.areaId = areaId; 
		this.gid = gid;
		this.areaName=areaName;
	}

	@Override
	public String toString() {
		return "AreaRecord [areaId=" + areaId + ", gid=" + gid + ", areaName=" + areaName + "]";
	}
	
	
}
