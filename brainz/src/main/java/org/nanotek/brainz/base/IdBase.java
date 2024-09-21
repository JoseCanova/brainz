package org.nanotek.brainz.base;

import java.io.Serializable;

public interface IdBase<K extends Base<K>,ID extends Serializable> extends Base<K> , Id<ID> {
	
}
