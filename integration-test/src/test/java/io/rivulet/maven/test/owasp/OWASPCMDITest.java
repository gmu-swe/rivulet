package io.rivulet.maven.test.owasp;

import io.rivulet.ExpectsRivuletRerun;
import org.junit.Test;

public class OWASPCMDITest extends OWASPBaseTest {
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00006() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00006", "POST", "answer", "Hello", "BenchmarkTest00006", "ECHOOO", "BenchmarkTest00006Area", "Hello", "annoyingAJAX", "BenchmarkTest00006");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00007() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00007", "POST", "answer", "Hello", "BenchmarkTest00007", "FOO=echo Injection", "BenchmarkTest00007Area", "Hello", "annoyingAJAX", "BenchmarkTest00007");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00015() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00015", "POST", "answer", "Hello", "BenchmarkTest00015", "ECHOOO", "BenchmarkTest00015Area", "Hello", "annoyingAJAX", "BenchmarkTest00015");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00017() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00017", "POST", "answer", "Hello", "BenchmarkTest00017", "ls", "BenchmarkTest00017Area", "Hello", "annoyingAJAX", "BenchmarkTest00017");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00051() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00051", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00051", "ECHOOO");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00077() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00077", "POST");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00090() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00090", "POST");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00091() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00091", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00092() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00092", "POST");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00093() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00093", "POST");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00158() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00158", "POST", "answer", "Hello", "BenchmarkTest00158", "ECHOOO", "BenchmarkTest00158Area", "Hello", "annoyingAJAX", "BenchmarkTest00158");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00159() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00159", "POST", "answer", "Hello", "BenchmarkTest00159", "ECHOOO", "BenchmarkTest00159Area", "Hello", "annoyingAJAX", "BenchmarkTest00159");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00171() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00171", "POST", "answer", "Hello", "BenchmarkTest00171", ".", "BenchmarkTest00171Area", "Hello", "annoyingAJAX", "BenchmarkTest00171");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00172() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00172", "POST", "answer", "Hello", "BenchmarkTest00172", "FOO=echo Injection", "BenchmarkTest00172Area", "Hello", "annoyingAJAX", "BenchmarkTest00172");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00173() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00173", "POST", "answer", "Hello", "BenchmarkTest00173", "FOO=echo Injection", "BenchmarkTest00173Area", "Hello", "annoyingAJAX", "BenchmarkTest00173");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00174() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00174", "POST", "answer", "Hello", "BenchmarkTest00174", "FOO=echo Injection", "BenchmarkTest00174Area", "Hello", "annoyingAJAX", "BenchmarkTest00174");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00175() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00175", "POST", "answer", "Hello", "BenchmarkTest00175", "FOO=echo Injection", "BenchmarkTest00175Area", "Hello", "annoyingAJAX", "BenchmarkTest00175");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00176() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00176", "POST", "answer", "Hello", "BenchmarkTest00176", "ls", "BenchmarkTest00176Area", "Hello", "annoyingAJAX", "BenchmarkTest00176");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00177() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00177", "POST", "answer", "Hello", "BenchmarkTest00177", "ls", "BenchmarkTest00177Area", "Hello", "annoyingAJAX", "BenchmarkTest00177");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00293() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00293", "POST", "answer", "Hello", "BenchmarkTest00293", "ECHOOO", "BenchmarkTest00293Area", "Hello", "annoyingAJAX", "BenchmarkTest00293");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00294() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00294", "POST", "answer", "Hello", "BenchmarkTest00294", "ECHOOO", "BenchmarkTest00294Area", "Hello", "annoyingAJAX", "BenchmarkTest00294");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00295() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00295", "POST", "answer", "Hello", "BenchmarkTest00295", "ECHOOO", "BenchmarkTest00295Area", "Hello", "annoyingAJAX", "BenchmarkTest00295");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00302() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00302", "POST", "answer", "Hello", "BenchmarkTest00302", "ls", "BenchmarkTest00302Area", "Hello", "annoyingAJAX", "BenchmarkTest00302");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00303() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00303", "POST", "answer", "Hello", "BenchmarkTest00303", "localhost", "BenchmarkTest00303Area", "Hello", "annoyingAJAX", "BenchmarkTest00303");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00304() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00304", "POST", "answer", "Hello", "BenchmarkTest00304", ".", "BenchmarkTest00304Area", "Hello", "annoyingAJAX", "BenchmarkTest00304");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00305() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00305", "POST", "answer", "Hello", "BenchmarkTest00305", ".", "BenchmarkTest00305Area", "Hello", "annoyingAJAX", "BenchmarkTest00305");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00306() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00306", "POST", "answer", "Hello", "BenchmarkTest00306", "FOO=echo Injection", "BenchmarkTest00306Area", "Hello", "annoyingAJAX", "BenchmarkTest00306");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00307() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00307", "POST", "answer", "Hello", "BenchmarkTest00307", "ls", "BenchmarkTest00307Area", "Hello", "annoyingAJAX", "BenchmarkTest00307");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00308() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00308", "POST", "answer", "Hello", "BenchmarkTest00308", "ls", "BenchmarkTest00308Area", "Hello", "annoyingAJAX", "BenchmarkTest00308");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00309() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00309", "POST", "answer", "Hello", "BenchmarkTest00309", "FOO=echo Injection", "BenchmarkTest00309Area", "Hello", "annoyingAJAX", "BenchmarkTest00309");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00310() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00310", "POST", "answer", "Hello", "BenchmarkTest00310", "ls", "BenchmarkTest00310Area", "Hello", "annoyingAJAX", "BenchmarkTest00310");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00311() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00311", "POST", "answer", "Hello", "BenchmarkTest00311", "FOO=echo Injection", "BenchmarkTest00311Area", "Hello", "annoyingAJAX", "BenchmarkTest00311");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00396() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00396", "POST", "BenchmarkTest00396", "ECHOOO");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00406() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00406", "POST", "BenchmarkTest00406", "localhost");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00407() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00407", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00407", ".");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00408() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00408", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00408", ".");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00409() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00409", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00409", ".");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00410() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00410", "POST", "BenchmarkTest00410", "FOO=echo Injection", "BenchmarkTest00410", "Movies", "BenchmarkTest00410", "Writing", "BenchmarkTest00410", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00411() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00411", "POST", "BenchmarkTest00411", "FOO=echo Injection");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00412() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00412", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00412", "FOO=echo Injection");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00480() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00480", "POST", "BenchmarkTest00480", "ECHOOO", "BenchmarkTest00480", "Movies", "BenchmarkTest00480", "Writing", "BenchmarkTest00480", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00481() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00481", "POST", "BenchmarkTest00481", "ECHOOO");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00494() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00494", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00494", "localhost");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00495() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00495", "POST", "BenchmarkTest00495", "FOO=echo Injection", "BenchmarkTest00495", "Movies", "BenchmarkTest00495", "Writing", "BenchmarkTest00495", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00496() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00496", "POST", "BenchmarkTest00496", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00497() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00497", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00497", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00498() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00498", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00498", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00499() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00499", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00499", "ls");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00500() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00500", "POST", "BenchmarkTest00500", "ls", "BenchmarkTest00500", "Movies", "BenchmarkTest00500", "Writing", "BenchmarkTest00500", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00558() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00558", "POST", "answer", "Hello", "BenchmarkTest00558", "ECHOOO", "BenchmarkTest00558Area", "Hello", "annoyingAJAX", "BenchmarkTest00558");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00559() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00559", "POST", "answer", "Hello", "BenchmarkTest00559", "ECHOOO", "BenchmarkTest00559Area", "Hello", "annoyingAJAX", "BenchmarkTest00559");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00567() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00567", "POST", "answer", "Hello", "BenchmarkTest00567", "ls", "BenchmarkTest00567Area", "Hello", "annoyingAJAX", "BenchmarkTest00567");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00568() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00568", "POST", "answer", "Hello", "BenchmarkTest00568", ".", "BenchmarkTest00568Area", "Hello", "annoyingAJAX", "BenchmarkTest00568");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00569() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00569", "POST", "answer", "Hello", "BenchmarkTest00569", ".", "BenchmarkTest00569Area", "Hello", "annoyingAJAX", "BenchmarkTest00569");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00570() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00570", "POST", "answer", "Hello", "BenchmarkTest00570", "FOO=echo Injection", "BenchmarkTest00570Area", "Hello", "annoyingAJAX", "BenchmarkTest00570");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00571() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00571", "POST", "answer", "Hello", "BenchmarkTest00571", "FOO=echo Injection", "BenchmarkTest00571Area", "Hello", "annoyingAJAX", "BenchmarkTest00571");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00572() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00572", "POST", "answer", "Hello", "BenchmarkTest00572", "ls", "BenchmarkTest00572Area", "Hello", "annoyingAJAX", "BenchmarkTest00572");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00573() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00573", "POST", "answer", "Hello", "BenchmarkTest00573", "FOO=echo Injection", "BenchmarkTest00573Area", "Hello", "annoyingAJAX", "BenchmarkTest00573");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00574() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00574", "POST", "answer", "Hello", "BenchmarkTest00574", "FOO=echo Injection", "BenchmarkTest00574Area", "Hello", "annoyingAJAX", "BenchmarkTest00574");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00575() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00575", "POST", "answer", "Hello", "BenchmarkTest00575", "ls", "BenchmarkTest00575Area", "Hello", "annoyingAJAX", "BenchmarkTest00575");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00576() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00576", "POST", "answer", "Hello", "BenchmarkTest00576", "ls", "BenchmarkTest00576Area", "Hello", "annoyingAJAX", "BenchmarkTest00576");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00657() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00657", "POST", "BenchmarkTest00657", "ls", "BenchmarkTest00657", "Movies", "BenchmarkTest00657", "Writing", "BenchmarkTest00657", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00658() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00658", "POST", "BenchmarkTest00658", "ls");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00659() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00659", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00659", "ls");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00731() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00731", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00731", "ECHOOO");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00732() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00732", "POST", "BenchmarkTest00732", "ECHOOO", "BenchmarkTest00732", "Movies", "BenchmarkTest00732", "Writing", "BenchmarkTest00732", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00738() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00738", "POST", "BenchmarkTest00738", ".");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00739() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00739", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00739", ".");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00740() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00740", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00740", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00741() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00741", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00741", "ls");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00742() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00742", "POST", "BenchmarkTest00742", "ls", "BenchmarkTest00742", "Movies", "BenchmarkTest00742", "Writing", "BenchmarkTest00742", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00743() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00743", "POST", "BenchmarkTest00743", "FOO=echo Injection");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00814() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00814", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00814", "ECHOOO");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00815() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00815", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00815", "ECHOOO");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00816() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00816", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00816", "ECHOOO");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00823() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00823", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00823", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00824() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00824", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00824", ".");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00825() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00825", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00825", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00826() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00826", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00826", "ls");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00827() throws Exception {
		submitForm("/owasp-benchmark/cmdi-00/BenchmarkTest00827", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00827", "FOO=echo Injection");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00895() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00895", "POST", "BenchmarkTest00895", "ECHOOO", "BenchmarkTest00895", "Movies", "BenchmarkTest00895", "Writing", "BenchmarkTest00895", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00896() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00896", "POST", "BenchmarkTest00896", "ECHOOO");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00897() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00897", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00897", "ECHOOO");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00905() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00905", "POST", "BenchmarkTest00905", "localhost", "BenchmarkTest00905", "Movies", "BenchmarkTest00905", "Writing", "BenchmarkTest00905", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00906() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00906", "POST", "BenchmarkTest00906", "localhost");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00907() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00907", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00907", "localhost");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00908() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00908", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00908", "FOO=echo Injection");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00909() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00909", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00909", "FOO=echo Injection");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00910() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00910", "POST", "BenchmarkTest00910", "ls", "BenchmarkTest00910", "Movies", "BenchmarkTest00910", "Writing", "BenchmarkTest00910", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00968() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00968", "POST");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00969() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00969", "POST");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00970() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00970", "POST");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00978() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00978", "POST");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00979() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00979", "POST");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00980() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00980", "POST");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00981() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00981", "POST");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00982() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00982", "POST");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00983() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest00983", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01064() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01064", "POST", "answer", "Hello", "BenchmarkTest01064", "ls", "BenchmarkTest01064Area", "Hello", "annoyingAJAX", "BenchmarkTest01064");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01065() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01065", "POST", "answer", "Hello", "BenchmarkTest01065", "localhost", "BenchmarkTest01065Area", "Hello", "annoyingAJAX", "BenchmarkTest01065");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01066() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01066", "POST", "answer", "Hello", "BenchmarkTest01066", "FOO=echo Injection", "BenchmarkTest01066Area", "Hello", "annoyingAJAX", "BenchmarkTest01066");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01067() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01067", "POST", "answer", "Hello", "BenchmarkTest01067", "FOO=echo Injection", "BenchmarkTest01067Area", "Hello", "annoyingAJAX", "BenchmarkTest01067");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01068() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01068", "POST", "answer", "Hello", "BenchmarkTest01068", "ls", "BenchmarkTest01068Area", "Hello", "annoyingAJAX", "BenchmarkTest01068");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01182() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01182", "POST", "answer", "Hello", "BenchmarkTest01182", "ECHOOO", "BenchmarkTest01182Area", "Hello", "annoyingAJAX", "BenchmarkTest01182");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01189() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01189", "POST", "answer", "Hello", "BenchmarkTest01189", "localhost", "BenchmarkTest01189Area", "Hello", "annoyingAJAX", "BenchmarkTest01189");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01190() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01190", "POST", "answer", "Hello", "BenchmarkTest01190", "FOO=echo Injection", "BenchmarkTest01190Area", "Hello", "annoyingAJAX", "BenchmarkTest01190");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01191() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01191", "POST", "answer", "Hello", "BenchmarkTest01191", "FOO=echo Injection", "BenchmarkTest01191Area", "Hello", "annoyingAJAX", "BenchmarkTest01191");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01192() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01192", "POST", "answer", "Hello", "BenchmarkTest01192", "FOO=echo Injection", "BenchmarkTest01192Area", "Hello", "annoyingAJAX", "BenchmarkTest01192");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01193() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01193", "POST", "answer", "Hello", "BenchmarkTest01193", ".", "BenchmarkTest01193Area", "Hello", "annoyingAJAX", "BenchmarkTest01193");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01194() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01194", "POST", "answer", "Hello", "BenchmarkTest01194", "ls", "BenchmarkTest01194Area", "Hello", "annoyingAJAX", "BenchmarkTest01194");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01269() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01269", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01269", "ECHOOO");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01270() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01270", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01270", "ECHOOO");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01285() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01285", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01285", "ls");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01286() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01286", "POST", "BenchmarkTest01286", "localhost", "BenchmarkTest01286", "Movies", "BenchmarkTest01286", "Writing", "BenchmarkTest01286", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01287() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01287", "POST", "BenchmarkTest01287", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01288() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01288", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01288", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01289() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01289", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01289", "ls");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01290() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01290", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01290", "FOO=echo Injection");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01353() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01353", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01353", "ECHOOO");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01360() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01360", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01360", "ls");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01361() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01361", "POST", "BenchmarkTest01361", "FOO=echo Injection", "BenchmarkTest01361", "Movies", "BenchmarkTest01361", "Writing", "BenchmarkTest01361", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01362() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01362", "POST", "BenchmarkTest01362", ".");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01363() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01363", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01363", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01364() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01364", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01364", "FOO=echo Injection");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01365() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01365", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01365", "ls");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01430() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01430", "POST", "answer", "Hello", "BenchmarkTest01430", "ECHOOO", "BenchmarkTest01430Area", "Hello", "annoyingAJAX", "BenchmarkTest01430");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01440() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01440", "POST", "answer", "Hello", "BenchmarkTest01440", "ls", "BenchmarkTest01440Area", "Hello", "annoyingAJAX", "BenchmarkTest01440");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01441() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01441", "POST", "answer", "Hello", "BenchmarkTest01441", "localhost", "BenchmarkTest01441Area", "Hello", "annoyingAJAX", "BenchmarkTest01441");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01442() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01442", "POST", "answer", "Hello", "BenchmarkTest01442", "FOO=echo Injection", "BenchmarkTest01442Area", "Hello", "annoyingAJAX", "BenchmarkTest01442");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01443() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01443", "POST", "answer", "Hello", "BenchmarkTest01443", "ls", "BenchmarkTest01443Area", "Hello", "annoyingAJAX", "BenchmarkTest01443");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01444() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01444", "POST", "answer", "Hello", "BenchmarkTest01444", "FOO=echo Injection", "BenchmarkTest01444Area", "Hello", "annoyingAJAX", "BenchmarkTest01444");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01445() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01445", "POST", "answer", "Hello", "BenchmarkTest01445", "FOO=echo Injection", "BenchmarkTest01445Area", "Hello", "annoyingAJAX", "BenchmarkTest01445");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01446() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01446", "POST", "answer", "Hello", "BenchmarkTest01446", "ls", "BenchmarkTest01446Area", "Hello", "annoyingAJAX", "BenchmarkTest01446");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01516() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01516", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01516", "ECHOOO");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01517() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01517", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01517", "ECHOOO");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01526() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01526", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01526", "ls");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01527() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01527", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01527", "ls");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01528() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01528", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01528", "ls");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01529() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01529", "POST", "BenchmarkTest01529", "localhost", "BenchmarkTest01529", "Movies", "BenchmarkTest01529", "Writing", "BenchmarkTest01529", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01530() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01530", "POST", "BenchmarkTest01530", ".");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01531() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01531", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01531", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01532() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01532", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01532", "ls");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01533() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01533", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01533", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01600() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01600", "POST", "BenchmarkTest01600", "ECHOOO");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01601() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01601", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01601", "ECHOOO");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01606() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01606", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01606", "ls");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01607() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01607", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01607", "localhost");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01608() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01608", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01608", "FOO=echo Injection");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01609() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01609", "POST", "BenchmarkTest01609", "ls", "BenchmarkTest01609", "Movies", "BenchmarkTest01609", "Writing", "BenchmarkTest01609", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01610() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01610", "POST", "BenchmarkTest01610", "ls");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01672() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01672", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01672", "ECHOOO");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01673() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01673", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01673", "ECHOOO");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01674() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01674", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01674", "ECHOOO");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01685() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01685", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01685", ".");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01686() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01686", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01686", "FOO=echo Injection");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01687() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01687", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01687", ".");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01688() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01688", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01688", "ls");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01689() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01689", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01689", "ls");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01690() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01690", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01690", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01691() throws Exception {
		submitForm("/owasp-benchmark/cmdi-01/BenchmarkTest01691", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01691", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01692() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01692", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01692", "ls");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01693() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01693", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01693", "ls");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01778() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01778", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01778", "ECHOOO");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01779() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01779", "POST", "BenchmarkTest01779", "ECHOOO", "BenchmarkTest01779", "Movies", "BenchmarkTest01779", "Writing", "BenchmarkTest01779", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01780() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01780", "POST", "BenchmarkTest01780", "ECHOOO");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01791() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01791", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01791", "ls");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01792() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01792", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01792", ".");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01793() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01793", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01793", "FOO=echo Injection");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01794() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01794", "POST", "BenchmarkTest01794", ".", "BenchmarkTest01794", "Movies", "BenchmarkTest01794", "Writing", "BenchmarkTest01794", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01795() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01795", "POST", "BenchmarkTest01795", "FOO=echo Injection");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01796() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01796", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01796", "FOO=echo Injection");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01850() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01850", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01851() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01851", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01852() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01852", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01864() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01864", "POST");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01865() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01865", "POST");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01928() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01928", "POST", "answer", "Hello", "BenchmarkTest01928", "ECHOOO", "BenchmarkTest01928Area", "Hello", "annoyingAJAX", "BenchmarkTest01928");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01929() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01929", "POST", "answer", "Hello", "BenchmarkTest01929", "ECHOOO", "BenchmarkTest01929Area", "Hello", "annoyingAJAX", "BenchmarkTest01929");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01936() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01936", "POST", "answer", "Hello", "BenchmarkTest01936", "ls", "BenchmarkTest01936Area", "Hello", "annoyingAJAX", "BenchmarkTest01936");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01937() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01937", "POST", "answer", "Hello", "BenchmarkTest01937", "ls", "BenchmarkTest01937Area", "Hello", "annoyingAJAX", "BenchmarkTest01937");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01938() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01938", "POST", "answer", "Hello", "BenchmarkTest01938", ".", "BenchmarkTest01938Area", "Hello", "annoyingAJAX", "BenchmarkTest01938");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01939() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01939", "POST", "answer", "Hello", "BenchmarkTest01939", "FOO=echo Injection", "BenchmarkTest01939Area", "Hello", "annoyingAJAX", "BenchmarkTest01939");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01940() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01940", "POST", "answer", "Hello", "BenchmarkTest01940", "ls", "BenchmarkTest01940Area", "Hello", "annoyingAJAX", "BenchmarkTest01940");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01941() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01941", "POST", "answer", "Hello", "BenchmarkTest01941", "FOO=echo Injection", "BenchmarkTest01941Area", "Hello", "annoyingAJAX", "BenchmarkTest01941");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01942() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01942", "POST", "answer", "Hello", "BenchmarkTest01942", "ls", "BenchmarkTest01942Area", "Hello", "annoyingAJAX", "BenchmarkTest01942");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01943() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01943", "POST", "answer", "Hello", "BenchmarkTest01943", "ls", "BenchmarkTest01943Area", "Hello", "annoyingAJAX", "BenchmarkTest01943");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01944() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest01944", "POST", "answer", "Hello", "BenchmarkTest01944", "ls", "BenchmarkTest01944Area", "Hello", "annoyingAJAX", "BenchmarkTest01944");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02058() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02058", "POST", "answer", "Hello", "BenchmarkTest02058", "ECHOOO", "BenchmarkTest02058Area", "Hello", "annoyingAJAX", "BenchmarkTest02058");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02059() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02059", "POST", "answer", "Hello", "BenchmarkTest02059", "ECHOOO", "BenchmarkTest02059Area", "Hello", "annoyingAJAX", "BenchmarkTest02059");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02067() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02067", "POST", "answer", "Hello", "BenchmarkTest02067", ".", "BenchmarkTest02067Area", "Hello", "annoyingAJAX", "BenchmarkTest02067");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02068() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02068", "POST", "answer", "Hello", "BenchmarkTest02068", "FOO=echo Injection", "BenchmarkTest02068Area", "Hello", "annoyingAJAX", "BenchmarkTest02068");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02069() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02069", "POST", "answer", "Hello", "BenchmarkTest02069", "ls", "BenchmarkTest02069Area", "Hello", "annoyingAJAX", "BenchmarkTest02069");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02070() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02070", "POST", "answer", "Hello", "BenchmarkTest02070", "FOO=echo Injection", "BenchmarkTest02070Area", "Hello", "annoyingAJAX", "BenchmarkTest02070");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02137() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02137", "POST", "BenchmarkTest02137", "ECHOOO");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02146() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02146", "POST", "BenchmarkTest02146", "ls", "BenchmarkTest02146", "Movies", "BenchmarkTest02146", "Writing", "BenchmarkTest02146", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02147() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02147", "POST", "BenchmarkTest02147", "ls");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02148() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02148", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02148", ".");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02149() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02149", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02149", ".");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02150() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02150", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02150", ".");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02151() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02151", "POST", "BenchmarkTest02151", ".", "BenchmarkTest02151", "Movies", "BenchmarkTest02151", "Writing", "BenchmarkTest02151", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02152() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02152", "POST", "BenchmarkTest02152", ".");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02153() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02153", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02153", "FOO=echo Injection");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02154() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02154", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02154", "ls");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02155() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02155", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02155", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02156() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02156", "POST", "BenchmarkTest02156", "FOO=echo Injection", "BenchmarkTest02156", "Movies", "BenchmarkTest02156", "Writing", "BenchmarkTest02156", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02242() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02242", "POST", "BenchmarkTest02242", "ECHOOO");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02243() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02243", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02243", "ECHOOO");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02244() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02244", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02244", "ECHOOO");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02249() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02249", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02249", "ls");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02250() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02250", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02250", "ls");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02251() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02251", "POST", "BenchmarkTest02251", "localhost", "BenchmarkTest02251", "Movies", "BenchmarkTest02251", "Writing", "BenchmarkTest02251", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02252() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02252", "POST", "BenchmarkTest02252", ".");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02253() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02253", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02253", ".");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02333() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02333", "POST", "answer", "Hello", "BenchmarkTest02333", "ECHOOO", "BenchmarkTest02333Area", "Hello", "annoyingAJAX", "BenchmarkTest02333");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02334() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02334", "POST", "answer", "Hello", "BenchmarkTest02334", "ECHOOO", "BenchmarkTest02334Area", "Hello", "annoyingAJAX", "BenchmarkTest02334");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02335() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02335", "POST", "answer", "Hello", "BenchmarkTest02335", "ECHOOO", "BenchmarkTest02335Area", "Hello", "annoyingAJAX", "BenchmarkTest02335");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02336() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02336", "POST", "answer", "Hello", "BenchmarkTest02336", "ECHOOO", "BenchmarkTest02336Area", "Hello", "annoyingAJAX", "BenchmarkTest02336");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02340() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02340", "POST", "answer", "Hello", "BenchmarkTest02340", ".", "BenchmarkTest02340Area", "Hello", "annoyingAJAX", "BenchmarkTest02340");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02341() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02341", "POST", "answer", "Hello", "BenchmarkTest02341", "FOO=echo Injection", "BenchmarkTest02341Area", "Hello", "annoyingAJAX", "BenchmarkTest02341");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02342() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02342", "POST", "answer", "Hello", "BenchmarkTest02342", "ls", "BenchmarkTest02342Area", "Hello", "annoyingAJAX", "BenchmarkTest02342");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02343() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02343", "POST", "answer", "Hello", "BenchmarkTest02343", "ls", "BenchmarkTest02343Area", "Hello", "annoyingAJAX", "BenchmarkTest02343");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02344() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02344", "POST", "answer", "Hello", "BenchmarkTest02344", "FOO=echo Injection", "BenchmarkTest02344Area", "Hello", "annoyingAJAX", "BenchmarkTest02344");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02411() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02411", "POST", "BenchmarkTest02411", "ECHOOO");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02412() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02412", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02412", "ECHOOO");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02413() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02413", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02413", "ECHOOO");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02414() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02414", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02414", "ECHOOO");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02428() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02428", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02428", "ls");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02429() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02429", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02429", "localhost");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02430() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02430", "POST", "BenchmarkTest02430", ".", "BenchmarkTest02430", "Movies", "BenchmarkTest02430", "Writing", "BenchmarkTest02430", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02431() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02431", "POST", "BenchmarkTest02431", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02432() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02432", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02432", ".");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02433() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02433", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02433", ".");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02496() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02496", "POST", "BenchmarkTest02496", "ECHOOO");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02510() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02510", "POST", "BenchmarkTest02510", "FOO=echo Injection", "BenchmarkTest02510", "Movies", "BenchmarkTest02510", "Writing", "BenchmarkTest02510", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02511() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02511", "POST", "BenchmarkTest02511", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02512() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02512", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02512", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02513() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02513", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02513", "FOO=echo Injection");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02514() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02514", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02514", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02515() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02515", "POST", "BenchmarkTest02515", "FOO=echo Injection", "BenchmarkTest02515", "Movies", "BenchmarkTest02515", "Writing", "BenchmarkTest02515", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02516() throws Exception {
		submitForm("/owasp-benchmark/cmdi-02/BenchmarkTest02516", "POST", "BenchmarkTest02516", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02517() throws Exception {
		submitForm("/owasp-benchmark/cmdi-03/BenchmarkTest02517", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02517", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02518() throws Exception {
		submitForm("/owasp-benchmark/cmdi-03/BenchmarkTest02518", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02518", "FOO=echo Injection");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02610() throws Exception {
		submitForm("/owasp-benchmark/cmdi-03/BenchmarkTest02610", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02610", ".");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02611() throws Exception {
		submitForm("/owasp-benchmark/cmdi-03/BenchmarkTest02611", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02611", ".");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02612() throws Exception {
		submitForm("/owasp-benchmark/cmdi-03/BenchmarkTest02612", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02612", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02613() throws Exception {
		submitForm("/owasp-benchmark/cmdi-03/BenchmarkTest02613", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02613", "FOO=echo Injection");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02697() throws Exception {
		submitForm("/owasp-benchmark/cmdi-03/BenchmarkTest02697", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02697", "ECHOOO");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02698() throws Exception {
		submitForm("/owasp-benchmark/cmdi-03/BenchmarkTest02698", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02698", "ECHOOO");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02699() throws Exception {
		submitForm("/owasp-benchmark/cmdi-03/BenchmarkTest02699", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02699", "ECHOOO");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02713() throws Exception {
		submitForm("/owasp-benchmark/cmdi-03/BenchmarkTest02713", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02713", "FOO=echo Injection");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02714() throws Exception {
		submitForm("/owasp-benchmark/cmdi-03/BenchmarkTest02714", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02714", "FOO=echo Injection");
	}
}

