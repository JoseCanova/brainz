package org.nanotek.brainz;

import java.util.ArrayList;
import java.util.List;

import org.nanotek.brainz.base.MapConfigurationBase;
import org.nanotek.brainz.util.JacksonInstanceConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

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
	@ConfigurationProperties(value = "artistaliastype")
	@Qualifier(value="artist_alias_ype")
	public MapConfigurationBase mapArtistAliasTypeConfigurationBase() {
		return new MapConfigurationBase();
	}
	
	
	//TODO:remove from tests injection of ObjectMapper and substitute by the instanceConverter.
	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
	
	@Bean
	public InstanceConverter instanceConverter() {
		return new JacksonInstanceConverter(new ObjectMapper());
	}
	
	@Bean
	@ConfigurationProperties(value="fileconfig")
	public List<MapConfigurationBase> filesConfiguration(){
		return new ArrayList<MapConfigurationBase>();
	}
	
	@Bean
	@Primary
	public LocalValidatorFactoryBean getLocalValidatorFactoryBean() { 
		LocalValidatorFactoryBean validatorFactoryBean =  new LocalValidatorFactoryBean();
		//validatorFactoryBean.setValidationMessageSource(messageSource());
		return validatorFactoryBean;
	}
	
}
