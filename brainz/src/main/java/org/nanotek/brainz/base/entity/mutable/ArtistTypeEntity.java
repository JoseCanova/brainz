package org.nanotek.brainz.base.entity.mutable;

import java.util.UUID;

public interface ArtistTypeEntity 
extends MutableIdEntity<Long>,
MutableNameEntity<String>,
MutableParentEntity<Long>,
MutableDescriptionEntity<String>,
MutableGidEntity<UUID>{

}
