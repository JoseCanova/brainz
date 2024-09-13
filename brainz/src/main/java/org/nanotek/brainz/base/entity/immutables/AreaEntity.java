package org.nanotek.brainz.base.entity.immutables;

import org.nanotek.brainz.base.entity.mutable.MutableAreaIdEntity;
import org.nanotek.brainz.base.entity.mutable.MutableAreaNameEntity;

public interface AreaEntity extends 
MutableAreaIdEntity<Long>,
MutableAreaNameEntity<String>{
}
