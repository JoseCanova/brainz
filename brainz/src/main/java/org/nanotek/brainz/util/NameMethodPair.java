package org.nanotek.brainz.util;

import java.util.List;

public record NameMethodPair<K>(String name , K method,List<K> methods) {
}
