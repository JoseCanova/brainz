package org.nanotek.brainz.base.repository;

import org.nanotek.brainz.base.entity.SequenceLongBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceLongBaseRepository<T extends SequenceLongBase<Long> > extends JpaRepository<T, Long> {

}
