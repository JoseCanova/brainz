package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

public interface MutableNameEntity<T> {

	Optional<T> name(T t);
}
