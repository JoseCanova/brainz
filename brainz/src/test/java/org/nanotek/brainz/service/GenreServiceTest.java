package org.nanotek.brainz.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GenreServiceTest {

	@Autowired
	GenreService service;
	
	@BeforeEach
	void loadGenre() {
		assertNotNull(service);
		
		service.loadGenre();
		
	}

	@Test
	void verifyFindByMethods() {
		String genreName = "mantra";
		service.findByGenreName(genreName)
		.ifPresentOrElse(n -> System.err.println(n.toString()),
				new Runnable () {
					@Override
					public void run() {
						throw new RuntimeException();
					}
		}
			);
		Long genreId = 2140L;
		service.findByGenreId(genreId)
		.ifPresentOrElse(n -> System.err.println(n.toString()),
				new Runnable () {
					@Override
					public void run() {
						throw new RuntimeException();
					}
		}
			);
	}
	
	
}
