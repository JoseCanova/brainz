package org.nanotek.brainz.base.record;

import java.util.UUID;

import org.nanotek.brainz.base.entity.immutables.DescriptionEntity;
import org.nanotek.brainz.base.entity.immutables.GidEntity;
import org.nanotek.brainz.base.entity.immutables.NameEntity;
import org.nanotek.brainz.base.entity.immutables.ParentEntity;
import org.nanotek.brainz.base.entity.immutables.TypeIdEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ArtistTypeRecord
(Long typeId,String name,Long parent,String description,UUID gid) 
implements TypeIdEntity<Long>,
NameEntity<String>,
ParentEntity<Long>,
DescriptionEntity<String>,
GidEntity<UUID>{

	@JsonCreator
	public ArtistTypeRecord(Long typeId,String name,Long parent,String description,UUID gid) {
		this.typeId=typeId;
		this.name = name;
		this.parent = parent;
		this.description=description;
		this.gid=gid;
	}
	
}
