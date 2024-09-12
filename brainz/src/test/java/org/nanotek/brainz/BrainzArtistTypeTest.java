package org.nanotek.brainz;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nanotek.brainz.base.MapConfigurationBase;
import org.nanotek.brainz.stream.NioKongStreamBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;

@SpringBootTest
public class BrainzArtistTypeTest {


	@Autowired
	List<MapConfigurationBase> filesConfiguration;
	
	@Autowired
	ObjectMapper objectMapper;
	
	MapConfigurationBase artistTypeConfiguration;
	
	@BeforeEach
	public void loadMap() {
		assertNotNull(filesConfiguration);
		artistTypeConfiguration
		=filesConfiguration.stream()
		.filter(x -> x.getFileName().equals("artist_type")).findAny().get();
	
	}
	
	
	@Test
	public void testBrainzArtistType() {
		assertNotNull(filesConfiguration);
		Stream<String> fileStream = 
				new NioKongStreamBuilder(artistTypeConfiguration.getFileLocation().concat("/").concat(artistTypeConfiguration.getFileName())
						).build();
		Flux.fromStream(fileStream)
		.map(s -> s.split("\t"))
		.map(sary -> mapToMap(sary))
		.map(m -> objectMapper.convertValue(m, artistTypeConfiguration.getImmutable()));
	}
	
	public Map<String,?> mapToMap(String[] sary) {
		Map<String,Integer> theMap = 
						artistTypeConfiguration.getDelegateMap();
		return theMap.entrySet()
		.stream()
		.map(e -> Map.entry(e.getKey(), sary[e.getValue()]))
		.collect(Collectors.toMap(x -> x.getKey() , x ->x.getValue()));
	}
	
	
}
