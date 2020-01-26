package io.rivulet.maven.test.webgoat;

import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import org.junit.Test;

import java.net.URI;

@Source(method = "io/rivulet/PhosphorHttpRequest.getEntityBody()Ljava/lang/String;")
@Sink(method = "java/lang/ProcessBuilder.command(Ljava/util/List;)Ljava/lang/ProcessBuilder;")
@Sink(method = "java/lang/ProcessBuilder.command([Ljava/lang/String;)Ljava/lang/ProcessBuilder;")
@Sink(method = "java/lang/ProcessBuilder.<init>(Ljava/util/List;)V")
@Sink(method = "java/lang/ProcessBuilder.<init>([Ljava/lang/String;)V")
@Sink(method = "java/lang/Runtime.exec(Ljava/lang/String;)Ljava/lang/Process;")
@Sink(method = "java/lang/Runtime.exec(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/Process;")
@Sink(method = "java/lang/Runtime.exec(Ljava/lang/String;[Ljava/lang/String;Ljava/io/File;)Ljava/lang/Process;")
@Sink(method = "java/lang/Runtime.exec([Ljava/lang/String;)Ljava/lang/Process;")
@Sink(method = "java/lang/Runtime.exec([Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/Process;")
@Sink(method = "java/lang/Runtime.exec([Ljava/lang/String;[Ljava/lang/String;Ljava/io/File;)Ljava/lang/Process;")
public class WebGoatCommandInjectionTest extends WebGoatBaseTest {

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testCommandInjection() throws Exception {
        try {
            URI uri = getBaseURIBuilderForLesson("Command Injection").build();
            postWithForm(uri, "HelpFile=AccessControlMatrix.help&SUBMIT=View");
        } catch(Exception e) {
            if(!methodTaintRule.isRivuletRerun()) {
                throw e;
            }
        }
    }
}


