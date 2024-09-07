package org.nanotek.brainz;

import org.nanotek.brainz.base.MapConfigurationBase;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan("org.nanotek")
public class BrainzConfig {

	
	@Bean
	@ConfigurationProperties(value = "area")
	public MapConfigurationBase mapConfigurationBase() {
		return new MapConfigurationBase();
	}
	
	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
}
