package org.nanotek.brainz.base.entity;

import java.util.Optional;
import java.util.UUID;

import org.nanotek.brainz.base.entity.mutable.MutableArtistAliasTypeEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="artist_alias_type")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistAliasType <K extends ArtistAliasType<K>> 
extends SequenceLongBase<Long>
implements MutableArtistAliasTypeEntity
{
	@Column(name="typeId")
	private Long typeId;
	
	@Column(name="typeName")
	private String typeName;
	
	@Column(name="parent")
	private Long parent; 
	
	@Column(name="childOrder")
	private Long childOrder;
	
	@Column(name="description")
	private String description;
	
	@Column(name="gid")
	private UUID gid;
	
	public ArtistAliasType() {
		super();
	}
	
	public ArtistAliasType(
			@JsonProperty(value = "typeId") Long typeId ,
			@JsonProperty(value = "typeName") String typeName,
			@JsonProperty(value = "parent") Long parent,
			@JsonProperty(value = "childOrder")Long childOrder,
			@JsonProperty(value = "description") String description,
			@JsonProperty(value = "gid")UUID gid) {
		this.typeId=typeId;
		this.typeName=typeName;
		this.parent = parent;
		this.childOrder=childOrder;
		this.description=description;
		this.gid = gid;
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
	public String typeName() {
		return this.typeName;
	}

	@Override
	public  Optional<String> typeName(String typeName) {
		return Optional.of(this.typeName=typeName);
	}

	@Override
	public Long parent() {
		return this.parent;
	}

	@Override
	public Optional<Long> parent(Long t) {
		return Optional.of(this.parent=t);
	}

	@Override
	public Long childOrder() {
		return this.childOrder;
	}

	@Override
	public  Optional<Long> childOrder(Long childOrder) {
		return Optional.of(this.childOrder = childOrder);
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
		return "ArtistAliasType [typeId=" + typeId + ", typeName=" + typeName + ", parent=" + parent + ", childOrder="
				+ childOrder + ", description=" + description + ", gid=" + gid + "]";
	}
	
	
}
