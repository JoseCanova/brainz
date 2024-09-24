package org.nanotek.brainz.base.record;

import java.util.UUID;

import org.nanotek.brainz.base.entity.immutables.GenreEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@JsonIgnoreProperties(ignoreUnknown = true)
public record GenreRecord
(@NotNull Long genreId, @NotNull UUID gid , @NotEmpty String genreName) 
implements 
GenreEntity{
	
	@JsonCreator
	public GenreRecord(@JsonProperty("id") Long genreId,
			@JsonProperty("gid")UUID gid,
			@JsonProperty("genreName")String genreName) {
		this.genreId = genreId;
		this.gid=gid;
		this.genreName=genreName;
	}
}
