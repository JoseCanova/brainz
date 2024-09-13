package org.nanotek.brainz.base.entity;

import java.io.Serializable;

import org.nanotek.brainz.base.IdBase;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity<K extends BaseEntity<K,ID>,ID extends Serializable>
implements IdBase<K,ID>{
	
	@Id
	protected ID id;
}
