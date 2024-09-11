package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.GidEntity;

public interface MutableGidEntity<T> extends GidEntity<T>{

	Optional<T> gid(T t);
}
