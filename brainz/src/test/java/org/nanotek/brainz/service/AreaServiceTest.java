package org.nanotek.brainz.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AreaServiceTest {

	@Autowired
	AreaService areaService;
	
	
	@Test
	public void testAreaService() {
		assertNotNull(areaService);
		areaService.updateAreaBase();
	}
}
