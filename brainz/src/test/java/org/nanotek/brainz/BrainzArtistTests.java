package org.nanotek.brainz;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nanotek.brainz.base.MapConfigurationBase;
import org.nanotek.brainz.base.entity.Artist;
import org.nanotek.brainz.base.repository.ArtistRepository;
import org.nanotek.brainz.stream.NioKongStreamBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;

@SpringBootTest
public class BrainzArtistTests {

	@Autowired 
	InstanceConverter converter;
	
	@Autowired 
	List<MapConfigurationBase> fileConfiguration;
	
	@Autowired
	ArtistRepository repository;
	
	MapConfigurationBase configuration;
	
	@BeforeEach
	public void loadConfiguration(){
	
		configuration = fileConfiguration
		.stream()
		.map(f -> Map.entry(f.getFileName(), f))
		.filter(e -> e.getKey().equals("artist"))
		.map(e -> e.getValue()).findFirst().get();
		assertNotNull(configuration);
		assertNotNull (repository);
		assertNotNull(converter);
	}
	
	@Test
	public void testArtistFileImport() {
		String fileName = configuration.getFileLocation()
				.concat("/").concat(configuration.getFileName());
		
		Stream<String> fileStream = new NioKongStreamBuilder(fileName)
									.build();
		
		
		
		Flux.fromStream(fileStream)
		.map(s -> s.split("\t"))
		.map(sary -> mapToMap(sary))
		.map(m -> converter.convertValue(m , configuration.getImmutable()))
		.map(im -> converter.convertValue(im, Artist.class))
		.map(ar -> repository.save(ar))
		.subscribe(ar -> System.err.println(ar));
		
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
