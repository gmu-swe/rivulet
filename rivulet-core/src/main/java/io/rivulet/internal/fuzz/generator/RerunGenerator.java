package io.rivulet.internal.fuzz.generator;

import edu.columbia.cs.psl.phosphor.struct.TaintedBooleanWithObjTag;
import io.rivulet.internal.rerun.TestRerunConfiguration;
import io.rivulet.internal.Violation;

import java.util.Collection;

/* Generates reruns to attempt to verify a violation reported during an original test run. */
public interface RerunGenerator {

	/* Returns whether this generator should create test reruns for the specified configuration. */
	 boolean isApplicable(Violation violation);

	@SuppressWarnings("unused")
	TaintedBooleanWithObjTag isApplicable$$PHOSPHORTAGGED(Violation violation, TaintedBooleanWithObjTag ret);

	/* Returns configurations for test reruns that could be used to verify the specified violation. */
	Collection<TestRerunConfiguration> generateReruns(Violation violation, Object receiver, Object[] arguments);
}
