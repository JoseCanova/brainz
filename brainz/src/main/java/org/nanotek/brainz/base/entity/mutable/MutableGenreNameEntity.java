package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

public interface MutableGenreNameEntity<T> {

	Optional<T> genreName(T genreName);
	
}
