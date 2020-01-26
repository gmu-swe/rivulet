package io.rivulet.internal;


public class EmbeddedMessage {
	protected String[] args;
	protected Object arg;
	protected MessageType type;

	public enum MessageType {
		DEPLOY_WEBAPP,
		INIT_LISTENER,
		TEST_SET_STARTED,
		TEST_STARTED,
		TEST_FAILED,
		TEST_ERRORED,
		TEST_SUCCEEDED,
		TEST_SET_ENDED,
		VIOLATIONS_INQUIRY,
		OK,
		SET_RERUN_CONFIG,
		SET_RERUNS_MODE,
		GET_RERUN_CONFIG,
		CHECK_AND_CLEAR_REACHED_SINK,
		ERROR;
	}
}
