package org.nanotek.brainz.base.entity;

import java.util.Optional;
import java.util.UUID;

import org.nanotek.brainz.base.entity.mutable.MutableArtistTypeEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="artist_type")
public class ArtistType 
extends SequenceLongBase<Long>
implements
MutableArtistTypeEntity{

	@Column(name="typeId")
	private Long typeId;
	
	@Column(name="typeName")
	private String typeName;
	
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
			@JsonProperty("typeId") Long typeId, 
			@JsonProperty("typeName") String name,
			@JsonProperty("parent") Long parent, 
			@JsonProperty("description") String description,
			@JsonProperty("gid")UUID gid) {
		this.typeId=typeId;
		this.typeName = name;
		this.parent = parent;
		this.description=description;
		this.gid=gid;
	}
	
	@Override
	@JsonProperty("typeId")
	public Long typeId() {
		return this.id;
	}
	
	@Override
	public Optional<Long> typeId(Long typeId) {
		return Optional.of(this.typeId = typeId);
	}
	
	
	@Override
	@JsonProperty("typeName")
	public String typeName() {
		return this.typeName;
	}
	@Override
	public Optional<String> typeName(String t) {
		return Optional.of(this.typeName = t);
	}

	@Override
	@JsonProperty("parent") 
	public Long parent() {
		return this.parent;
	}

	@Override
	public Optional<Long> parent(Long t) {
		return Optional.ofNullable(this.parent = t);
	}

	@Override
	@JsonProperty("description") 
	public String description() {
		return this.description;
	}

	@Override
	public Optional<String> description(String description) {
		return Optional.of(this.description=description);
	}

	@Override
	@JsonProperty("gid") 
	public UUID gid() {
		return this.gid;
	}

	@Override
	public Optional<UUID> gid(UUID t) {
		return Optional.of(this.gid=t);
	}

	@Override
	public String toString() {
		return "ArtistType [typeId=" + typeId + ", name=" + typeName + ", parent=" + parent + ", description=" + description
				+ ", gid=" + gid + "]";
	}
	
	
}
