package org.nanotek.brainz.base.record;

import java.util.UUID;

import org.nanotek.brainz.base.entity.immutables.ArtistAliasTypeEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ArtistAliasTypeRecord
(
		@NotNull Long typeId , 
		@NotNull @NotEmpty String typeName,
		@Nullable Long parent, 
		@Nullable Long childOrder,
		@JsonProperty(value = "description") String description,
		@JsonProperty(value = "gid")UUID gid
	    	  ) 
implements ArtistAliasTypeEntity{
	
	@JsonCreator
	public ArtistAliasTypeRecord(
			@JsonProperty(value = "typeId") Long typeId, 
			@JsonProperty(value = "typeName") String typeName,
			@JsonProperty(value = "parent") Long parent, 
			@JsonProperty(value = "childOrder") Long childOrder,
			@JsonProperty(value = "description") String description,
			@JsonProperty(value = "gid") UUID gid) {
		this.typeId = typeId;
		this.typeName = typeName;
		this.parent = parent;
		this.childOrder = childOrder;
		this.description = description;
		this.gid = gid;
	}

}
