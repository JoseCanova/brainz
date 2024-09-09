package org.nanotek.brainz.base.entity;

import java.util.Optional;

import org.nanotek.brainz.base.Base;
import org.nanotek.brainz.base.entity.mutable.MutableArtistIdEntity;
import org.nanotek.brainz.base.entity.mutable.MutableArtistNameEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="artist")
public class Artist 
implements Base<Artist>,
MutableArtistIdEntity<Long>,
MutableArtistNameEntity<String>{

	@Id
	private Long artistId;
	
	@Column(name="artistName")
	private String artistName;

	public Artist() {
		super();
	}
	
	public Artist(Long artistId, String artistName) {
		super();
		this.artistId = artistId;
		this.artistName = artistName;
	}

	@Override
	public Long artistId() {
		return artistId;
	}

	@Override
	public Optional<Long> artistId(Long artistId) {
		return Optional.of(this.artistId=artistId);
	}

	@Override
	public String artistName() {
		return this.artistName;
	}

	@Override
	public Optional<String> artistNameEntity(String artistName) {
		return Optional.of(this.artistName = artistName);
	}
	
}
