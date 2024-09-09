package org.nanotek.brainz;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.nanotek.brainz.base.MapConfigurationBase;
import org.nanotek.brainz.base.entity.Artist;
import org.nanotek.brainz.stream.NioKongStreamBuilder;
import org.nanotek.brainz.util.CsvMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;

@SpringBootTest
public class BrainzArtistFileApplicationTest {

	@Autowired
	@Qualifier("artist")
	MapConfigurationBase mapConfigurationBase;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	CsvMapUtils csvMapUtils;
	
	@SuppressWarnings("unchecked")
	@Test
	public void artistLoadStreamTest() {
		assertNotNull(mapConfigurationBase);
		assertNotNull(csvMapUtils);
		Class<Artist> clazz = (Class<Artist>) mapConfigurationBase.getImmutable();
		String fileStreamName = mapConfigurationBase
								.getFileLocation().concat("/")
								.concat(mapConfigurationBase.getFileName());
		Stream<String> theStream =new 
		NioKongStreamBuilder(fileStreamName).build();
		
		Flux<String> flux =	Flux.
					fromStream(theStream);
		flux
		.map(s -> s.split("\t"))
		.map(sary -> mapToMap(sary))
		.map(map ->  csvMapUtils. writeJsonString(map))
		.map(s -> csvMapUtils.readValue(s , clazz))
		.filter(ar -> ar.artistName()!=null)
		.filter(ar -> ar.artistName().contains("Black"))
		.subscribe(a -> System.out.println(a.toString()));

	
	}
	
	public Map<String,?> mapToMap(String[] sary) {
		Map<String,Integer> theMap = 
						mapConfigurationBase.getDelegateMap();
		return theMap.entrySet()
		.stream()
		.map(e -> Map.entry(e.getKey(), sary[e.getValue()]))
		.collect(Collectors.toMap(x -> x.getKey() , x ->x.getValue()));
	}
	
}
