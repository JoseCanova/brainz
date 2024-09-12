package org.nanotek.brainz;

import java.util.ArrayList;
import java.util.List;

import org.nanotek.brainz.base.MapConfigurationBase;
import org.springframework.beans.factory.annotation.Qualifier;
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
	@Qualifier(value="area")
	public MapConfigurationBase mapConfigurationBase() {
		return new MapConfigurationBase();
	}
	
	@Bean
	@ConfigurationProperties(value = "artist")
	@Qualifier(value="artist")
	public MapConfigurationBase mapArtistConfigurationBase() {
		return new MapConfigurationBase();
	}
	
	@Bean
	@ConfigurationProperties(value = "genre")
	@Qualifier(value="genre")
	public MapConfigurationBase mapAGenreConfigurationBase() {
		return new MapConfigurationBase();
	}
	
	@Bean
	@ConfigurationProperties(value = "artisttype")
	@Qualifier(value="artist_type")
	public MapConfigurationBase mapArtistTypeConfigurationBase() {
		return new MapConfigurationBase();
	}
	
	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
	
	@Bean
	@ConfigurationProperties(value="fileconfig")
	public List<MapConfigurationBase> filesConfiguration(){
		return new ArrayList<MapConfigurationBase>();
	}
	
}
