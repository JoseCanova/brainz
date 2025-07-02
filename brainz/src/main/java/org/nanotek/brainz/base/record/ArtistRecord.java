package org.nanotek.brainz.base.record;

import org.nanotek.brainz.base.entity.immutables.ArtistEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ArtistRecord(@NotNull Long artistId , @NotNull @NotEmpty String artistName) 
implements ArtistEntity{

	@JsonCreator
	public ArtistRecord(
			@JsonProperty(value="artistId") Long artistId , 
			@JsonProperty(value="artistName")String artistName) {
		this.artistId=artistId;
		this.artistName = artistName;
	}
}
