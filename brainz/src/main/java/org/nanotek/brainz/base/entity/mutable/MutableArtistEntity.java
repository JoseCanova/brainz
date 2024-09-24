package org.nanotek.brainz.base.entity.mutable;

import org.nanotek.brainz.base.entity.immutables.ArtistEntity;

public interface MutableArtistEntity
extends ArtistEntity,
MutableArtistIdEntity<Long>,
MutableArtistNameEntity<String>{

}
