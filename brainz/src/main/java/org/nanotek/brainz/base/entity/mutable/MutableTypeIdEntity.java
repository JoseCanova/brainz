package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

public interface MutableTypeIdEntity<T> 
{

	Optional<T> typeId(T typeId);
}
