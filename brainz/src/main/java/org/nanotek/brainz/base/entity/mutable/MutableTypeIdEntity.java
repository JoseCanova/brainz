package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.TypeIdEntity;

public interface MutableTypeIdEntity<T> 
extends TypeIdEntity<T>{

	Optional<T> typeId(T typeId);
}
