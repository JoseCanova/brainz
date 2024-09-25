package org.nanotek.brainz;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.nanotek.brainz.base.entity.Area;
import org.nanotek.brainz.base.record.AreaRecord;
import org.nanotek.brainz.base.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class BasePersistenceTests {

	@Autowired
	AreaRepository areaRepository;
	
	@Test
    public void whenFindingCustomerById_thenCorrect() {
		areaRepository.save(new Area(1000L , UUID.randomUUID(), "John"));
		Optional<AreaRecord> optArea = areaRepository.findByAreaId(1000L);
        assertTrue(optArea.isPresent());
        optArea.ifPresent(a -> System.err.println(a.toString()));
    }
	
}
