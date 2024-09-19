package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

public interface MutableParentEntity<T> 
{

	Optional<T> parent(T t);
	
}
