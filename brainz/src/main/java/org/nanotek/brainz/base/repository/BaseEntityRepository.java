package org.nanotek.brainz.base.repository;

import java.io.Serializable;

import org.nanotek.brainz.base.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier(value="base")
public interface BaseEntityRepository
<K extends BaseEntity<K,ID> , ID extends Serializable> 
extends JpaRepository<K,ID>{
}
