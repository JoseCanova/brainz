package org.nanotek.brainz.base.repository;

import org.nanotek.brainz.base.entity.Area;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends CrudRepository<Area, Long> {}