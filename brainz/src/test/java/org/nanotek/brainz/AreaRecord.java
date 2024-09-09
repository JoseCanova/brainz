package org.nanotek.brainz;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public record AreaRecord(Long areaId , UUID gid , String areaName) {
	
	public AreaRecord(Long areaId , UUID gid , String areaName) {
		this.areaId = areaId; 
		this.gid = gid;
		this.areaName=areaName;
	}

	@Override
	public String toString() {
		return "AreaRecord [areaId=" + areaId + ", gid=" + gid + ", areaName=" + areaName + "]";
	}
	
	
}
