package ch1;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//@Documented
@Inherited
@Target(ElementType.TYPE)
public @interface TestAnno {
	int id() default -1;
	String msg() default "hi";
}
