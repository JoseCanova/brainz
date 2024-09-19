package org.nanotek.brainz;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nanotek.brainz.base.MapConfigurationBase;
import org.nanotek.brainz.base.entity.ArtistAliasType;
import org.nanotek.brainz.stream.NioKongStreamBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;

@SpringBootTest
class BrainzArtistAliasTypeRecordTest {

	@Autowired 
	List<MapConfigurationBase> fileConfiguration;
	
	MapConfigurationBase configuration;
	
	
	@Autowired
	InstanceConverter converter;
	
	@BeforeEach
	void setUp() throws Exception {
		Map<String,MapConfigurationBase> theMap = fileConfiguration
										.stream()
										.map( x -> Map.entry(x.getFileName(), x))
										.collect(Collectors.toMap(x -> x.getKey(), x ->x.getValue()));
		
		configuration = theMap.get("artist_alias_type");
		assertNotNull(configuration);
	}

	@Test
	void test() {
		String fileAlias = configuration.getFileLocation().concat("/").concat(configuration.getFileName());
		Stream<String> stream = new NioKongStreamBuilder(fileAlias).build();
		Flux.fromStream(stream)
		.map(s ->s.split("\t"))
		.map(sary ->mapToMap(sary))
		.map(m -> converter.convertValue(m , configuration.getImmutable()))
		.map(m -> converter.convertValue(m, ArtistAliasType.class))
		.subscribe(r -> System.err.println(r));
//		fail("Not yet implemented");
	}
	
	public Map<String,?> mapToMap(String[] sary) {
		Map<String,Integer> theMap = 
						configuration.getDelegateMap();
		return theMap.entrySet()
		.stream()
		.map(e -> Map.entry(e.getKey(), sary[e.getValue()]))
		.map(e -> Map.entry(e.getKey(), filterValue(e.getValue())))
		.collect(Collectors.toMap(x -> x.getKey() , x ->x.getValue()));
	}


	private String filterValue(String value) {
		return value.replace("\\N", "");
	}
	

}
