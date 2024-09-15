package org.nanotek.brainz.base.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class NameBaseEntity<K extends NameBaseEntity<K,ID>, 
ID extends Serializable> extends BaseEntity<K, ID> {

	@Column(name="name")
	protected String name;
	
}
