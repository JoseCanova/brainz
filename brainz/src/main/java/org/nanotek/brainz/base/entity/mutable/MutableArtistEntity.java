package org.nanotek.brainz.base.entity.mutable;

import org.nanotek.brainz.base.entity.Area;
import org.nanotek.brainz.base.entity.immutables.ArtistEntity;
import org.nanotek.brainz.base.entity.immutables.BaseEntity;

public interface MutableArtistEntity
extends ArtistEntity,
MutableArtistIdEntity<Long>,
MutableArtistNameEntity<String>,
BaseEntity<Area>{
}
