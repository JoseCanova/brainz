package org.nanotek.brainz.base.entity.mutable;

import java.util.UUID;

import org.nanotek.brainz.base.entity.immutables.GenreEntity;

public interface MutableGenreEntity 
extends GenreEntity,
MutableGenreIdEntity<Long>,
MutableGidEntity<UUID>,
MutableGenreNameEntity<String>{

}
