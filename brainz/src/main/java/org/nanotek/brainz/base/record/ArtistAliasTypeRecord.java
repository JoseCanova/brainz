package org.nanotek.brainz.base.record;

import java.util.UUID;

import org.nanotek.brainz.base.entity.immutables.ArtistAliasTypeEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ArtistAliasTypeRecord
(
		@JsonProperty(value = "typeId") Long typeId , 
		@JsonProperty(value = "typeName") String typeName,
		@JsonProperty(value = "parent") Long parent, 
		@JsonProperty(value = "childOrder")Long childOrder,
		@JsonProperty(value = "description") String description,
		@JsonProperty(value = "gid")UUID gid
	    	  ) 
implements ArtistAliasTypeEntity{

}
