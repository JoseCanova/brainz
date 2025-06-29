package org.nanotek.brainz.base.repository.accessor;

import java.util.List;

import org.nanotek.brainz.base.entity.immutables.NameEntity;

public interface NameAccessor<S extends NameEntity<T> , T>{

	 List<S> findByName(T typeName);

 	
}
