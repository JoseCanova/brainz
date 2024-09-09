package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.ArtistNameEntity;

public interface MutableArtistNameEntity<K> 
extends ArtistNameEntity<K>{
	
	Optional<K> artistNameEntity(K artistName);

}
