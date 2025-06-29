package org.nanotek.brainz.base.entity;

import java.util.Optional;
import java.util.UUID;

import org.nanotek.brainz.base.entity.immutables.DescriptionEntity;
import org.nanotek.brainz.base.entity.mutable.MutableDescriptionEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class ArtistType extends BaseType 
implements DescriptionEntity<String>, MutableDescriptionEntity<String> {


    private static final long serialVersionUID = -6745690141673459521L;
    
	@Column(name="description" , columnDefinition = "VARCHAR" , nullable=true)
    private String description;
    
    public ArtistType() {
        super();
    }

    @JsonCreator
    public ArtistType(
            @JsonProperty("gid") UUID gid,
            @JsonProperty("typeName") String name,
            @JsonProperty("childOrder") Long childOrder,
            @JsonProperty("parent") Long parent,
            @JsonProperty("typeId") Long typeId,
            @JsonProperty("description") String description) {
        super(gid, name, childOrder, parent, typeId);
        this.description = description;
    }

	@Override
	@JsonProperty(value="description")
	public String description() {
		return description;
	}

    @Override
    public Optional<String> description(String description) {
        this.description = description;
        return Optional.ofNullable(this.description);
    }
	
	@Override
	public String toString() {
		return super.toString() + ", description=" + description + "]";
	}
}