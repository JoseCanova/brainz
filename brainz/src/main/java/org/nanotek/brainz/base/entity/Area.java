package org.nanotek.brainz.base.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="area")
public class Area {
	
	@Id
	private Long areaId;

	private String areaName;

	public Area() {
		super();
	}

	public Area(Long areaId, String areaName) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
	}
	
	public Long areaId() {
		return this.areaId;
	}
	
	public Long areaId(Long areaId) {
		return this.areaId = areaId;
	}
	
	@Column(name="areaName")
	public String areaName() {
		return this.areaName;
	}
	
	public String areaName(String areaName) {
		return this.areaName = areaName;
	}
	
	
}
