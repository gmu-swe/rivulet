package io.rivulet.maven.test.juliet;

import io.rivulet.ExpectsRivuletRerun;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

import javax.servlet.ServletException;

import static org.junit.Assert.fail;

public class JulietCWE78OSCommandInjectionTest extends JulietBaseTest {
	@Rule
	public final ExternalResource myWebApp = new ExternalResource() {
		@Override
		protected void before() throws Throwable {
			try {
				addWebApp("Juliet_CWE78_OS_Command_Injection");
			} catch (ServletException e) {
				e.printStackTrace();
				fail();
			}
		}
	};

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_21Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_21().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_21FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_21().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_14Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_14().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_14FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_14().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_10Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_10().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_10FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_10().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_10Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_10().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_10FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_10().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_61aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_61a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_61aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_61a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_16Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_16().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_16FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_16().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_72aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_72a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_72aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_72a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_41Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_41().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_41FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_41().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_02Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_02().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_02FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_02().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_16Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_16().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_16FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_16().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_14Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_14().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_14FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_14().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_04Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_04().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_04FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_04().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_73aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_73a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_73aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_73a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_54aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_54a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_54aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_54a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_16Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_16().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_16FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_16().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_61aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_61a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_61aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_61a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_61aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_61a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_61aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_61a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_09Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_09().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_09FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_09().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_16Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_16().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_16FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_16().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_74aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_74a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_74aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_74a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_71aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_71a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_71aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_71a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_52aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_52a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_52aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_52a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_74aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_74a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_74aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_74a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_68aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_68a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_68aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_68a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_13Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_13().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_13FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_13().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_10Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_10().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_10FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_10().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_13Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_13().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_13FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_13().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_51aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_51a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_51aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_51a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_21Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_21().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_21FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_21().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_54aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_54a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_54aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_54a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_53aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_53a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_53aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_53a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_53aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_53a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_53aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_53a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_15Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_15().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_15FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_15().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_68aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_68a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_68aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_68a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_06Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_06().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_06FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_06().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_81aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_81a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_81aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_81a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_74aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_74a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_74aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_74a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_14Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_14().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_14FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_14().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_75aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_75a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_75aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_75a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_42Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_42().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_42FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_42().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_52aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_52a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_52aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_52a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_31Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_31().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_31FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_31().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_04Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_04().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_04FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_04().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_81aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_81a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_81aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_81a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_81aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_81a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_81aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_81a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_75aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_75a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_75aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_75a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_31Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_31().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_31FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_31().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_09Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_09().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_09FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_09().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_73aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_73a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_73aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_73a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_21Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_21().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_21FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_21().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_42Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_42().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_42FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_42().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_08Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_08().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_08FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_08().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_09Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_09().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_09FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_09().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_53aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_53a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_53aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_53a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_75aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_75a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_75aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_75a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_67aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_67a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_67aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_67a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_05Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_05().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_05FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_05().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_22aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_22a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_22aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_22a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_07Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_07().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_07FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_07().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_12Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_12().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_12FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_12().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_45Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_45().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_45FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_45().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_71aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_71a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_71aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_71a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_13Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_13().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_13FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_13().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_51aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_51a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_51aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_51a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_11Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_11().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_11FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_11().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_72aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_72a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_72aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_72a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_22aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_22a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_22aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_22a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_73aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_73a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_73aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_73a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_68aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_68a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_68aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_68a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_08Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_08().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_08FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_08().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_53aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_53a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_53aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_53a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_02Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_02().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_02FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_02().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_11Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_11().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_11FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_11().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_41Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_41().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_41FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_41().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_01Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_01().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_01FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_01().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_31Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_31().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_31FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_31().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_71aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_71a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_71aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_71a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_51aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_51a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_51aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_51a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_66aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_66a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_66aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_66a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_42Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_42().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_42FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_42().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_45Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_45().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_45FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_45().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_03Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_03().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_03FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_03().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_52aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_52a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_52aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_52a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_54aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_54a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_54aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_54a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_72aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_72a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_72aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_72a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_54aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_54a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_54aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_54a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_17Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_17().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_17FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_17().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_07Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_07().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_07FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_07().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_11Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_11().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_11FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_11().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_21Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_21().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_21FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_21().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_41Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_41().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_41FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_41().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_02Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_02().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_02FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_02().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_13Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_13().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_13FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_13().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_05Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_05().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_05FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_05().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_14Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_14().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_14FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_14().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_61aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_61a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_61aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_61a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_42Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_42().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_42FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_42().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_61aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_61a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_61aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_61a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_67aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_67a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_67aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_67a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_71aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_71a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_71aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_71a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_45Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_45().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_45FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_45().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_01Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_01().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_01FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_01().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_72aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_72a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_72aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_72a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_61aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_61a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_61aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_61a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_13Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_13().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_13FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_13().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_01Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_01().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_01FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_01().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_11Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_11().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_11FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_11().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_42Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_42().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_42FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_42().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_12Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_12().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_12FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_12().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_17Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_17().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_17FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_17().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_01Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_01().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_01FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_01().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_41Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_41().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_41FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_41().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_74aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_74a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_74aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_74a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_05Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_05().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_05FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_05().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_54aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_54a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_54aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_54a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_75aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_75a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_75aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_75a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_71aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_71a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_71aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_71a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_03Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_03().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_03FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_03().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_21Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_21().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_21FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_21().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_14Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_14().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_14FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_14().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_68aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_68a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_68aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_68a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_81aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_81a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_81aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_81a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_22aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_22a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_22aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_22a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_07Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_07().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_07FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_07().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_10Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_10().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_10FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_10().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_02Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_02().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_02FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_02().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_09Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_09().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_09FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_09().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_31Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_31().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_31FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_31().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_67aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_67a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_67aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_67a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_42Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_42().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_42FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_42().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_10Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_10().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_10FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_10().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_41Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_41().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_41FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_41().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_68aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_68a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_68aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_68a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_07Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_07().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_07FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_07().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_02Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_02().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_02FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_02().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_66aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_66a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_66aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_66a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_22aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_22a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_22aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_22a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_11Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_11().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_11FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_11().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_09Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_09().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_09FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_09().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_15Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_15().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_15FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_15().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_54aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_54a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_54aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_54a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_02Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_02().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_02FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_02().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_01Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_01().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_01FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_01().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_45Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_45().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_45FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_45().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_05Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_05().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_05FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_05().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_10Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_10().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_10FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_10().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_05Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_05().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_05FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_05().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_68aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_68a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_68aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_68a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_14Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_14().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_14FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_14().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_08Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_08().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_08FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_08().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_68aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_68a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_68aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_68a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_13Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_13().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_13FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_13().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_12Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_12().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_12FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_12().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_12Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_12().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_12FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_12().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_75aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_75a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_75aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_75a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_61aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_61a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_61aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_61a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_10Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_10().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_10FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_10().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_06Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_06().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_06FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_06().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_12Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_12().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_12FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_12().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_66aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_66a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_66aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_66a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_03Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_03().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_03FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_03().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_02Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_02().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_02FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_02().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_45Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_45().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_45FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_45().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_04Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_04().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_04FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_04().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_13Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_13().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_13FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_13().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_06Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_06().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_06FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_06().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_52aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_52a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_52aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_52a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_16Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_16().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_16FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_16().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_22aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_22a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_22aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_22a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_66aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_66a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_66aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_66a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_67aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_67a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_67aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_67a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_02Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_02().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_02FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_02().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_71aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_71a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_71aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_71a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_15Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_15().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_15FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_15().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_67aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_67a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_67aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_67a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_51aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_51a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_51aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_51a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_52aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_52a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_52aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_52a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_72aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_72a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_72aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_72a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_67aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_67a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_67aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_67a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_09Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_09().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_09FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_09().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_16Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_16().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_16FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_16().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_75aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_75a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_75aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_75a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_54aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_54a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_54aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_54a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_07Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_07().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_07FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_07().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_45Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_45().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_45FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_45().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_14Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_14().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_14FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_14().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_02Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_02().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_02FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_02().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_15Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_15().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_15FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_15().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_22aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_22a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_22aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_22a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_12Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_12().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_12FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_12().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_31Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_31().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_31FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_31().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_04Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_04().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_04FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_04().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_74aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_74a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_74aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_74a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_41Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_41().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_41FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_41().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_81aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_81a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_81aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_81a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_31Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_31().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_31FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_31().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_05Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_05().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_05FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_05().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_66aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_66a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_66aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_66a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_04Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_04().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_04FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_04().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_16Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_16().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_16FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_16().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_41Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_41().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_41FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_41().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_17Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_17().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_17FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_17().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_45Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_45().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_45FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_45().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_75aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_75a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_75aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_75a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_53aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_53a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_53aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_53a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_01Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_01().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_01FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_01().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_53aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_53a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_53aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_53a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_51aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_51a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_51aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_51a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_14Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_14().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_14FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_14().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_08Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_08().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_08FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_08().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_17Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_17().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_17FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_17().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_66aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_66a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_66aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_66a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_54aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_54a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_54aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_54a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_03Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_03().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_03FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_03().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_06Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_06().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_06FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_06().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_21Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_21().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_21FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_21().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_31Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_31().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_31FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_31().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_31Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_31().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_31FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_31().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_45Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_45().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_45FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_45().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_08Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_08().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_08FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_08().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_73aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_73a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_73aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_73a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_06Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_06().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_06FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_06().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_61aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_61a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_61aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_61a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_09Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_09().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_09FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_09().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_07Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_07().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_07FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_07().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_01Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_01().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_01FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_01().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_13Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_13().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_13FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_13().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_42Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_42().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_42FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_42().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_71aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_71a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_71aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_71a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_72aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_72a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_72aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_72a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_15Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_15().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_15FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_15().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_51aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_51a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_51aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_51a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_81aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_81a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_81aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_81a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_73aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_73a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_73aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_73a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_81aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_81a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_81aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_81a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_74aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_74a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_74aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_74a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_12Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_12().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_12FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_12().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_15Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_15().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_15FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_15().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_12Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_12().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_12FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_12().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_71aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_71a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_71aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_71a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_07Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_07().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_07FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_07().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_72aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_72a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_72aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_72a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_06Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_06().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_06FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_06().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_07Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_07().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_07FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_07().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_22aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_22a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_22aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_22a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_06Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_06().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_06FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_06().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_52aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_52a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_52aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_52a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_53aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_53a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_53aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_53a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_17Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_17().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_17FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_17().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_67aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_67a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_67aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_67a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_67aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_67a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_67aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_67a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_52aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_52a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_52aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_52a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_11Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_11().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_11FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_11().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_12Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_12().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_12FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_12().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_15Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_15().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_15FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_15().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_10Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_10().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_10FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_10().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_53aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_53a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_53aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_53a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_21Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_21().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_21FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_21().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_01Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_01().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_01FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_01().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_54aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_54a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_54aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_54a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_22aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_22a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_22aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_22a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_81aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_81a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_81aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_81a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_14Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_14().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_14FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_14().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_08Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_08().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_08FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_08().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_05Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_05().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_05FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_05().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_08Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_08().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_08FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_08().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_74aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_74a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_74aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_74a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_75aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_75a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_75aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_75a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_42Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_42().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_42FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_42().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_53aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_53a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_53aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_53a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_66aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_66a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_66aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_66a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_16Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_16().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_16FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_16().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_17Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_17().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_17FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_17().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_05Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_05().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_05FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_05().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_15Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_15().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_15FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_15().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_41Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_41().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_41FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_41().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_71aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_71a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_71aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_71a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_51aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_51a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_51aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_51a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_11Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_11().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_11FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_11().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_68aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_68a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_68aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_68a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_66aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_66a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_66aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_66a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_04Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_04().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_04FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_04().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_03Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_03().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_03FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_03().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_42Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_42().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_42FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_42().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_03Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_03().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_03FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_03().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_22aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_22a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_22aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_22a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_81aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_81a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_81aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_81a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_73aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_73a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_73aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_73a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_13Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_13().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_13FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_13().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_01Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_01().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_01FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_01().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_16Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_16().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_16FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_16().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_03Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_03().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_03FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_03().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_74aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_74a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_74aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_74a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_67aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_67a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_67aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_67a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_45Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_45().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_45FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_45().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_03Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_03().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_03FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_03().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_21Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_21().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_21FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_21().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_73aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_73a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_73aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_73a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_04Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_04().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_04FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_04().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_61aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_61a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_61aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_61a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_08Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_08().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_08FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_08().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_08Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_08().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_08FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_08().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_52aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_52a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_52aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_52a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_09Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_09().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_09FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_09().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_10Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_10().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_10FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_10().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_04Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_04().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_04FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_04().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_41Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_41().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_41FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_41().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_15Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_15().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_15FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_15().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_11Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_11().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_11FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_11().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_73aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_73a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_73aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_73a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_73aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_73a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_73aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_73a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_04Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_04().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_04FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_04().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_72aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_72a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_72aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_72a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_11Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_11().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_11FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_11().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Property_09Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_09().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Property_09FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Property_09().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_17Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_17().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_17FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_17().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_51aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_51a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_51aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_51a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_51aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_51a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_51aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_51a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_17Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_17().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_17FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_17().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_68aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_68a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_68aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_68a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_03Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_03().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_03FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_03().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_52aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_52a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__listen_tcp_52aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__listen_tcp_52a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_21Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_21().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_21FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_21().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__database_06Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_06().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__database_06FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__database_06().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__File_07Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_07().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__File_07FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__File_07().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_66aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_66a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_66aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_66a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_74aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_74a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_74aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_74a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_17Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_17().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__connect_tcp_17FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__connect_tcp_17().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_75aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_75a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_75aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_75a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__console_readLine_06Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_06().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__console_readLine_06FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__console_readLine_06().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_05Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_05().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__PropertiesFile_05FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__PropertiesFile_05().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__URLConnection_72aVulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_72a().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__URLConnection_72aFalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__URLConnection_72a().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__Environment_31Vulnerable() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_31().bad();
		} catch (Throwable t) {
		}
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__Environment_31FalsePositive() throws Exception {
		try {
			new testcases.CWE78_OS_Command_Injection.CWE78_OS_Command_Injection__Environment_31().good();
		} catch (Throwable t) {
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_66aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-66a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_66aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-66a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_13Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-13", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_13FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-13", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_16Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-16", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_16FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-16", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_22aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-22a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_22aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-22a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_14Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-14", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_14FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-14", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_51aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-51a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_51aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-51a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_72aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-72a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_72aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-72a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_09Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-09", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_09FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-09", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_11Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-11", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_11FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-11", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_11Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-11", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_11FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-11", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_09Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-09", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_09FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-09", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_71aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-71a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_71aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-71a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_52aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-52a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_52aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-52a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_08Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-08", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_08FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-08", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_12Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-12", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_12FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-12", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_66aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-66a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_66aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-66a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_13Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-13", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_13FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-13", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_15Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-15", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_15FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-15", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_06Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-06", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_06FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-06", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_05Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-05", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_05FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-05", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_53aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-53a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_53aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-53a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_13Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-13", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_13FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-13", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_81aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-81a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_81aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-81a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_81aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-81a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_81aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-81a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_10Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-10", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_10FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-10", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_41Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-41", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_41FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-41", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_52aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-52a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_52aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-52a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_67aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-67a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_67aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-67a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_04Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-04", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_04FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-04", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_52aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-52a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_52aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-52a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_10Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-10", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_10FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-10", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_54aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-54a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_54aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-54a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_14Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-14", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_14FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-14", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_17Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-17", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_17FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-17", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_73aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-73a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_73aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-73a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_45Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-45", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_45FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-45", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_54aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-54a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_54aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-54a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_67aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-67a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_67aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-67a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_41Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-41", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_41FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-41", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_31Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-31", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_31FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-31", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_02Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-02", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_02FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-02", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_67aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-67a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_67aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-67a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_74aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-74a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_74aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-74a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_02Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-02", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_02FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-02", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_09Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-09", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_09FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-09", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_12Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-12", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_12FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-12", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_02Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-02", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_02FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-02", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_01Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-01", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_01FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-01", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_05Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-05", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_05FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-05", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_72aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-72a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_72aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-72a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_15Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-15", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_15FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-15", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_61aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-61a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_61aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-61a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_03Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-03", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_03FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-03", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_22aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-22a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_22aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-22a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_68aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-68a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_68aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-68a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_72aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-72a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_72aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-72a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_05Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-05", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_05FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-05", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_42Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-42", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_42FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-42", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_10Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-10", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_10FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-10", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_71aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-71a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_71aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-71a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_16Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-16", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_16FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-16", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_51aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-51a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_51aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-51a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_75aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-75a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_75aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-75a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_31Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-31", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_31FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-31", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_11Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-11", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_11FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-11", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_08Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-08", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_08FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-08", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_03Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-03", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_03FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-03", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_75aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-75a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_75aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-75a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_68aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-68a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_68aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-68a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_54aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-54a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_54aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-54a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_07Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-07", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_07FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-07", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_61aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-61a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_61aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-61a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_45Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-45", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_45FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-45", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_21Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-21", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_21FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-21", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_68aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-68a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_68aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-68a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_01Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-01", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_01FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-01", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_66aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-66a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_66aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-66a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_17Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-17", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_17FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-17", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_74aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-74a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_74aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-74a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_03Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-03", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_03FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-03", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_75aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-75a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_75aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-75a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_61aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-61a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_61aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-61a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_08Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-08", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_08FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-08", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_51aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-51a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_51aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-51a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_42Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-42", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_42FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-42", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_81aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-81a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_81aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-81a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_04Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-04", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_04FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-04", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_71aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-71a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_71aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-71a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_06Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-06", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_06FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-06", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_45Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-45", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_45FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-45", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_73aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-73a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_73aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-73a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_01Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-01", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_01FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-01", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_42Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-42", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_42FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-42", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_07Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-07", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_07FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-07", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_16Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-16", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_16FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-16", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_74aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-74a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_74aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-74a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_31Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-31", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_31FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-31", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_15Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-15", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_15FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-15", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_12Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-12", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_12FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-12", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_06Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-06", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_06FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-06", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_21Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-21", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_21FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-21", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_22aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-22a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_22aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-22a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_07Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-07", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_07FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-07", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_21Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-21", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_21FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-21", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_41Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-41", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_41FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-41", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_14Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-14", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_14FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-14", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_73aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-73a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_73aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-73a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_17Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-17", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_17FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-17", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_04Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-04", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getQueryString_Servlet_04FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getQueryString-Servlet-04", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_53aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-53a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getParameter_Servlet_53aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getParameter-Servlet-53a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_53aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-53a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE78_OS_Command_Injection__getCookies_Servlet_53aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE78_OS_Command_Injection/CWE78-OS-Command-Injection--getCookies-Servlet-53a", false);
	}
}

