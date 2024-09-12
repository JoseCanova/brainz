package org.nanotek.brainz;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.nanotek.brainz.base.MapConfigurationBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class BrainzArtistTypeTest {


	@Autowired
	List<MapConfigurationBase> filesConfiguration;
	
	@Autowired
	ObjectMapper objectMapper;
	
	
	
	@Test
	public void testBrainzArtistType() {
		assertNotNull(filesConfiguration);
		MapConfigurationBase artistTypeConfiguration
		=filesConfiguration.stream()
		.filter(x -> x.getFileName().equals("artist_type")).findAny().get();
	}
}
