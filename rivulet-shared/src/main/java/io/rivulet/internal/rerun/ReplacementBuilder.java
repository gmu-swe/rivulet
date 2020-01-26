package io.rivulet.internal.rerun;

import io.rivulet.internal.Violation;

import java.util.LinkedHashSet;

/* Generates Replacements based on supplied criteria. */
public interface ReplacementBuilder {

    /* Returns whether or not at least one replacement generated from this builder must be included in a rerun configuration
     * for the configuration to be considered valid. */
    boolean isRequiredForGeneration();

    /* Returns a set of Replacements containing all of the valid combinations that can be built from this builder. */
    LinkedHashSet<Replacement> build(Violation violation);
}
