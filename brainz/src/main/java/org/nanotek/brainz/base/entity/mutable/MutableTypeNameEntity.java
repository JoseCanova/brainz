package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

public interface MutableTypeNameEntity<T> 
{

	<S extends T> Optional<S> typeName(T typeName);
	
}
