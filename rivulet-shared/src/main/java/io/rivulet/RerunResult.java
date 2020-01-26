package io.rivulet;

/* Used to indicate the result of an Rivulet generated rerun with respect to whether it reported a critical violation. */
public enum RerunResult {
    CRITICAL_VIOLATION("Critical violation criteria met."),
    REPLACEMENT_FAILURE("Value replacement unsuccessful."),
    SINK_REACHED("Failed to meet critical violation criteria."),
    FAILED_TO_REACH("Failed to reach a targeted sink."),
    SKIPPED("Skipped");

    public final String message;
    RerunResult(String message) {
        this.message = message;
    }
}
