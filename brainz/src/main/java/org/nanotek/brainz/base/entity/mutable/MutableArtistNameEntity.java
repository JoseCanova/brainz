package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

public interface MutableArtistNameEntity<K> 
{
	Optional<K> artistName(K artistName);
}
