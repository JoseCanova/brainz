package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.NameEntity;

public interface MutableNameEntity<T> extends NameEntity<T>{

	Optional<T> name(T t);
}
