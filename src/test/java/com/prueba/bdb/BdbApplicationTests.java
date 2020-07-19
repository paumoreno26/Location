package com.prueba.bdb;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.bdb.dto.LocationParentDTO;
import com.prueba.bdb.services.LocationService;


@SpringBootTest
class BdbApplicationTests {
	
	@Autowired
	LocationService service;

	@Test
	void contextLoads() {
	}

	@Test
	public void consultLocation() throws Exception {
			
			List<LocationParentDTO> result = service.consultParent();
			assertNotNull(result);
			
	}
	
}
