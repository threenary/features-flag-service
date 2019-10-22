package com.codurance.features;

import com.codurance.features.config.ConfigReader;
import com.codurance.features.service.FeaturesRepository;
import com.codurance.features.service.FeaturesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FeaturesApplicationTests {

	@Autowired
	private FeaturesService service;

	@Autowired
	private ConfigReader reader;

	@Autowired
	private FeaturesRepository repository;

	@Test
	void contextLoads() {
		assertThat(service).isNotNull();
		assertThat(reader).isNotNull();
		assertThat(repository).isNotNull();
	}

}
