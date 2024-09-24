package org.nanotek.brainz.base.entity.mutable;

import java.util.UUID;

import org.nanotek.brainz.base.entity.immutables.AreaEntity;

public interface MutableAreaEntity 
extends  AreaEntity,
MutableAreaIdEntity<Long>,
MutableGidEntity<UUID>,
MutableAreaNameEntity<String>{

}
