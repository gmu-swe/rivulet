package io.rivulet.internal.rerun;

/* Used to generate a rerun where only one value that reached a sink in the original test run needs to be replaced. */
public class SinglePayloadRerunConfigBuilder extends RerunConfigBuilder {

    public SinglePayloadRerunConfigBuilder(Object replacementValue) {
        ReplacementBuilder builder = new ReplacementImplBuilder()
                .isPayload(true)
                .required(true)
                .value(replacementValue);
        addReplacementBuilder(builder);
    }
}
