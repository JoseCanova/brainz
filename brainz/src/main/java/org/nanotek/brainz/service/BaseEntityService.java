package org.nanotek.brainz.service;

import java.util.Map;
import java.util.stream.Collectors;

import org.nanotek.brainz.base.MapConfigurationBase;

public class BaseEntityService {

	
	public Map<String,?> mapToMap(String[] sary,
			MapConfigurationBase configuration) {
		Map<String,Integer> theMap = 
						configuration.getDelegateMap();
		return theMap.entrySet()
		.stream()
		.map(e -> Map.entry(e.getKey(), sary[e.getValue()]))
		.map(e -> Map.entry(e.getKey(), filterValue(e.getValue())))
		.collect(Collectors.toMap(x -> x.getKey() , x ->x.getValue()));
	}


	private String filterValue(String value) {
		return value.replace("\\N", "");
		
	}
	
}
