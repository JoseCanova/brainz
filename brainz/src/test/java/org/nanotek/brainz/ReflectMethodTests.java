package org.nanotek.brainz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.nanotek.brainz.base.entity.Area;
import org.nanotek.brainz.base.record.AreaRecord;

public class ReflectMethodTests {

	
	@Test
	public void testMethodScanning() {
		Class<Area> clazz = Area.class;
		Field[] fields = clazz.getDeclaredFields();
		System.err.println(fields.length);
		Class<AreaRecord> clazzR = AreaRecord.class;
		Field[] fieldsR = clazzR.getDeclaredFields();
		System.err.println(fieldsR.length);
		Method[] methR = clazzR.getDeclaredMethods();
		System.err.println(methR.length);
		Stream.of(methR)
		.forEach(m -> System.err.println(m.getName()));
		
		Method[] meth = clazz.getDeclaredMethods();
		System.err.println(meth.length);
		Stream.of(meth)
		.forEach(m -> System.err.println(m.getName()));
		Constructor<?>[] constructors = AreaRecord.class.getDeclaredConstructors(); 
		
		Stream
		.of(constructors)
		.filter(c -> c.getParameterCount()>0)
		.forEach(c ->{
			Stream.of( c.getParameters())
			.forEach(p -> {
				System.out.println(p.getName());
			});
		});
		
		
	}
	
}
