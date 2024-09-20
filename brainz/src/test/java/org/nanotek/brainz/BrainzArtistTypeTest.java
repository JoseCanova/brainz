package org.nanotek.brainz;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nanotek.brainz.base.MapConfigurationBase;
import org.nanotek.brainz.base.entity.ArtistType;
import org.nanotek.brainz.base.repository.ArtistTypeRepository;
import org.nanotek.brainz.stream.NioKongStreamBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;

@SpringBootTest
public class BrainzArtistTypeTest{


	@Autowired
	List<MapConfigurationBase> filesConfiguration;
	
	@Autowired
	InstanceConverter converter;
	
	MapConfigurationBase artistTypeConfiguration;
	
	@Autowired
	ArtistTypeRepository repository;
	
	@BeforeEach
	public void loadMap() {
		assertNotNull(filesConfiguration);
		artistTypeConfiguration
		=filesConfiguration.stream()
		.filter(x -> x.getFileName().equals("artist_type")).findAny().get();
	
	}
	
	
	@Test
	public   void testBrainzArtistType() {
		assertNotNull(filesConfiguration);
		Stream<String> fileStream = 
				new NioKongStreamBuilder(artistTypeConfiguration.getFileLocation()
						.concat("/")
						.concat(artistTypeConfiguration.getFileName()))
				.build();
		Flux.fromStream(fileStream)
		.map(s -> s.split("\t"))
		.map(sary -> mapToMap(sary))
		.map(m -> converter.convertValue(m , artistTypeConfiguration.getImmutable()))
		.map(m -> converter.convertValue(m, ArtistType.class))
		.subscribe(at -> repository.save(at));
		List result = repository.findAll();
		assertTrue(result.size()>1);
		Flux.fromIterable(result)
		.subscribe(at -> System.out.println(at.toString()));
	}
	
	public Map<String,?> mapToMap(String[] sary) {
		Map<String,Integer> theMap = 
						artistTypeConfiguration.getDelegateMap();
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
