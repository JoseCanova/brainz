package org.nanotek.brainz.base.repository;

import org.nanotek.brainz.base.entity.ArtistType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArtistTypeRepository extends JpaRepository<ArtistType, Long> {
}
