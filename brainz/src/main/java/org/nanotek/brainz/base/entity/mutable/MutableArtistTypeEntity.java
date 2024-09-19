package org.nanotek.brainz.base.entity.mutable;

import java.util.UUID;

import org.nanotek.brainz.base.entity.immutables.ArtistTypeEntity;

public interface MutableArtistTypeEntity 
extends ArtistTypeEntity , 
MutableIdEntity<Long>,
MutableNameEntity<String>,
MutableParentEntity<Long>,
MutableDescriptionEntity<String>,
MutableGidEntity<UUID>{

}
