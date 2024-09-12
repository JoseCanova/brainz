package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.ParentEntity;

public interface MutableParentEntity<T> 
extends ParentEntity<T>{

	Optional<T> parent(T t);
	
}
