package org.nanotek.brainz.base.repository;

import org.nanotek.brainz.base.entity.Area;
import org.nanotek.brainz.base.record.AreaRecord;
import org.nanotek.brainz.base.repository.accessor.AreaIdAccessor;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository 
extends SequenceLongBaseRepository<Area>,
AreaIdAccessor<AreaRecord> {
}