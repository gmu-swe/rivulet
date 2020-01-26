package io.rivulet;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/* Used to indicate that a test method is expected to be rerun by ifc to test for critical violations and the number of
 * critical violations that should have been reported across all of the reruns of the test method. */
@Retention(RUNTIME)
@Target(METHOD)
public @interface ExpectsRivuletRerun {
    // The number of reruns expected.
    int numReruns() default ANY;
    // The number of critical violations expected.
    int numCriticalViolations() default ANY;

    // Constant representing that no reruns or critical violations are expected
    int NONE = 0;
    // Constant representing that at least one rerun or critical violation is expected
    int AT_LEAST_ONE = -1;
    // Constant representing that any number of reruns or critical violations is expected
    int ANY = -2;
}

