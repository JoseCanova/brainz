package org.nanotek.brainz.base.repository;

import org.nanotek.brainz.base.entity.ArtistAliasType;
import org.nanotek.brainz.base.repository.accessor.TypeNameAccessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArtistAliasTypeRepository 
extends TypeNameAccessor ,  JpaRepository<ArtistAliasType<?>, Long> {
}
