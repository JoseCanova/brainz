package org.nanotek.brainz.base.repository;

import java.util.Optional;

import org.nanotek.brainz.base.entity.Area;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository 
extends SequenceLongBaseRepository<Area> {

	Optional<Area> findByAreaId(long l);}