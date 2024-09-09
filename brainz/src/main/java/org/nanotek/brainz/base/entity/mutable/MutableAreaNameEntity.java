package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.AreaNameEntity;

public interface MutableAreaNameEntity<K> extends AreaNameEntity<K> {

	 Optional<K> areaName(K areaName);
	
}
