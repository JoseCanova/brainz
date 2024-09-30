package org.nanotek.brainz.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.nanotek.brainz.InstanceConverter;
import org.nanotek.brainz.base.MapConfigurationBase;
import org.nanotek.brainz.base.entity.Area;
import org.nanotek.brainz.base.record.AreaRecord;
import org.nanotek.brainz.base.repository.AreaRepository;
import org.nanotek.brainz.stream.NioKongStreamBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;


@Service
public class AreaService implements InitializingBean{

	
	@Autowired 
	InstanceConverter converter;
	
	@Autowired 
	List<MapConfigurationBase> fileConfiguration;
	
	@Autowired
	AreaRepository repository;

	private MapConfigurationBase configuration;

	public static String areaStr = "area";
	
	private Stream<String> fileStream;
	@Override
	public void afterPropertiesSet() 
			throws Exception {
		configuration = fileConfiguration
				.stream()
				.map(f -> Map.entry(f.getFileName(), f))
				.filter(e -> e.getKey().equals(areaStr))
				.map(e -> e.getValue()).findFirst().get();
		
		String fileName = configuration.getFileLocation()
				.concat("/").concat(configuration.getFileName());
		
		fileStream = new NioKongStreamBuilder(fileName)
									.build();
	}
	
	
	
	
	public void updateAreaBase() {
		Flux.fromStream(fileStream)
		.map(s -> s.split("\t"))
		.map(sary -> mapToMap(sary))
		.map(m -> converter.convertValue(m , configuration.getImmutable()))
		.map(im -> converter.convertValue(im, Area.class))
		.map(ar -> repository.save(ar))
		.doOnNext(ar -> { 
			Optional<AreaRecord>  finder =  repository.findByAreaId(ar.areaId());
			finder.ifPresent(f -> {
				System.err.println("found " .concat(f.areaId().toString()));
			});
		
		})
		.subscribe(ar -> {
			System.err.println(ar.toString());
		});
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
