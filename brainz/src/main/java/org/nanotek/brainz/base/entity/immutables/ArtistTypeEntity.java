package org.nanotek.brainz.base.entity.immutables;

import java.util.UUID;

public interface ArtistTypeEntity 
extends TypeIdEntity<Long>,
TypeNameEntity<String>,
ParentEntity<Long>,
DescriptionEntity<String>,
GidEntity<UUID>{

}
