package org.nanotek.brainz.base.entity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;

@Entity
public class AreaType extends BaseType{

	private static final long serialVersionUID = -2110125833465751521L;

	public AreaType() {
		super();
	}
	
	@JsonCreator
	public AreaType(  @JsonProperty("gid") UUID gid,
            @JsonProperty("name") String name,
            @JsonProperty("childOrder") Long childOrder,
            @JsonProperty("parent") Long parent,
            @JsonProperty("typeId") Long typeId) {
		super(gid, name, childOrder, parent, typeId);
		System.err.println("called constructor");
    }{
	}
	
}
