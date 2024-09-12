package org.nanotek.brainz.base.entity;

import java.util.Optional;
import java.util.UUID;

import org.nanotek.brainz.base.Base;
import org.nanotek.brainz.base.entity.mutable.MutableDescriptionEntity;
import org.nanotek.brainz.base.entity.mutable.MutableGidEntity;
import org.nanotek.brainz.base.entity.mutable.MutableNameEntity;
import org.nanotek.brainz.base.entity.mutable.MutableParentEntity;
import org.nanotek.brainz.base.entity.mutable.MutableTypeIdEntity;

import com.fasterxml.jackson.annotation.JsonCreator;


public class ArtistType 
implements Base<ArtistType> ,
 MutableTypeIdEntity<Long>,
 MutableNameEntity<String>,
 MutableParentEntity<Long>,
 MutableDescriptionEntity<String>,
 MutableGidEntity<UUID>{

	
	private Long typeId;
	private String name;
	private Long parent;
	private String description;
	private UUID gid;
	
	@JsonCreator
	public ArtistType(Long typeId,String name,Long parent,String description,UUID gid) {
		this.typeId=typeId;
		this.name = name;
		this.parent = parent;
		this.description=description;
		this.gid=gid;
	}
	
	@Override
	public Long typeId() {
		return this.typeId;
	}
	
	@Override
	public Optional<Long> typeId(Long typeId) {
		return Optional.of(this.typeId = typeId);
	}
	
	
	@Override
	public String name() {
		return this.name;
	}
	@Override
	public Optional<String> name(String t) {
		return Optional.of(this.name = t);
	}

	@Override
	public Long parent() {
		return this.parent;
	}

	@Override
	public Optional<Long> parent(Long t) {
		return Optional.of(this.parent = t);
	}

	@Override
	public String description() {
		return this.description;
	}

	@Override
	public Optional<String> description(String description) {
		return Optional.of(this.description=description);
	}

	@Override
	public UUID gid() {
		return this.gid;
	}

	@Override
	public Optional<UUID> gid(UUID t) {
		return Optional.of(this.gid=t);
	}
	
	
	
}
