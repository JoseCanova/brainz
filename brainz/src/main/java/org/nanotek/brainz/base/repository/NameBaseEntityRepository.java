package org.nanotek.brainz.base.repository;

import java.io.Serializable;

import org.nanotek.brainz.base.entity.NameBaseEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier(value="name")
public interface NameBaseEntityRepository
<K extends NameBaseEntity<K,ID> , ID extends Serializable> 
extends BaseEntityRepository<K,ID>{
}
