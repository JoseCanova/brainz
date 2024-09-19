package org.nanotek.brainz.base.entity.mutable;

import java.util.Optional;

public interface MutableChildOrderEntity<T> 
{

	
	<S extends T> Optional<S>childOrder(T childOrder);
}
