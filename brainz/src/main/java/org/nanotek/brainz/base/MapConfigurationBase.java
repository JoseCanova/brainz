package org.nanotek.brainz.base;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapConfigurationBase implements Base<MapConfigurationBase> {

	private String fileLocation;
	private String  fileName;
	private Class<?> immutable;
	private Class<? extends Base<?>> baseClass;
	
	
	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Class<?> getImmutable() {
		return immutable;
	}

	public void setImmutable(Class<?> immutable) {
		this.immutable = immutable;
	}

	public Map<String, Integer> getDelegateMap() {
		return delegateMap;
	}

	public void setDelegateMap(Map<String, Integer> delegateMap) {
		this.delegateMap = delegateMap;
	}

	private Map <String,Integer>  delegateMap;
	
	public MapConfigurationBase() {
		delegateMap = new HashMap<>();
	}

	public int size() {
		return delegateMap.size();
	}

	public boolean isEmpty() {
		return delegateMap.isEmpty();
	}

	public boolean containsKey(Object key) {
		return delegateMap.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return delegateMap.containsValue(value);
	}

	public Integer get(Object key) {
		return delegateMap.get(key);
	}

	public Integer put(String key, Integer value) {
		return delegateMap.put(key, value);
	}

	public Integer remove(Object key) {
		return delegateMap.remove(key);
	}

	public void putAll(Map<? extends String, ? extends Integer> m) {
		delegateMap.putAll(m);
	}

	public void clear() {
		delegateMap.clear();
	}

	public Set<String> keySet() {
		return delegateMap.keySet();
	}

	public Collection<Integer> values() {
		return delegateMap.values();
	}

	public Set<Map.Entry<String, Integer>> entrySet() {
		return delegateMap.entrySet();
	}

	public boolean equals(Object o) {
		return delegateMap.equals(o);
	}

	public int hashCode() {
		return delegateMap.hashCode();
	}

	public Integer getOrDefault(Object key, Integer defaultValue) {
		return delegateMap.getOrDefault(key, defaultValue);
	}

	public void forEach(BiConsumer<? super String, ? super Integer> action) {
		delegateMap.forEach(action);
	}

	public void replaceAll(BiFunction<? super String, ? super Integer, ? extends Integer> function) {
		delegateMap.replaceAll(function);
	}

	public Integer putIfAbsent(String key, Integer value) {
		return delegateMap.putIfAbsent(key, value);
	}

	public boolean remove(Object key, Object value) {
		return delegateMap.remove(key, value);
	}

	public boolean replace(String key, Integer oldValue, Integer newValue) {
		return delegateMap.replace(key, oldValue, newValue);
	}

	public Integer replace(String key, Integer value) {
		return delegateMap.replace(key, value);
	}

	public Integer computeIfAbsent(String key, Function<? super String, ? extends Integer> mappingFunction) {
		return delegateMap.computeIfAbsent(key, mappingFunction);
	}

	public Integer computeIfPresent(String key,
			BiFunction<? super String, ? super Integer, ? extends Integer> remappingFunction) {
		return delegateMap.computeIfPresent(key, remappingFunction);
	}

	public Integer compute(String key,
			BiFunction<? super String, ? super Integer, ? extends Integer> remappingFunction) {
		return delegateMap.compute(key, remappingFunction);
	}

	public Integer merge(String key, Integer value,
			BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
		return delegateMap.merge(key, value, remappingFunction);
	}

	public Class<? extends Base<?>> getBaseClass() {
		return baseClass;
	}

	public void setBaseClass(Class<? extends Base<?>> baseClass) {
		this.baseClass = baseClass;
	}
	
	
}
