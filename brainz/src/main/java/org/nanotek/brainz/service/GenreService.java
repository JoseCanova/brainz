package org.nanotek.brainz.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.nanotek.brainz.InstanceConverter;
import org.nanotek.brainz.base.MapConfigurationBase;
import org.nanotek.brainz.base.entity.Genre;
import org.nanotek.brainz.base.record.GenreRecord;
import org.nanotek.brainz.base.repository.GenreRepository;
import org.nanotek.brainz.stream.NioKongStreamBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class GenreService 
extends BaseEntityService
implements InitializingBean{

	
	@Autowired
	GenreRepository repository;
	
	@Autowired
	InstanceConverter converter;
	
	private Stream<String> fileStream;

	@Autowired 
	List<MapConfigurationBase> fileConfiguration;
	
	MapConfigurationBase configuration;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		configuration = fileConfiguration.stream()
						.filter(f ->f.getFileName().equals("genre"))
						.findFirst().get();
		
		String fileStr = configuration
				.getFileLocation().concat("/")
				.concat(configuration.getFileName());
		
		fileStream = new NioKongStreamBuilder(fileStr).build();
		
		
	}

	public void loadGenre() {
		
		Flux.fromStream(fileStream)
		.map(s -> s.split("\t"))
		.map(sary -> mapToMap(sary,configuration))
		.map(m -> converter.convertValue(m , configuration.getImmutable()))
		.map(im -> converter.convertValue(im, Genre.class))
		.map(ge -> repository.save(ge))
		.subscribe(ar -> {
			System.err.println(ar.toString());
		});
		
	}

	public Optional<GenreRecord> findByGenreId(Long genreId) {
		return repository.findByGenreId(genreId);
	}

	public Optional<GenreRecord> findByGenreName(String genreName) {
		return repository.findByGenreName(genreName);
	}

	public Optional<Genre> findById(Long id) {
		return repository.findById(id);
	}
	
	
	
	
}
