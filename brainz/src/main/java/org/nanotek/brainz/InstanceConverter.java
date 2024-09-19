package org.nanotek.brainz;

public interface InstanceConverter {

	<K,S extends K> S convertValue( Object instance , Class<S> clazz);
	
}
