package org.nanotek.brainz.base.repository.accessor;

import java.util.Optional;

public interface GenreIdAccessor<T> {

	Optional<T> findByGenreId(Long genreId);
	
}
