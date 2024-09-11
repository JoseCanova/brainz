package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.IdEntity;

public interface MutableIdEntity<T> extends IdEntity<T>{

	Optional<T> id(T t);
}
