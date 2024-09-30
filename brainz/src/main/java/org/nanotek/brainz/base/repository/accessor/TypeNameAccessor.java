package org.nanotek.brainz.base.repository.accessor;

import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.TypeNameEntity;

public interface TypeNameAccessor<S extends TypeNameEntity<String>>{

	 Optional<S> findByTypeName(String typeName);

 	
}
