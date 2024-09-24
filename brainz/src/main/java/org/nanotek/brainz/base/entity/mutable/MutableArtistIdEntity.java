package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

public interface MutableArtistIdEntity<K> 
{
	Optional<K> artistId(K artistId);
}
