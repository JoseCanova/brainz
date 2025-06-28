package org.nanotek.brainz;

import java.util.Map;
import java.util.stream.Collectors;

import org.nanotek.brainz.base.MapConfigurationBase;

/**
 * Externalize common metod to co0nver tabbed line to a map based in ahe 
 * configuration defined in application.yml
 */


public interface ConfiigurationMapper {
	
	default Map<String,?> mapToMap(MapConfigurationBase  configuration , String[] sary) {
		Map<String,Integer> theMap = 
						configuration.getDelegateMap();
		return theMap.entrySet()
		.stream()
		.map(e -> Map.entry(e.getKey(), sary[e.getValue()]))
		.map(e -> Map.entry(e.getKey(), filterValue(e.getValue())))
		.collect(Collectors.toMap(x -> x.getKey() , x ->x.getValue()));
	}
	
	default String filterValue(String value) {
		return value.replace("\\N", "");
	}
}
