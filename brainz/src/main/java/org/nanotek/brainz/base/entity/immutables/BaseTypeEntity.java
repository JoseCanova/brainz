package org.nanotek.brainz.base.entity.immutables;

import java.util.UUID;

public interface BaseTypeEntity
    extends
        IdEntity<Long>,
        NameEntity<String>,
        GidEntity<UUID>
{
    String tableId();
    Long childOrder();
    Long parent();
    Long typeId();
}