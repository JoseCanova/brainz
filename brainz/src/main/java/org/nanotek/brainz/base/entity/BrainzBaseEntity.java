package org.nanotek.brainz.base.entity;


import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BrainzBaseEntity<K extends BrainzBaseEntity<K>> 
extends SequenceLongBase<Long> 
{

	private static final long serialVersionUID = -8896061351986644230L;

	public BrainzBaseEntity() {
	}

}
