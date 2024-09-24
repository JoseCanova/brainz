package org.nanotek.brainz.base.repository;

import java.util.Collection;

import org.nanotek.brainz.base.entity.Genre;
import org.nanotek.brainz.base.record.GenreRecord;

public interface GenreRepository
extends SequenceLongBaseRepository<Genre>{
	
	Collection<GenreRecord> findByGenreName(String name);
}
