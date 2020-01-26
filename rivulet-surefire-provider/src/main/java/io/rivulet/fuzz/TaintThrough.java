package io.rivulet.fuzz;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/* Specifies a taintThrough method that should be used for a particular test case or test class. */
@Repeatable(TaintThroughs.class)
@Retention(RUNTIME)
@Target({METHOD, TYPE})
public @interface TaintThrough {
    String method();
}

