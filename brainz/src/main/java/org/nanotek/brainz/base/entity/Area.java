package org.nanotek.brainz.base.entity;

import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.AreaEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="area")
public class Area implements 
AreaEntity{
	
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
	
	public Optional<Long> areaId(Long areaId) {
		return Optional.of(this.areaId = areaId);
	}
	
	@Column(name="areaName")
	public String areaName() {
		return this.areaName;
	}
	
	public Optional<String> areaName(String areaName) {
		return Optional.of(this.areaName = areaName);
	}
	
	
}
