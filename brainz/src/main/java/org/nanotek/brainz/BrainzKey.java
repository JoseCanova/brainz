package org.nanotek.brainz;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.nanotek.brainz.base.entity.BaseEntity;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Documented
public @interface BrainzKey {
	Class<? extends BaseEntity> entityClass();
	String pathName();
}
