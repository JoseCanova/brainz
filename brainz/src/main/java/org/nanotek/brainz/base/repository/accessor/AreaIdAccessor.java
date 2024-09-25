package org.nanotek.brainz.base.repository.accessor;

import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.AreaEntity;

public interface AreaIdAccessor<T extends AreaEntity> {

	 Optional<T> findByAreaId(Long areaId);
	
}
