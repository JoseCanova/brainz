package org.nanotek.brainz.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.nanotek.brainz.base.Base;
import org.nanotek.brainz.base.entity.Genre;

public interface BasePropertyUtil {

	static <K extends Base<?>> List<NameMethodPair<?>> readBaseProperties(Class<? super K> clazz)
	{
		return Stream.of(clazz.getDeclaredFields())
		.map(f -> f.getName())
		.map(fn -> getClazzReadWriteMethods(fn , clazz))
		.collect(Collectors.toList());
	}

	static <K extends Base<?>> NameMethodPair<?> getClazzReadWriteMethods(String fn, Class<? super K> clazz)
	{
		 return Stream.of(clazz.getMethods())
		.filter(m -> m.getName().equals(fn))
		.map(m -> new NameMethodPair(m.getName(),m,null))
		.reduce ((x,y) -> reducePair(x,y)).orElseThrow();
		 
//		.collect(Collectors.toList());
	}
	
	static NameMethodPair<?> reducePair(NameMethodPair<?> x, NameMethodPair<?> y) {
		List theList = Optional.ofNullable( x.methods()).orElse(new ArrayList<>());
		theList.add(y.method());
		return new NameMethodPair(x.name(),y.method(), theList);
	}

	static <S extends K , K extends Base<?>> Method  getReadMethod(String methodName , Class<? super K> clazz)
	{
		NameMethodPair nmp=  getClazzReadWriteMethods(methodName, clazz);
		List methodList =  nmp.methods();
		return Method.class.cast(methodList
		.stream()
		.filter(m -> {
			var meth = Method.class.cast(m);
			return meth.getParameterCount() ==0;
			}).findFirst().orElseThrow());
	}	
	
	
	public static void main(String[] args) {
		Class<Genre> clazz = Genre.class;
		List<?> theList = readBaseProperties(clazz);
		System.err.println(theList.toString());
		Object meth = getReadMethod("name", Genre.class);
		System.err.println(meth.toString());
		 meth = getReadMethod("id", Genre.class);
		System.err.println(meth.toString());

	}
}
