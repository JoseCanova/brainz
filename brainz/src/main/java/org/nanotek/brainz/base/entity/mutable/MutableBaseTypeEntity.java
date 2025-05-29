package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;
import java.util.UUID;

import org.nanotek.brainz.base.entity.immutables.BaseTypeEntity;

public interface MutableBaseTypeEntity
    extends BaseTypeEntity,
        MutableNameEntity<String>,
        MutableGidEntity<UUID>
{
    Optional<String> tableId(String tableId);
    Optional<Long> childOrder(Long childOrder);
    Optional<Long> parent(Long parent);
    Optional<Long> typeId(Long typeId);
}