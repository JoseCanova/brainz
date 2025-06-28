package org.nanotek.brainz.base.record;

import java.util.UUID;

import org.nanotek.brainz.base.entity.immutables.BaseTypeEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BaseTypeRecord(
    @JsonProperty("id") Long id,
    @JsonProperty("tableId") String tableId,
    @JsonProperty("gid") UUID gid,
    @JsonProperty("typeName") String name,
    @JsonProperty("childOrder") Long childOrder,
    @JsonProperty("parent") Long parent,
    @JsonProperty("typeId") Long typeId
) implements BaseTypeEntity {

    @JsonCreator
    public BaseTypeRecord(
        @JsonProperty("id") Long id,
        @JsonProperty("tableId") String tableId,
        @JsonProperty("gid") UUID gid,
        @JsonProperty("typeName") String name,
        @JsonProperty("childOrder") Long childOrder,
        @JsonProperty("parent") Long parent,
        @JsonProperty("typeId") Long typeId
    ) {
        this.id = id;
        this.tableId = tableId;
        this.gid = gid;
        this.name = name;
        this.childOrder = childOrder;
        this.parent = parent;
        this.typeId = typeId;
    }
}