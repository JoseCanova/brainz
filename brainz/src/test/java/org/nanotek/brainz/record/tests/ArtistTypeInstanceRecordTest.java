package org.nanotek.brainz.record.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.nanotek.brainz.InstanceConverter;
import org.nanotek.brainz.base.entity.ArtistType;
import org.nanotek.brainz.base.record.ArtistTypeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArtistTypeInstanceRecordTest {

	
	@Autowired
	InstanceConverter converter;
	
	
	
	@Test
	public void testRecordConvertion() {
		
		assertNotNull(converter);
		
		ArtistTypeRecord rec = 
				new ArtistTypeRecord(3l, "typeName" , 3l, "description",UUID.randomUUID());
		
		ArtistType atype =  converter.convertValue(rec, ArtistType.class);
		
		assertNotNull(atype);
	
	}
	
	@Test
	public void testInstanceConvertion() {
		
		assertNotNull(converter);
		
		ArtistType atype = 
				new ArtistType(3l, "typeName" , 3l, "description",UUID.randomUUID());
		
		ArtistTypeRecord rec =  converter.convertValue(atype, ArtistTypeRecord.class);
		
		assertNotNull(rec);
	
	}
}
