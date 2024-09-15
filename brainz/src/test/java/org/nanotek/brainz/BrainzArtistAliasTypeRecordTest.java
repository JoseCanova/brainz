package org.nanotek.brainz;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nanotek.brainz.base.MapConfigurationBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BrainzArtistAliasTypeRecordTest {

	@Autowired 
	List<MapConfigurationBase> fileConfiguration;
	
	MapConfigurationBase artistAliasTypeConfiguration;
	
	@BeforeEach
	void setUp() throws Exception {
		Map<String,MapConfigurationBase> theMap = fileConfiguration
										.stream()
										.map( x -> Map.entry(x.getFileName(), x))
										.collect(Collectors.toMap(x -> x.getKey(), x ->x.getValue()));
		
		artistAliasTypeConfiguration = theMap.get("artist_alias_type");
		assertNotNull(artistAliasTypeConfiguration);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
