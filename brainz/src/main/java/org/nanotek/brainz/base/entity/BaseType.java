package org.nanotek.brainz.base.entity;

import java.util.Optional;
import java.util.UUID;

import org.nanotek.brainz.base.entity.mutable.MutableBaseTypeEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "base_type")
@JsonIgnoreProperties(ignoreUnknown = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
	    discriminatorType = DiscriminatorType.STRING,
	    name = "table_id",
	    columnDefinition = "VARCHAR"
	)
public class BaseType
extends SequenceLongBase<Long>
implements MutableBaseTypeEntity {

    private static final long serialVersionUID = 4585346867579914943L;

    @Column(name = "gid", nullable = false)
    private UUID gid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "childOrder")
    private Long childOrder;

    @Column(name = "parent")
    private Long parent;

    @Column(name = "type_id", nullable = false)
    private Long typeId;

    public BaseType() {
        super();
    }

    @JsonCreator
    public BaseType(
            @JsonProperty("gid") UUID gid,
            @JsonProperty("name") String name,
            @JsonProperty("childOrder") Long childOrder,
            @JsonProperty("parent") Long parent,
            @JsonProperty("typeId") Long typeId) {
        super();
        this.gid = gid;
        this.name = name;
        this.childOrder = childOrder;
        this.parent = parent;
        this.typeId = typeId;
    }

    @JsonProperty("gid")
    public UUID gid() {
        return gid;
    }

    public Optional<UUID> gid(UUID gid) {
        return Optional.of(this.gid = gid);
    }

    @JsonProperty("name")
    public String name() {
        return name;
    }

    public Optional<String> name(String name) {
        return Optional.of(this.name = name);
    }

    @JsonProperty("childOrder")
    public Long childOrder() {
        return childOrder;
    }

    public Optional<Long> childOrder(Long childOrder) {
        return Optional.of(this.childOrder = childOrder);
    }

    @JsonProperty("parent")
    public Long parent() {
        return parent;
    }

    public Optional<Long> parent(Long parent) {
        return Optional.of(this.parent = parent);
    }

    @JsonProperty("typeId")
    public Long typeId() {
        return typeId;
    }

    public Optional<Long> typeId(Long typeId) {
        return Optional.of(this.typeId = typeId);
    }

    @Override
    public String toString() {
        return "BaseType [gid=" + gid + ", name=" + name +
                ", childOrder=" + childOrder + ", parent=" + parent + ", typeId=" + typeId + "]";
    }
}