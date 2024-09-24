package org.nanotek.brainz.base.entity;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.nanotek.brainz.base.entity.mutable.MutableGenreEntity;

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
extends SequenceLongBase<Long>
implements MutableGenreEntity
{

	@Column(name="genreId")
	private Long genreId;
	
	@Column(name="genreName")
	private String genreName;
	
	@Column(name="gid")
	private UUID gid; 
	
	public Genre() {
		super();
	}
	
	@JsonCreator
	public Genre(@JsonProperty("genreId") Long id,
			@JsonProperty("gid")UUID gid,
			@JsonProperty("genreName")String name) {
		this.genreId = id;
		this.gid=gid;
		this.genreName=name;
	}

	@JsonProperty("genreId") 
	public Long genreId() {
		return this.genreId;
	}
	
	public Optional<Long> genreId(Long genreId){
		return Optional.of(this.genreId = genreId);
	}
	
	@JsonProperty("gid") 
	public UUID gid() {
		return gid;
	}
	
	public Optional<UUID> gid(UUID gid){
		return Optional.of(this.gid = gid);
	}

	@JsonProperty("genreName") 
	public String genreName() {
		return this.genreName;
	}
	
	public Optional<String> genreName(String genreName){
		return Optional.of(this.genreName=genreName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(gid, genreId, genreName);
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
		return Objects.equals(gid, other.gid) && Objects.equals(genreId, other.genreId) && Objects.equals(genreName, other.genreName);
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", gid=" + gid + ", name=" + genreName + "]";
	}
	
	
}
