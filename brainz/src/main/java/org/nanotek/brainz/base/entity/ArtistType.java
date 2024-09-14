package org.nanotek.brainz.base.entity;

import java.util.Optional;
import java.util.UUID;

import org.nanotek.brainz.base.Base;
import org.nanotek.brainz.base.entity.mutable.MutableArtistTypeEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="artist_type")
public class ArtistType 
extends NameBaseEntity<ArtistType,Long>
implements
MutableArtistTypeEntity{

	@Column(name="parent")
	private Long parent;
	@Column(name="description",length=2048)
	private String description;
	@Column(name="gid")
	private UUID gid;
	
	
	public ArtistType() {
		super();
	}

	@JsonCreator
	public ArtistType(
			@JsonProperty("typeId") Long typeId, @JsonProperty("name") String name, @JsonProperty("parent") Long parent, @JsonProperty("description") String description,@JsonProperty("gid")UUID gid) {
		this.id=typeId;
		this.name = name;
		this.parent = parent;
		this.description=description;
		this.gid=gid;
	}
	
	@Override
	public Long id() {
		return this.id;
	}
	
	@Override
	public Optional<Long> id(Long typeId) {
		return Optional.of(this.id = typeId);
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
		return Optional.ofNullable(this.parent = t);
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

	@Override
	public String toString() {
		return "ArtistType [typeId=" + id + ", name=" + name + ", parent=" + parent + ", description=" + description
				+ ", gid=" + gid + "]";
	}
	
	
}
