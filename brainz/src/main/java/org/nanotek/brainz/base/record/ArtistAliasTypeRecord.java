package org.nanotek.brainz.base.record;

import java.util.UUID;

public record ArtistAliasTypeRecord(
		Long typeId , 
	    String typeName,
	    Long parent, 
	    Long childOrder,
	    String description,
	    String gid
	    	  ) {

}
