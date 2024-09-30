package org.nanotek.brainz.base.repository.accessor;

import java.util.Optional;

public interface GenreNameAccessor<T> {

	Optional<T> findByGenreName(String genreName);
	
}
