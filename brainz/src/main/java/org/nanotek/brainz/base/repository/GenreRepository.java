package org.nanotek.brainz.base.repository;

import org.nanotek.brainz.base.entity.Genre;
import org.nanotek.brainz.base.record.GenreRecord;
import org.nanotek.brainz.base.repository.accessor.GenreIdAccessor;
import org.nanotek.brainz.base.repository.accessor.GenreNameAccessor;

public interface GenreRepository
extends SequenceLongBaseRepository<Genre>,
GenreIdAccessor<GenreRecord>,
GenreNameAccessor<GenreRecord>{
}
