package org.nanotek.brainz.base.entity.immutables;

import java.util.UUID;

public interface BaseTypeEntity
    extends
        NameEntity<String>,
        GidEntity<UUID>
{
    Long childOrder();
    Long parent();
    Long typeId();
}