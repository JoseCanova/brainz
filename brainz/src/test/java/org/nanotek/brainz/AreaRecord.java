package org.nanotek.brainz;

import java.util.UUID;

public record AreaRecord(Long areaId , UUID gid , String areaName) {
	
	public AreaRecord(Long areaId , UUID gid , String areaName) {
		this.areaId = areaId; 
		this.gid = gid;
		this.areaName=areaName;
	}
}
