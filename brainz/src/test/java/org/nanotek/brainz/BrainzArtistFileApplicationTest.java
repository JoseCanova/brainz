package org.nanotek.brainz;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.nanotek.brainz.base.MapConfigurationBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class BrainzArtistFileApplicationTest {

	@Autowired
	@Qualifier("artist")
	MapConfigurationBase mapConfigurationBase;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void artistLoadStreamTest() {
		assertNotNull(mapConfigurationBase);
	}
	
}
