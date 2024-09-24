package org.nanotek.brainz.base.repository;

import java.util.Collection;

import org.nanotek.brainz.base.entity.Genre;
import org.nanotek.brainz.base.record.GenreRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository
extends JpaRepository<Genre,Long>{
	
	Collection<GenreRecord> findByGenreName(String name);
}
