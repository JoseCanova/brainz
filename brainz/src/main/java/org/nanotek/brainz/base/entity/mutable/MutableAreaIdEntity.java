package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

import org.nanotek.brainz.base.entity.immutables.AreaIdEntity;

public interface MutableAreaIdEntity <K> extends AreaIdEntity<K>{

	public Optional<K> areaId(K areaId);
	
}
