package io.rivulet.maven.test.juliet;

import io.rivulet.ExpectsRivuletRerun;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

import javax.servlet.ServletException;

import static org.junit.Assert.fail;

public class JulietCWE83XSSAttributeTest extends JulietBaseTest{
	@Rule
	public final ExternalResource myWebApp = new ExternalResource() {
		@Override
		protected void before() throws Throwable {
			try {
				addWebApp("Juliet_CWE83_XSS_Attribute");
			} catch (ServletException e) {
				e.printStackTrace();
				fail();
			}
		}
	};
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_01Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-01",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_01FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-01",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_22aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-22a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_22aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-22a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_45Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-45",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_45FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-45",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_13Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-13",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_13FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-13",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_52aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-52a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_52aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-52a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_15Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-15",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_15FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-15",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_21Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-21",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_21FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-21",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_05Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-05",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_05FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-05",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_72aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-72a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_72aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-72a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_10Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-10",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_10FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-10",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_04Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-04",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_04FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-04",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_13Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-13",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_13FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-13",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_17Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-17",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_17FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-17",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_02Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-02",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_02FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-02",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_61aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-61a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_61aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-61a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_73aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-73a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_73aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-73a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_12Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-12",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_12FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-12",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_53aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-53a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_53aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-53a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_04Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-04",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_04FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-04",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_07Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-07",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_07FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-07",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_71aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-71a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_71aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-71a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_31Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-31",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_31FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-31",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_14Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-14",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_14FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-14",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_15Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-15",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_15FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-15",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_52aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-52a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_52aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-52a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_04Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-04",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_04FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-04",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_15Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-15",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_15FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-15",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_67aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-67a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_67aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-67a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_53aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-53a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_53aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-53a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_11Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-11",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_11FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-11",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_41Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-41",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_41FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-41",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_51aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-51a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_51aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-51a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_22aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-22a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_22aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-22a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_10Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-10",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_10FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-10",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_10Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-10",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_10FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-10",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_03Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-03",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_03FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-03",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_61aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-61a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_61aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-61a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_67aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-67a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_67aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-67a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_16Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-16",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_16FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-16",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_13Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-13",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_13FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-13",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_01Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-01",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_01FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-01",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_66aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-66a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_66aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-66a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_07Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-07",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_07FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-07",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_22aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-22a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_22aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-22a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_07Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-07",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_07FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-07",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_04Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-04",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_04FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-04",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_14Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-14",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_14FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-14",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_09Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-09",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_09FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-09",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_02Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-02",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_02FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-02",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_04Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-04",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_04FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-04",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_08Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-08",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_08FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-08",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_41Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-41",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_41FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-41",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_74aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-74a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_74aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-74a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_22aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-22a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_22aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-22a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_41Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-41",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_41FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-41",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_16Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-16",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_16FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-16",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_52aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-52a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_52aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-52a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_01Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-01",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_01FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-01",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_12Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-12",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_12FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-12",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_41Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-41",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_41FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-41",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_53aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-53a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_53aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-53a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_10Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-10",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_10FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-10",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_17Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-17",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_17FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-17",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_06Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-06",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_06FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-06",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_03Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-03",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_03FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-03",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_01Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-01",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_01FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-01",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_51aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-51a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_51aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-51a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_61aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-61a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_61aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-61a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_73aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-73a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_73aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-73a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_66aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-66a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_66aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-66a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_03Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-03",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_03FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-03",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_03Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-03",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_03FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-03",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_14Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-14",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_14FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-14",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_51aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-51a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_51aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-51a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_13Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-13",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_13FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-13",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_22aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-22a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_22aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-22a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_73aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-73a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_73aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-73a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_42Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-42",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_42FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-42",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_08Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-08",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_08FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-08",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_81aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-81a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_81aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-81a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_75aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-75a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_75aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-75a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_31Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-31",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_31FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-31",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_51aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-51a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_51aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-51a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_16Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-16",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_16FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-16",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_02Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-02",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_02FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-02",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_74aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-74a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_74aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-74a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_51aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-51a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_51aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-51a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_67aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-67a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_67aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-67a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_01Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-01",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_01FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-01",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_45Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-45",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_45FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-45",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_15Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-15",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_15FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-15",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_05Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-05",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_05FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-05",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_67aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-67a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_67aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-67a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_81aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-81a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_81aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-81a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_52aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-52a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_52aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-52a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_06Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-06",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_06FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-06",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_15Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-15",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_15FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-15",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_51aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-51a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_51aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-51a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_06Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-06",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_06FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-06",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_72aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-72a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_72aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-72a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_54aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-54a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_54aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-54a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_06Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-06",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_06FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-06",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_11Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-11",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_11FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-11",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_04Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-04",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_04FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-04",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_68aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-68a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_68aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-68a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_45Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-45",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_45FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-45",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_02Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-02",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_02FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-02",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_04Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-04",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_04FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-04",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_45Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-45",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_45FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-45",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_68aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-68a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_68aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-68a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_45Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-45",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_45FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-45",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_10Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-10",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_10FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-10",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_75aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-75a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_75aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-75a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_75aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-75a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_75aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-75a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_74aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-74a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_74aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-74a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_22aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-22a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_22aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-22a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_42Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-42",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_42FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-42",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_11Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-11",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_11FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-11",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_53aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-53a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_53aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-53a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_06Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-06",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_06FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-06",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_54aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-54a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_54aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-54a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_81aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-81a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_81aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-81a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_66aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-66a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_66aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-66a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_68aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-68a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_68aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-68a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_21Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-21",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_21FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-21",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_06Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-06",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_06FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-06",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_45Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-45",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_45FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-45",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_21Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-21",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_21FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-21",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_74aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-74a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_74aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-74a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_13Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-13",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_13FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-13",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_04Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-04",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_04FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-04",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_12Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-12",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_12FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-12",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_16Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-16",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_16FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-16",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_01Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-01",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_01FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-01",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_05Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-05",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_05FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-05",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_22aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-22a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_22aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-22a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_61aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-61a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_61aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-61a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_81aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-81a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_81aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-81a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_02Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-02",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_02FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-02",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_67aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-67a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_67aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-67a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_15Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-15",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_15FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-15",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_75aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-75a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_75aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-75a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_72aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-72a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_72aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-72a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_05Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-05",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_05FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-05",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_51aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-51a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_51aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-51a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_53aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-53a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_53aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-53a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_14Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-14",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_14FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-14",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_08Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-08",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_08FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-08",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_61aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-61a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_61aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-61a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_41Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-41",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_41FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-41",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_12Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-12",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_12FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-12",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_51aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-51a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_51aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-51a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_05Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-05",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_05FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-05",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_21Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-21",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_21FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-21",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_03Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-03",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_03FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-03",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_74aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-74a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_74aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-74a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_16Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-16",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_16FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-16",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_17Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-17",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_17FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-17",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_52aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-52a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_52aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-52a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_09Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-09",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_09FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-09",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_08Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-08",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_08FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-08",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_31Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-31",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_31FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-31",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_41Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-41",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_41FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-41",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_71aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-71a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_71aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-71a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_41Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-41",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_41FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-41",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_11Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-11",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_11FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-11",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_71aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-71a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_71aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-71a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_75aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-75a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_75aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-75a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_73aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-73a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_73aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-73a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_08Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-08",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_08FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-08",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_72aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-72a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_72aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-72a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_06Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-06",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_06FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-06",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_09Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-09",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_09FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-09",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_31Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-31",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_31FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-31",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_13Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-13",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_13FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-13",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_42Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-42",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_42FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-42",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_03Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-03",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_03FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-03",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_71aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-71a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_71aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-71a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_08Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-08",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_08FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-08",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_52aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-52a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_52aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-52a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_09Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-09",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_09FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-09",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_72aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-72a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_72aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-72a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_71aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-71a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_71aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-71a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_01Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-01",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_01FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-01",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_61aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-61a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_61aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-61a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_73aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-73a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_73aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-73a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_12Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-12",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_12FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-12",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_16Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-16",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_16FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-16",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_31Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-31",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_31FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-31",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_67aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-67a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_67aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-67a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_06Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-06",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_06FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-06",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_45Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-45",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_45FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-45",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_66aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-66a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_66aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-66a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_54aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-54a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_54aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-54a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_73aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-73a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_73aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-73a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_54aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-54a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_54aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-54a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_74aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-74a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_74aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-74a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_08Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-08",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_08FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-08",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_75aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-75a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_75aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-75a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_31Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-31",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_31FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-31",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_13Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-13",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_13FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-13",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_31Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-31",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_31FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-31",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_11Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-11",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_11FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-11",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_45Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-45",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_45FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-45",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_73aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-73a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_73aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-73a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_81aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-81a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_81aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-81a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_54aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-54a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_54aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-54a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_42Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-42",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_42FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-42",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_02Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-02",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_02FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-02",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_12Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-12",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_12FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-12",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_05Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-05",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_05FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-05",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_41Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-41",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_41FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-41",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_61aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-61a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_61aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-61a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_05Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-05",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_05FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-05",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_45Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-45",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_45FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-45",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_54aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-54a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_54aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-54a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_05Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-05",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_05FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-05",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_05Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-05",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_05FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-05",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_16Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-16",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_16FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-16",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_75aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-75a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_75aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-75a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_53aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-53a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_53aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-53a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_02Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-02",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_02FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-02",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_11Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-11",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_11FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-11",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_09Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-09",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_09FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-09",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_73aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-73a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_73aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-73a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_42Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-42",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_42FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-42",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_52aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-52a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_52aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-52a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_54aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-54a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_54aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-54a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_81aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-81a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_81aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-81a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_10Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-10",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_10FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-10",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_68aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-68a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_68aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-68a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_66aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-66a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_66aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-66a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_71aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-71a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_71aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-71a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_15Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-15",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_15FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-15",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_71aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-71a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_71aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-71a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_22aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-22a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_22aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-22a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_17Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-17",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_17FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-17",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_81aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-81a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_81aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-81a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_22aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-22a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_22aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-22a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_14Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-14",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_14FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-14",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_53aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-53a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_53aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-53a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_09Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-09",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_09FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-09",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_42Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-42",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_42FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-42",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_16Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-16",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_16FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-16",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_72aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-72a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_72aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-72a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_10Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-10",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_10FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-10",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_67aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-67a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_67aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-67a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_71aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-71a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_71aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-71a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_53aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-53a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_53aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-53a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_42Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-42",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_42FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-42",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_02Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-02",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_02FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-02",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_68aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-68a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_68aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-68a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_74aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-74a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_74aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-74a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_67aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-67a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_67aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-67a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_07Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-07",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_07FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-07",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_08Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-08",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_08FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-08",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_54aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-54a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_54aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-54a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_72aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-72a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_72aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-72a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_13Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-13",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_13FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-13",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_14Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-14",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_14FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-14",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_42Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-42",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_42FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-42",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_17Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-17",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_17FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-17",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_52aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-52a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_52aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-52a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_66aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-66a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_66aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-66a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_17Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-17",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_17FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-17",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_81aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-81a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_81aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-81a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_61aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-61a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_61aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-61a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_75aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-75a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_75aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-75a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_15Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-15",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_15FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-15",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_67aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-67a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_67aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-67a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_68aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-68a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_68aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-68a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_14Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-14",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_14FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-14",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_09Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-09",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_09FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-09",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_14Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-14",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_14FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-14",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_03Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-03",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_03FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-03",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_08Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-08",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_08FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-08",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_12Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-12",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_12FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-12",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_15Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-15",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_15FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-15",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_03Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-03",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_03FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-03",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_66aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-66a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_66aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-66a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_68aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-68a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_68aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-68a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_73aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-73a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_73aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-73a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_71aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-71a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_71aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-71a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_11Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-11",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_11FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-11",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_68aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-68a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_68aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-68a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_74aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-74a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_74aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-74a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_61aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-61a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_61aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-61a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_17Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-17",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_17FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-17",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_81aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-81a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_81aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-81a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_75aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-75a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_75aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-75a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_21Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-21",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_21FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-21",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_21Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-21",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_21FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-21",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_02Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-02",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_02FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-02",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_66aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-66a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_66aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-66a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_11Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-11",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_11FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-11",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_07Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-07",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_07FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-07",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_31Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-31",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_31FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-31",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_17Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-17",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_17FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-17",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_07Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-07",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_07FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-07",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_06Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-06",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_06FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-06",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_42Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-42",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_42FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-42",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_31Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-31",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_31FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-31",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_09Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-09",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_09FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-09",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_03Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-03",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_03FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-03",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_21Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-21",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_21FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-21",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_01Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-01",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_01FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-01",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_09Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-09",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_09FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-09",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_68aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-68a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_68aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-68a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_10Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-10",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_10FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-10",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_21Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-21",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_21FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-21",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_52aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-52a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_52aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-52a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_12Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-12",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_12FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-12",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_66aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-66a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_66aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-66a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_01Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-01",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_01FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-01",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_10Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-10",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_10FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-10",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_16Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-16",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_connect_tcp_16FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-connect-tcp-16",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_72aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-72a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_URLConnection_72aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-URLConnection-72a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_14Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-14",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getCookies_Servlet_14FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getCookies-Servlet-14",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_07Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-07",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_07FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-07",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_17Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-17",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_17FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-17",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_21Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-21",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_21FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-21",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_04Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-04",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_04FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-04",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_51aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-51a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_51aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-51a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_41Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-41",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getQueryString_Servlet_41FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getQueryString-Servlet-41",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_72aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-72a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_72aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-72a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_53aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-53a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_PropertiesFile_53aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-PropertiesFile-53a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_12Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-12",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_listen_tcp_12FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-listen-tcp-12",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_07Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-07",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_07FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-07",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_54aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-54a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_54aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-54a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_74aVulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-74a",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_74aFalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-74a",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_database_11Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-11",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_database_11FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-database-11",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_File_07Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-07",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_File_07FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-File-07",false);
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_13Vulnerable() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-13",true);
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testCWE83_XSS_Attribute__Servlet_getParameter_Servlet_13FalsePositive() throws Exception {
		runJulietTest("/Juliet_CWE83_XSS_Attribute/CWE83-XSS-Attribute--Servlet-getParameter-Servlet-13",false);
	}
}

