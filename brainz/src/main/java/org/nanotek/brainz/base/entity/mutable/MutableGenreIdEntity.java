package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

public interface MutableGenreIdEntity<T> {

	Optional<T> genreId(T genreId);
	
}
