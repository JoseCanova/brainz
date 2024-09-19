package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

public interface MutableGidEntity<T> {

	Optional<T> gid(T t);
}
