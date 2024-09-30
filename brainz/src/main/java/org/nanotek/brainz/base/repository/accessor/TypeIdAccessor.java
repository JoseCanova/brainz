package org.nanotek.brainz.base.repository.accessor;

import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.TypeIdEntity;

public interface TypeIdAccessor<S extends TypeIdEntity<Long>> {

	Optional<S> findByTypeId(Long typeId);

}
