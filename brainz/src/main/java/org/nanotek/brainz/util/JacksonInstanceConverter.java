package org.nanotek.brainz.util;

import org.nanotek.brainz.InstanceConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

public record JacksonInstanceConverter(ObjectMapper objectMapper) implements InstanceConverter {

	
	public JacksonInstanceConverter(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
	
	@Override
	public <K, S extends K> S convertValue(Object instance, Class<S> clazz) {
		return objectMapper.convertValue(instance, clazz);
	}

}
