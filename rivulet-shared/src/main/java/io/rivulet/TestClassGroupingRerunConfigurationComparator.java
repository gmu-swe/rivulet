package io.rivulet;

import io.rivulet.internal.rerun.Replacement;
import io.rivulet.internal.rerun.TestRerunConfiguration;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

/* Comparator for partially ordering TestRerunConfigurations. */
public class TestClassGroupingRerunConfigurationComparator implements Comparator<TestRerunConfiguration>, Serializable {

    private static final long serialVersionUID = -5972509445208202491L;

    @Override
    public int compare(TestRerunConfiguration c1, TestRerunConfiguration c2) {
        // Compare test class names
        int compare = c1.getTestClass().compareTo(c2.getTestClass());
        if(compare != 0) {
            return compare;
        }
        // Compare autoTainter class names
        compare = c1.getAutoTainterClass().getName().compareTo(c2.getAutoTainterClass().getName());
        if(compare != 0) {
            return compare;
        }
        // Compare number of required replacements
        compare = c1.numberOfRequiredReplacements() - c2.numberOfRequiredReplacements();
        if(compare != 0) {
            // Return a positive number if c1 has more required replacements than c2
            // Return a negative number if c1 has fewer required replacements than c2
            return compare;
        }
        // Compare the overall number of replacements
        compare = c1.getReplacementsCopy().size() - c2.getReplacementsCopy().size();
        if(compare != 0) {
            // Return a positive number if c1 has more replacements than c2
            // Return a negative number if c1 has fewer replacements than c2
            return compare;
        }
        // Compare replacement sets
        Iterator<Replacement> it1 = c1.getReplacementsCopy().iterator();
        Iterator<Replacement> it2 = c2.getReplacementsCopy().iterator();
        while(it1.hasNext() && it2.hasNext()) {
            compare = ReplacementComparator.getInstance().compare(it1.next(), it2.next());
            if(compare != 0) {
                return compare;
            }
        }
        // Compare test method names
        compare = c1.getTestMethod().compareTo(c2.getTestMethod());
        if(compare != 0) {
            return compare;
        }
        return 0;
    }

    /* Provides access to the single instance of RerunConfigurationComparator. */
    public static TestClassGroupingRerunConfigurationComparator getInstance() {
        return TestClassGroupingRerunConfigurationComparatorSingleton.INSTANCE;
    }

    /* Inner class used to provide access to the single instance of RerunConfigurationComparator and ensure that only one
     * instance of RerunConfigurationComparator is ever created. */
    private static class TestClassGroupingRerunConfigurationComparatorSingleton {
        private static final TestClassGroupingRerunConfigurationComparator INSTANCE = new TestClassGroupingRerunConfigurationComparator();
    }
}