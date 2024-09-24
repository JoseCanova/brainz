package org.nanotek.brainz.base.entity;

import java.util.Optional;

import org.nanotek.brainz.base.entity.mutable.MutableArtistEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="artist")
public class Artist 
extends SequenceLongBase<Long>
implements 
MutableArtistEntity{

	@Column(name="artistId")
	private Long artistId;
	
	@Column(name="artistName")
	private String artistName;

	public Artist() {
		super();
	}
	
	@JsonCreator
	public Artist(@JsonProperty(value="artistId") Long artistId, 
			@JsonProperty(value="artistName") String artistName) {
		super();
		this.artistId = artistId;
		this.artistName = artistName;
	}

	@JsonProperty(value="artistId")
	@Override
	public Long artistId() {
		return artistId;
	}

	@Override
	public Optional<Long> artistId(Long artistId) {
		return Optional.of(this.artistId=artistId);
	}

	@JsonProperty(value="artistName")
	@Override
	public String artistName() {
		return this.artistName;
	}

	@Override
	public Optional<String> artistName(String artistName) {
		return Optional.of(this.artistName = artistName);
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", artistName=" + artistName + "]";
	}
	
	
	
}
