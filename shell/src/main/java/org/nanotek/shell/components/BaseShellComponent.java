package org.nanotek.shell.components;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.nanotek.brainz.InstanceConverter;
import org.nanotek.brainz.base.Base;
import org.nanotek.brainz.base.MapConfigurationBase;
import org.nanotek.brainz.base.entity.SequenceLongBase;
import org.nanotek.brainz.base.repository.ArtistTypeRepository;
import org.nanotek.brainz.base.repository.SequenceLongBaseRepository;
import org.nanotek.brainz.stream.NioKongStreamBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import reactor.core.publisher.Flux;


//TODO: Fix the component ObjectMarshaller to support hibernate types
@ShellComponent
public class BaseShellComponent implements InitializingBean{
	
	@Autowired
	ArtistTypeRepository repository;
	
	@Autowired
	SequenceLongBaseRepository<SequenceLongBase<Long>> repository2;
	
	@Autowired
	List<MapConfigurationBase> filesConfiguration;
	
	MapConfigurationBase artistTypeConfiguration;
	
	Map<String,MapConfigurationBase> theMap;

	MapConfigurationBase artistAliasTypeConfiguration;
	
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
		.map(m -> converter.convertValue(m, artistTypeConfiguration.getBaseClass()))
		.subscribe(at -> repository2.save(at));
		
		return "finished loading artist type";
	}
	
	@ShellMethod(key = "artist-alias-type")
	public String loadArtistAliasType() {
		Stream<String> fileStream = 
				new NioKongStreamBuilder(artistAliasTypeConfiguration.getFileLocation()
						.concat("/")
						.concat(artistAliasTypeConfiguration.getFileName()))
				.build();
		Flux.fromStream(fileStream)
		.map(s -> s.split("\t"))
		.map(sary -> mapToMap(sary))
		.map(m -> converter.convertValue(m , artistAliasTypeConfiguration.getImmutable()))
		.map(m -> converter.convertValue(m, artistAliasTypeConfiguration.getBaseClass()))
		.subscribe(at -> repository2.save(at));
		
		return "finished loading artist  alias type";
	}
    
	public List<Object>findType(){
		SequenceLongBase<Long> aliasTypeInstance = Base
				.newInstance(artistTypeConfiguration.getBaseClass())
				.get();
		List<SequenceLongBase<Long>> listAlias =  repository2
				.findAll(Example.of(aliasTypeInstance));
		
		return listAlias.stream()
		.map(i -> converter.convertValue(i, artistTypeConfiguration.getImmutable()))
		.collect(Collectors.toList());
		
	}
	
	public List<Object>findAliasType(){
		SequenceLongBase<Long> aliasTypeInstance = Base
				.newInstance(artistAliasTypeConfiguration.getBaseClass())
				.get();
		List<SequenceLongBase<Long>> listAlias =  repository2
				.findAll(Example.of(aliasTypeInstance));
		
		return listAlias.stream()
		.map(i -> converter.convertValue(i, artistAliasTypeConfiguration.getImmutable()))
		.collect(Collectors.toList());
		
	}
	
	
	@ShellMethod(key="return-types")
	public List<Object> loadAllTypes(){
		List<Object> listAlias =  findType();
		List<Object> listAliasType =  findAliasType();
		listAlias.addAll(listAliasType);
		return listAlias;
	}
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		theMap = filesConfiguration
				.stream()
				.map( x -> Map.entry(x.getFileName(), x))
				.collect(Collectors.toMap(x -> x.getKey(), x ->x.getValue()));
		
		artistTypeConfiguration = theMap.get("artist_type");
		
		artistAliasTypeConfiguration = theMap.get("artist_alias_type");
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