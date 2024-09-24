package org.nanotek.brainz;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.nanotek.brainz.base.MapConfigurationBase;
import org.nanotek.brainz.base.record.AreaRecord;
import org.nanotek.brainz.stream.NioKongStreamBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;

@SpringBootTest
class BrainzApplicationTests {

	@Autowired
	MapConfigurationBase mapConfigurationBase;
	
	@Autowired
	ObjectMapper objectMapper;
	
	
	@Test
	void contextLoads() {
		assertNotNull(mapConfigurationBase);
		assertNotNull(objectMapper);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Flux<String> flux =	Flux.
							fromStream(new NioKongStreamBuilder("/home/jose/Downloads/mbdump/mbdump/area").build());
		
		flux
		.map(s -> s.split("\t"))
		.map(sary -> mapToMap(sary))
		//.map(map -> writeJsonString(map))
		.map(s -> readAreaValue2(s))
		.subscribe(a -> System.out.println(a.toString()));

	}

	private Object readAreaValue2(Map<String, ?> s) {
		return objectMapper.convertValue(s , AreaRecord.class);
	}

	private AreaRecord readAreaValue(String s) {
		try {
			return objectMapper.readValue(s, AreaRecord.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}

	private String writeJsonString(Map<String, ?> map) {
		try {
			return objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}

	private Map<String,?> mapToMap(String[] sary) {
		Map<String,Integer> theMap = 
						mapConfigurationBase.getDelegateMap();
		return theMap.entrySet()
		.stream()
		.map(e -> Map.entry(e.getKey(), sary[e.getValue()]))
		.collect(Collectors.toMap(x -> x.getKey() , x ->x.getValue()));
	}

}
