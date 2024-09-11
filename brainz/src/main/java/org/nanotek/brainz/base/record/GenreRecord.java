package org.nanotek.brainz.base.record;

import java.util.UUID;

import org.nanotek.brainz.base.entity.immutables.GidEntity;
import org.nanotek.brainz.base.entity.immutables.IdEntity;
import org.nanotek.brainz.base.entity.immutables.NameEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public record GenreRecord(Long id, UUID gid , String name) 
implements IdEntity<Long> , GidEntity<UUID>,NameEntity<String>{
	
	@JsonCreator
	public GenreRecord(@JsonProperty("id") Long id,
			@JsonProperty("gid")UUID gid,
			@JsonProperty("name")String name) {
		this.id = id;
		this.gid=gid;
		this.name=name;
	}
}
