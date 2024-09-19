package org.nanotek.brainz.base.repository.accessor;

import java.io.Serializable;
import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.TypeIdEntity;

public interface TypeIdAccessor<K extends Serializable> {

	<S extends TypeIdEntity<K>> Optional<S> findByTypeId(K typeId);

}
