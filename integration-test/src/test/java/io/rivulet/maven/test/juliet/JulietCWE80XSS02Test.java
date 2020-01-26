package io.rivulet.maven.test.juliet;

import io.rivulet.ExpectsRivuletRerun;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

import javax.servlet.ServletException;

import static org.junit.Assert.fail;

public class JulietCWE80XSS02Test extends JulietBaseTest {
	@Rule
	public final ExternalResource myWebApp = new ExternalResource() {
		@Override
		protected void before() throws Throwable {
			try {
				addWebApp("Juliet_CWE80_XSS_s02");
			} catch (ServletException e) {
				e.printStackTrace();
				fail();
			}
		}
	};

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_02Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-02", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_02FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-02", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_14Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-14", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_14FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-14", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_21Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-21", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_21FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-21", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_06Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-06", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_06FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-06", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_16Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-16", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_16FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-16", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_81aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-81a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_81aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-81a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_07Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-07", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_07FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-07", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_13Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-13", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_13FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-13", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_66aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-66a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_66aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-66a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_14Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-14", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_14FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-14", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_22aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-22a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_22aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-22a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_51aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-51a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_51aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-51a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_51aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-51a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_51aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-51a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_73aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-73a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_73aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-73a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_42Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-42", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_42FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-42", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_17Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-17", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_17FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-17", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_05Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-05", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_05FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-05", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_21Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-21", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_21FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-21", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_42Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-42", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_42FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-42", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_09Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-09", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_09FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-09", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_74aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-74a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_74aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-74a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_08Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-08", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_08FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-08", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_11Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-11", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_11FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-11", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_10Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-10", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_10FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-10", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_03Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-03", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_03FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-03", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_72aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-72a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_72aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-72a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_08Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-08", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_08FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-08", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_16Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-16", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_16FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-16", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_02Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-02", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_02FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-02", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_05Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-05", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_05FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-05", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_75aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-75a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_75aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-75a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_54aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-54a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_54aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-54a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_31Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-31", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_31FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-31", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_07Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-07", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_07FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-07", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_17Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-17", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_17FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-17", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_72aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-72a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_72aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-72a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_06Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-06", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_06FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-06", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_68aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-68a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_68aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-68a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_73aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-73a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_73aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-73a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_01Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-01", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_01FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-01", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_68aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-68a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_68aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-68a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_11Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-11", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_11FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-11", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_13Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-13", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_13FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-13", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_61aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-61a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_61aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-61a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_12Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-12", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_12FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-12", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_10Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-10", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_10FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-10", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_22aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-22a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_22aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-22a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_81aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-81a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_81aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-81a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_71aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-71a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_71aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-71a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_66aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-66a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_66aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-66a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_03Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-03", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_03FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-03", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_52aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-52a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_52aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-52a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_61aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-61a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_61aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-61a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_15Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-15", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_15FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-15", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_67aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-67a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_67aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-67a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_53aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-53a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_53aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-53a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_01Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-01", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_01FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-01", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_67aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-67a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_67aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-67a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_52aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-52a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_52aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-52a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_45Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-45", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_45FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-45", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_09Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-09", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_09FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-09", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_12Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-12", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_12FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-12", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_54aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-54a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_54aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-54a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_45Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-45", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_45FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-45", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_41Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-41", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_41FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-41", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_15Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-15", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_15FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-15", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_04Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-04", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_04FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-04", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_74aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-74a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_74aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-74a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_75aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-75a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_75aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-75a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_04Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-04", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_04FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-04", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_URLConnection_41Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-41", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_URLConnection_41FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-URLConnection-41", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_31Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-31", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_31FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-31", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_53aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-53a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_53aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-53a", false);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_71aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-71a", true);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE80_XSS__Servlet_PropertiesFile_71aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE80_XSS_s02/CWE80-XSS--Servlet-PropertiesFile-71a", false);
	}
}

