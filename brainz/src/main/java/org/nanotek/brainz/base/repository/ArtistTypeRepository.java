package org.nanotek.brainz.base.repository;

import org.nanotek.brainz.base.entity.ArtistType;
import org.nanotek.brainz.base.record.ArtistTypeRecord;
import org.nanotek.brainz.base.repository.accessor.TypeIdAccessor;
import org.nanotek.brainz.base.repository.accessor.TypeNameAccessor;
import org.springframework.stereotype.Repository;


@Repository
public interface ArtistTypeRepository extends
TypeIdAccessor<ArtistTypeRecord> , TypeNameAccessor<ArtistTypeRecord>,
SequenceLongBaseRepository<ArtistType> {

}
