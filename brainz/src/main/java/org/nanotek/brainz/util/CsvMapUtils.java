package org.nanotek.brainz.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CsvMapUtils {

	@Autowired 
	ObjectMapper objectMapper; 
	
	
	public <K> K  readValue(String s, Class<K> clazz) {
		try {
			return objectMapper.readValue(s, clazz);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}

	public String convertToEmpty(String column) {
		return column.replace("\\N", "");
	}
	
	public String writeJsonString(Map<String, ?> map) {
		try {
			return objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}
}
