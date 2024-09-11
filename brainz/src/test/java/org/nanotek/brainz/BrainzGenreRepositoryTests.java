package org.nanotek.brainz;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.nanotek.brainz.base.MapConfigurationBase;
import org.nanotek.brainz.base.entity.Genre;
import org.nanotek.brainz.base.record.GenreRecord;
import org.nanotek.brainz.base.repository.GenreRepository;
import org.nanotek.brainz.stream.NioKongStreamBuilder;
import org.nanotek.brainz.util.CsvMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;

@SpringBootTest
public class BrainzGenreRepositoryTests {

	@Autowired
	List<MapConfigurationBase> filesConfiguration;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	CsvMapUtils csvMapUtils;
	
	@Autowired
	GenreRepository genreRepository;
	
	@Test
	public void testFileConfiguation() {
		assertNotNull(filesConfiguration);
		assertTrue(filesConfiguration.size() > 0);
		assertNotNull(genreRepository);
		Map<String , MapConfigurationBase > mapEntries = filesConfiguration
		  .stream()
		  .map(mcb -> Map.entry(mcb.getFileName(), mcb))
		  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	   assertTrue(mapEntries.get("area") !=null);
	   assertTrue(mapEntries.get("artist") !=null);
	   assertTrue(mapEntries.get("genre") !=null);
	   MapConfigurationBase genreConfiguration = mapEntries.get("genre");
	   String genreFileName = genreConfiguration.getFileLocation().concat("/").concat(genreConfiguration.getFileName());
	   Stream <String> genreStream = new NioKongStreamBuilder(genreFileName).build();
	   
	   Flux
	   .fromStream(genreStream)
	   .map(s -> s.split("\t"))
	   .map(sary -> mapToMap(sary , genreConfiguration.getDelegateMap()))
	   .map(s -> objectMapper.convertValue(s , genreConfiguration.getImmutable()))
	   .map(gr -> GenreRecord.class.cast(gr))
	   .filter(gr -> gr.name().equals("parang"))
	   .map(gr -> objectMapper.convertValue(gr , Genre.class))
	   .map(gr -> genreRepository.save(gr))
	   .map(gr -> genreRepository.findByName(gr.name()))
	   .subscribe( v -> System.err.println(v.toString()));

	}
	
	public Map<String,?> mapToMap(String[] sary, Map<String, Integer> genreConfigurationMap) {
		Map<String,Integer> theMap = 
				genreConfigurationMap;
		return theMap.entrySet()
		.stream()
		.map(e -> Map.entry(e.getKey(), sary[e.getValue()]))
		.collect(Collectors.toMap(x -> x.getKey() , x ->x.getValue()));
	}
}
