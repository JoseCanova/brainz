package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.DescriptionEntity;

public interface MutableDescriptionEntity<T> 
extends DescriptionEntity<T>{

	Optional<T> description(T description);
}
