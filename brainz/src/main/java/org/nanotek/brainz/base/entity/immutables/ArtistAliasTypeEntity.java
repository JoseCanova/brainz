package org.nanotek.brainz.base.entity.immutables;

import java.util.UUID;

public interface ArtistAliasTypeEntity extends 
TypeIdEntity<Long>,
TypeNameEntity<String>,
ParentEntity<Long>,
ChildOrderEntity<Long>,
DescriptionEntity<String>,
GidEntity<UUID>{

}
