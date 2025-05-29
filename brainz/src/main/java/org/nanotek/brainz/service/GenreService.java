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
		
	}

	public void loadGenre() {
		
		convertFluxStream(configuration)
		 .map(c -> Genre.class.cast(c))
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
