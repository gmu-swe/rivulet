package io.rivulet.internal.fuzz.generator;

import io.rivulet.internal.rerun.RerunConfigBuilder;
import io.rivulet.internal.rerun.SinglePayloadRerunConfigBuilder;
import io.rivulet.internal.Violation;

import java.util.Arrays;
import java.util.List;

public class RCEGenerator extends RerunGeneratorWrapper {

	protected static final String EXEC_COMMAND= "ls";
	private static final String START_METHOD = "java/lang/ProcessBuilder.start()Ljava/lang/Process;";

	@Override
	public Iterable<? extends RerunConfigBuilder> generateRerunBuilders(Violation violation, Object receiver, Object[] arguments) {
		return Arrays.asList(
				new SinglePayloadRerunConfigBuilder(EXEC_COMMAND),
				new SinglePayloadRerunConfigBuilder("echo 1"));
	}

	/* Checks the command array of the ProcessBuilder when ProcessBuilder.start is called. */
	@Override
	public synchronized void checkTaint(Object self, Object[] arguments, String baseSink, String actualSink) {
		if(baseSink.equals(START_METHOD) && self instanceof ProcessBuilder) {
			try {
				super.checkTaint(self, new Object[]{((ProcessBuilder)self).command()}, baseSink, actualSink);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			super.checkTaint(self, arguments, baseSink, actualSink);
		}
	}

	@Override
	public List<String> getTargetedBaseSinks() {
		return Arrays.asList(
				START_METHOD,
				"java/lang/ProcessBuilder.command(Ljava/util/List;)Ljava/lang/ProcessBuilder;",
				"java/lang/ProcessBuilder.command([Ljava/lang/String;)Ljava/lang/ProcessBuilder;",
				"java/lang/ProcessBuilder.<init>(Ljava/util/List;)V",
				"java/lang/ProcessBuilder.<init>([Ljava/lang/String;)V",
				"java/lang/Runtime.exec(Ljava/lang/String;)Ljava/lang/Process;",
				"java/lang/Runtime.exec(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/Process;",
				"java/lang/Runtime.exec(Ljava/lang/String;[Ljava/lang/String;Ljava/io/File;)Ljava/lang/Process;",
				"java/lang/Runtime.exec([Ljava/lang/String;)Ljava/lang/Process;",
				"java/lang/Runtime.exec([Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/Process;",
				"java/lang/Runtime.exec([Ljava/lang/String;[Ljava/lang/String;Ljava/io/File;)Ljava/lang/Process;"
		);
	}
}
