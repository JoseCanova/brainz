package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.ArtistIdEntity;

public interface MutableArtistIdEntity<K> 
extends ArtistIdEntity<K>{
	
	Optional<K> artistId(K artistId);

}
