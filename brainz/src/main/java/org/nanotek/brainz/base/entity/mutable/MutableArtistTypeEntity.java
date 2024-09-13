package org.nanotek.brainz.base.entity.mutable;

import java.util.UUID;

public interface MutableArtistTypeEntity 
extends MutableIdEntity<Long>,
MutableNameEntity<String>,
MutableParentEntity<Long>,
MutableDescriptionEntity<String>,
MutableGidEntity<UUID>{

}
