package org.nanotek.shell.components;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.nanotek.brainz.InstanceConverter;
import org.nanotek.brainz.base.MapConfigurationBase;
import org.nanotek.brainz.base.entity.ArtistType;
import org.nanotek.brainz.base.repository.ArtistTypeRepository;
import org.nanotek.brainz.stream.NioKongStreamBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import reactor.core.publisher.Flux;

@ShellComponent
public class BaseShellComponent implements InitializingBean{
	
	@Autowired
	ArtistTypeRepository repository;
	
	@Autowired
	List<MapConfigurationBase> filesConfiguration;
	
	MapConfigurationBase artistTypeConfiguration;
	
	@Autowired
	InstanceConverter converter;
	

	@ShellMethod(key = "hello-world")
	public String helloWorld(
		@ShellOption(defaultValue = "spring") String arg
	) {
		return "Hello world " + arg;
	}
	
	@ShellMethod(key = "artist-type")
	public String loadArtistType() {
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
		
		return "finished";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		artistTypeConfiguration
		=filesConfiguration.stream()
		.filter(x -> x.getFileName().equals("artist_type")).findAny().get();
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