package org.nanotek.brainz.base.entity;

import java.util.Optional;

import org.nanotek.brainz.base.entity.mutable.MutableArtistIdEntity;
import org.nanotek.brainz.base.entity.mutable.MutableArtistNameEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="artist")
public class Artist 
implements MutableArtistIdEntity<Long>,
MutableArtistNameEntity<String>{

	private Long artistId;
	
	private String artistName;

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
