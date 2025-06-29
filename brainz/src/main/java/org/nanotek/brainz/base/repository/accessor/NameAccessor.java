package org.nanotek.brainz.base.repository.accessor;

import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.NameEntity;

public interface NameAccessor<S extends NameEntity<String>>{

	 Optional<S> findByName(String typeName);

 	
}
