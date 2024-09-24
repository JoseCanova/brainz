package org.nanotek.brainz.base.record;

import java.util.UUID;

import org.nanotek.brainz.base.entity.immutables.AreaEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public record AreaRecord(Long areaId , UUID gid , String areaName) 
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
