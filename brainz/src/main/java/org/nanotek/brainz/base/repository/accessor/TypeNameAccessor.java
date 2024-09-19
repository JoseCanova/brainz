package org.nanotek.brainz.base.repository.accessor;

import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.TypeNameEntity;

public interface TypeNameAccessor{

	<S extends TypeNameEntity<?>> Optional<S> findByTypeName(String typeName);

 	
}
