package org.nanotek.brainz.base.repository.accessor;

import java.io.Serializable;
import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.TypeNameEntity;

public interface TypeNameAccessor<K extends Serializable>{

	<S extends TypeNameEntity<K>> Optional<S> findByTypeName(K typeName);

 	
}
