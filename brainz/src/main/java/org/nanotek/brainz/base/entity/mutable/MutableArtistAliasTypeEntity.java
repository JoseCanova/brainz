package org.nanotek.brainz.base.entity.mutable;

import java.util.UUID;

import org.nanotek.brainz.base.entity.immutables.ArtistAliasTypeEntity;

public interface MutableArtistAliasTypeEntity
extends ArtistAliasTypeEntity,
MutableTypeIdEntity<Long>,
MutableTypeNameEntity<String>,
MutableParentEntity<Long>,
MutableChildOrderEntity<Long>,
MutableDescriptionEntity<String>,
MutableGidEntity<UUID>{

}
