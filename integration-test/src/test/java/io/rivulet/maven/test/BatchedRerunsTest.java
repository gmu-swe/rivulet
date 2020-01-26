package io.rivulet.maven.test;

import edu.columbia.cs.psl.phosphor.Configuration;
import edu.columbia.cs.psl.phosphor.runtime.TaintSourceWrapper;
import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;

import io.rivulet.internal.RivuletAutoTaintWrapper;
import io.rivulet.internal.rerun.TestRerunConfiguration;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

import java.io.IOException;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

@Source(method = "io/rivulet/maven/test/TestUtils.objSource(Ljava/lang/Object;)Ljava/lang/Object;")
@Sink(method = "java/sql/Statement.executeQuery(Ljava/lang/String;)Ljava/sql/ResultSet;")
@Sink(method = "java/lang/Runtime.exec(Ljava/lang/String;)Ljava/lang/Process;")
public class BatchedRerunsTest extends ViolationCheckingBaseTest {

    @Rule
    public final ExternalResource autoTainterCheck = new ExternalResource() {
        @Override
        protected void before() {
            if(methodTaintRule.isRivuletRerun()) {
                TestRerunConfiguration config = RivuletAutoTaintWrapper.getCurrentRerunConfig();
                assertNotNull(config);
                TaintSourceWrapper autoTainter = Configuration.autoTainter;
                assertTrue(config.getAutoTainterClass().isInstance(autoTainter));
            }
        }
    };

    @Test
    @ExpectsRivuletRerun(numReruns = 1, numCriticalViolations = 1)
    public void sqlViolationTest() throws Exception {
        String taintedName = TestUtils.objSource(new String("Turtle"));
        new DummySqlStatement().executeQuery("SELECT * FROM animal WHERE name = '" + taintedName + "'");
        checkViolationsIncreased(1);
    }

    @Test
    @ExpectsRivuletRerun(numReruns = 1, numCriticalViolations = 1)
    public void rceViolationTest() throws IOException {
        String taintedCommand = TestUtils.objSource(new String("echo hello"));
        Runtime.getRuntime().exec(taintedCommand);
        checkViolationsIncreased(1);
    }
}

