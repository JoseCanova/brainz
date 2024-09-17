package org.nanotek.brainz.base.entity;

import javax.persistence.MappedSuperclass;

import org.nanotek.entities.BaseBrainzEntity;

@MappedSuperclass
public class BrainzBaseEntity<K extends BrainzBaseEntity<K>> 
extends SequenceLongBase<K, Long> 
implements BaseBrainzEntity<K>
{

	private static final long serialVersionUID = -8896061351986644230L;

	public BrainzBaseEntity() {
	}

}
