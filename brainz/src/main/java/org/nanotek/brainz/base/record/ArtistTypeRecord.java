package org.nanotek.brainz.base.record;

import java.util.UUID;

import org.nanotek.brainz.base.entity.immutables.ArtistTypeEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ArtistTypeRecord
(Long typeId,String typeName,Long parent,String description,UUID gid) 
implements ArtistTypeEntity{

	@JsonCreator
	public ArtistTypeRecord(
			@JsonProperty("typeId") Long typeId, 
			@JsonProperty("name") String typeName, 
			@JsonProperty("parent") Long parent, 
			@JsonProperty("description") String description,
			@JsonProperty("gid")UUID gid) {
		this.typeId=typeId;
		this.typeName = typeName;
		this.parent = parent;
		this.description=description;
		this.gid=gid;
	}
	
}
