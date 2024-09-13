package org.nanotek.brainz;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.nanotek.brainz.base.record.GenreRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.validation.Validator;
import jakarta.validation.groups.Default;

@SpringBootTest
public class BrainzValidatorConfigurationTest {

	@Autowired
	Validator validator;
	
	@Test
	public void validatorInjectionTest() {
		assertNotNull(validator);
		GenreRecord genreRecord = new GenreRecord(null , 
							UUID.randomUUID(),
							"genre name");
	    Set<?> violations = validator.validate(genreRecord, Default.class);
	    assertTrue (violations.size()==1);
	}
}
