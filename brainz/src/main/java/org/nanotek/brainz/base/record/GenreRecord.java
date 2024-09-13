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
(@NotNull Long id, @NotNull UUID gid , @NotEmpty String name) 
implements 
GenreEntity{
	
	@JsonCreator
	public GenreRecord(@JsonProperty("id") Long id,
			@JsonProperty("gid")UUID gid,
			@JsonProperty("name")String name) {
		this.id = id;
		this.gid=gid;
		this.name=name;
	}
}
