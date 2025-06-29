package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

public interface MutableDescriptionEntity<T> 
{
	Optional<T> description(T description);
}
