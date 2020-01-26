package io.rivulet.maven.test.webgoat;

import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import io.rivulet.internal.RivuletAutoTaintWrapper;
import org.junit.Test;

import java.net.URI;

@Source(method = "io/rivulet/PhosphorHttpRequest.getEntityBody()Ljava/lang/String;")
@Sink(method = "java/sql/Statement.executeQuery(Ljava/lang/String;)Ljava/sql/ResultSet;")
@Sink(method = "java/sql/Statement.execute(Ljava/lang/String;)Z")
@Sink(method = "java/sql/Statement.execute(Ljava/lang/String;I)Z")
@Sink(method = "java/sql/Statement.execute(Ljava/lang/String;[I)Z")
@Sink(method = "java/sql/Statement.execute(Ljava/lang/String;[Ljava/lang/String;)Z")
@Sink(method = "java/sql/Statement.executeUpdate(Ljava/lang/String;)I")
@Sink(method = "java/sql/Statement.executeUpdate(Ljava/lang/String;I)I")
@Sink(method = "java/sql/Statement.executeUpdate(Ljava/lang/String;[I)I")
@Sink(method = "java/sql/Statement.executeUpdate(Ljava/lang/String;[Ljava/lang/String;)I")
@Sink(method = "java/sql/Statement.executeLargeUpdate(Ljava/lang/String;)J")
@Sink(method = "java/sql/Statement.executeLargeUpdate(Ljava/lang/String;I)J")
@Sink(method = "java/sql/Statement.executeLargeUpdate(Ljava/lang/String;[I)J")
@Sink(method = "java/sql/Statement.executeLargeUpdate(Ljava/lang/String;[Ljava/lang/String;)J")
@Sink(method = "java/sql/Statement.addBatch(Ljava/lang/String;)V")
@Sink(method = "java/sql/Connection.prepareCall(Ljava/lang/String;)Ljava/sql/CallableStatement;")
@Sink(method = "java/sql/Connection.prepareCall(Ljava/lang/String;II)Ljava/sql/CallableStatement;")
@Sink(method = "java/sql/Connection.prepareCall(Ljava/lang/String;III)Ljava/sql/CallableStatement;")
@Sink(method = "java/sql/Connection.prepareStatement(Ljava/lang/String;)Ljava/sql/PreparedStatement;")
@Sink(method = "java/sql/Connection.prepareStatement(Ljava/lang/String;I)Ljava/sql/PreparedStatement;")
@Sink(method = "java/sql/Connection.prepareStatement(Ljava/lang/String;II)Ljava/sql/PreparedStatement;")
@Sink(method = "java/sql/Connection.prepareStatement(Ljava/lang/String;III)Ljava/sql/PreparedStatement;")
@Sink(method = "java/sql/Connection.prepareStatement(Ljava/lang/String;[I)Ljava/sql/PreparedStatement;")
@Sink(method = "java/sql/Connection.prepareStatement(Ljava/lang/String;[Ljava/lang/String;)Ljava/sql/PreparedStatement;")
@Sink(method = "java/sql/Connection.nativeSQL(Ljava/lang/String;)Ljava/lang/String;")
public class WebGoatSqlTest extends WebGoatBaseTest {

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testNumericSqlInjection() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Numeric SQL Injection").build();
			postWithForm(uri, "station=101&SUBMIT=Go!");
		} catch (Exception e) {
			if (!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testStage1StringSqlInjection() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Stage 1: String SQL Injection").build();
			postWithForm(uri, "employee_id=101&password=example&action=Login");
		} catch (Exception e) {
			if (!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testStage3NumericSqlInjection() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Stage 3: Numeric SQL Injection").build();
			postWithForm(uri, "employee_id=105&password=tom&action=Login");
			// Clear the configs and violations to ensure that the flow to line 108 of SQLInjection.ViewProfile.java is
			// detected and not masked by the flow to line 131 of SQLInjection.Login.java
			RivuletAutoTaintWrapper.getAndClearViolationConfigsMap();
			postWithForm(uri, "employee_id=105&action=ViewProfile");
		} catch (Exception e) {
			if (!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testStringSqlInjection() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("String SQL Injection").build();
			postWithForm(uri, "account_name=Jim&SUBMIT=Go!");
		} catch (Exception e) {
			if (!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testModifyDataWithSqlInjection() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Modify Data with SQL Injection").build();
			postWithForm(uri, "userid=jsmith&SUBMIT=Go!");
		} catch (Exception e) {
			if (!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testAddDataWithSqlInjection() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Add Data with SQL Injection").build();
			postWithForm(uri, "userid=jsmith&SUBMIT=Go!");
		} catch (Exception e) {
			if (!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testDatabaseBackdoors() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Database Backdoors ").build();
			postWithForm(uri, "username=103&Submit=Submit");
		} catch (Exception e) {
			if (!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBlindNumericSqlInjection() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Blind Numeric SQL Injection").build();
			postWithForm(uri, "account_number=105&SUBMIT=Go!");
		} catch (Exception e) {
			if (!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBlindStringSqlInjection() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Blind String SQL Injection").build();
			postWithForm(uri, "account_number=105&SUBMIT=Go!");
		} catch (Exception e) {
			if (!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}
}

