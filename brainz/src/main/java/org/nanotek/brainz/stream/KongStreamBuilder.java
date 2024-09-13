package org.nanotek.brainz.stream;

import java.util.stream.Stream;

import org.nanotek.brainz.Kong;

public interface KongStreamBuilder<S extends K, K extends Kong<?>> 
extends Stream.Builder<S> {
}
