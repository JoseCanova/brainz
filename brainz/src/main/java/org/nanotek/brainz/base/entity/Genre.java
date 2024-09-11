package org.nanotek.brainz.base.entity;

import java.util.Optional;
import java.util.UUID;

import org.nanotek.brainz.base.Base;
import org.nanotek.brainz.base.entity.mutable.MutableGidEntity;
import org.nanotek.brainz.base.entity.mutable.MutableIdEntity;
import org.nanotek.brainz.base.entity.mutable.MutableNameEntity;
import org.nanotek.brainz.base.record.GenreRecord;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="genre")
public class Genre 
implements Base<Genre>,
MutableIdEntity<Long>,
MutableGidEntity<UUID>,
MutableNameEntity<String>{

	@Id
	private Long id;
	
	private UUID gid; 
	
	private String name;
	
	private String comment;
	
	
	public Long id() {
		return this.id;
	}
	
	public Optional<Long> id(Long id){
		return Optional.of(this.id = id);
	}
	
	public UUID gid() {
		return gid;
	}
	
	public Optional<UUID> gid(UUID gid){
		return Optional.of(this.gid = gid);
	}
	
	public String name() {
		return this.name;
	}
	
	public Optional<String> name(String name){
		return Optional.of(this.name=name);
	}
}
