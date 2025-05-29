package org.nanotek.brainz.service;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.nanotek.brainz.InstanceConverter;
import org.nanotek.brainz.base.MapConfigurationBase;
import org.nanotek.brainz.base.entity.SequenceLongBase;
import org.nanotek.brainz.stream.NioKongStreamBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import reactor.core.publisher.Flux;

public class BaseEntityService {

	@Autowired 
	InstanceConverter converter;
	
	public Flux<? extends SequenceLongBase<Long>> convertFluxStream(MapConfigurationBase configuration){
		Stream<String> fileStream = getFileStream(configuration);
		
		return Flux.fromStream(fileStream)
		.map(s -> s.split("\t"))
		.map(sary -> mapToMap(sary,configuration))
		.map(m -> converter.convertValue(m , configuration.getImmutable()))
		.map(im -> converter.convertValue(im, configuration.getBaseClass()));
		}
	
	public Stream<String> getFileStream(MapConfigurationBase configuration) {
		String filePath = configuration.getFileLocation()
		.concat("/").concat(configuration.getFileName());
		
		return new NioKongStreamBuilder(filePath).build();
	}
	
	public Map<String,?> mapToMap(String[] sary,
			MapConfigurationBase configuration) {
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
