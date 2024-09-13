package org.nanotek.brainz.base.entity;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.nanotek.brainz.base.entity.mutable.MutableGidEntity;
import org.nanotek.brainz.base.entity.mutable.MutableIdEntity;
import org.nanotek.brainz.base.entity.mutable.MutableNameEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="genre")
public class Genre 
extends BaseEntity<Genre,Long>
implements 
MutableIdEntity<Long>,
MutableGidEntity<UUID>,
MutableNameEntity<String>{

	@Column(name="gid")
	private UUID gid; 
	
	@Column(name="genreName",length=1024)
	private String name;

	
	public Genre() {
		super();
	}
	
	@JsonCreator
	public Genre(@JsonProperty("id") Long id,
			@JsonProperty("gid")UUID gid,
			@JsonProperty("name")String name) {
		this.id = id;
		this.gid=gid;
		this.name=name;
	}

	public Long id() {
		return this.id;
	}
	
	public Optional<Long> id(Long id){
		return Optional.of(this.id = id);
	}
	
	public UUID gid() {
		return gid;
	}
	
	public Optional<UUID> gid(UUID gid){
		return Optional.of(this.gid = gid);
	}
	
	public String name() {
		return this.name;
	}
	
	public Optional<String> name(String name){
		return Optional.of(this.name=name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(gid, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		return Objects.equals(gid, other.gid) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", gid=" + gid + ", name=" + name + "]";
	}
	
	
}
