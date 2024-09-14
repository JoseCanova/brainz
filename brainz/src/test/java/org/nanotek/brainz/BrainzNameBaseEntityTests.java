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
import org.nanotek.brainz.base.entity.Genre;
import org.nanotek.brainz.base.entity.NameBaseEntity;
import org.nanotek.brainz.base.record.GenreRecord;
import org.nanotek.brainz.base.repository.NameBaseEntityRepository;
import org.nanotek.brainz.stream.NioKongStreamBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;

@SpringBootTest
public class BrainzNameBaseEntityTests<K extends NameBaseEntity<K,Long>> {

	@Autowired
	NameBaseEntityRepository<K,Long> repository;
	
	@Autowired 
	ObjectMapper objectMapper;
	
	@Autowired
	List<MapConfigurationBase> filesConfiguration;
	
	Map<String , MapConfigurationBase > mapEntries;
	
	@BeforeEach
	public void loadConfigurationBaseMap() {
		mapEntries = filesConfiguration
				  .stream()
				  .map(mcb -> Map.entry(mcb.getFileName(), mcb))
				  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
			   assertTrue(mapEntries.get("genre") !=null);
			   assertTrue(mapEntries.get("artist_type") !=null);

	}
	
	@Test
	public void testBrainzNameEntityRepository() {
		   MapConfigurationBase genreConfiguration = mapEntries.get("genre");
		   MapConfigurationBase artistTypeConfiguration = mapEntries.get("artist_type");
		   assertNotNull(genreConfiguration);
		   assertNotNull(artistTypeConfiguration);
		   
		   String genreFileName = genreConfiguration.getFileLocation().concat("/").concat(genreConfiguration.getFileName());
		   Stream <String> genreStream = new NioKongStreamBuilder(genreFileName).build();
		   
		   Flux
		   .fromStream(genreStream)
		   .map(s -> s.split("\t"))
		   .map(sary -> mapToMap(sary , genreConfiguration.getDelegateMap()))
		   .map(s -> objectMapper.convertValue(s , genreConfiguration.getImmutable()))
		   .map(gr -> GenreRecord.class.cast(gr))
		   .filter(gr -> gr.name().equals("parang"))
		   .filter(gr -> genreRecordIsValid(gr))
		   .map(gr -> objectMapper.convertValue(gr , Genre.class))
		   .map(gr -> repository.save((K)gr))
		   .subscribe( v -> System.err.println(v.toString()));

		   String typeFileName = artistTypeConfiguration.getFileLocation().concat("/").concat(artistTypeConfiguration.getFileName());
		   Stream <String> typeStream = new NioKongStreamBuilder(typeFileName).build();

		   Flux
		   .fromStream(typeStream)
		   .map(s -> s.split("\t"))
		   .map(sary -> mapToMap(sary , artistTypeConfiguration.getDelegateMap()))
			.map(m -> objectMapper.convertValue(m , ArtistType.class))
			.subscribe(at -> repository.save((K)at));
		   try {
		  List<K> theList = repository.findAll(Example.of(new NameBaseEntity()));
		   assertTrue(theList.size()>0);
		   }catch (Exception ex) {
			   ex.printStackTrace();
			   throw new RuntimeException();
		   }
	}
	
	private String filterValue(String value) {
		return value.replace("\\N", "");
	}
	private Boolean genreRecordIsValid(GenreRecord gr) {
		return true;
	}

	public Map<String,?> mapToMap(String[] sary, Map<String, Integer> genreConfigurationMap) {
		Map<String,Integer> theMap = 
				genreConfigurationMap;
		return theMap.entrySet()
		.stream()
		.map(e -> Map.entry(e.getKey(), sary[e.getValue()]))
		.map(e -> Map.entry(e.getKey(), filterValue(e.getValue())))
		.collect(Collectors.toMap(x -> x.getKey() , x ->x.getValue()));
	}
	
	
	
}
