package org.nanotek.brainz.base.repository;

import java.util.Optional;

import org.nanotek.brainz.base.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository 
extends JpaRepository<Area, Long> {

	Optional<Area> findByAreaId(long l);}