package io.rivulet.maven.test;

import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

@Source(method = "io/rivulet/maven/test/TestUtils.objSource(Ljava/lang/Object;)Ljava/lang/Object;")
@Sink(method = "java/sql/Statement.executeQuery(Ljava/lang/String;)Ljava/sql/ResultSet;")
public class SqlInjectionGeneratorTest extends ViolationCheckingBaseTest {

    /* Creates a table for animals and adds four entries to it. */
    @BeforeClass
    public static void createTable() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE animal (name VARCHAR(100), phylum VARCHAR(100), lifespan INT, PRIMARY KEY (name))");
        connection.commit();
        statement.executeUpdate("INSERT INTO animal VALUES ('Cat','Chordata', 23)");
        statement.executeUpdate("INSERT INTO animal VALUES ('Bee', 'Euarthropoda', 1)");
        statement.executeUpdate("INSERT INTO animal VALUES ('Turtle', 'Chordata', 90)");
        statement.executeUpdate("INSERT INTO animal VALUES ('Octopus', 'Mollusca', 4)");
        connection.commit();
    }

    /* Drops the animal table from the database. */
    @AfterClass
    public static void dropTable() throws SQLException {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement();) {
            statement.executeUpdate("DROP TABLE animal");
            connection.commit();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:mem:animal");
    }

    /* Inserts the specified query value into the query and then executes that query. Checks that a violation is reported
     * and checks for a critical violation is it is expected. */
    private void executeQueryAndCheckViolations(String queryValue) throws Exception {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        try {
            statement.executeQuery("SELECT * FROM animal WHERE name = '" + queryValue + "'");
        } catch(SQLException e) {
            // SQLExceptions may occur on test reruns
        }
        checkViolationsIncreased();
    }

    /* Checks that inserting a tainted string into a a statement results in a violation on the original test run and a
     * critical violation on the test rerun. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testInjectTaintedString() throws Exception {
        String taintedName = TestUtils.objSource(new String("Turtle"));
        executeQueryAndCheckViolations(taintedName);
    }

    /* Checks that placing a crudely filtered tainted string into a statement results in a violation being reported on
     * the original test run, but does not result in a critical violation on the test rerun. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testInjectTaintedFilteredString() throws Exception {
        String taintedName = TestUtils.objSource(new String("Turtle"));
        // Questionable sanitizing
        // Remove escaped quotes
        taintedName = taintedName.replaceAll("\\\\\"|\\\\'", "");
        // Remove comments
        taintedName = taintedName.replaceAll("--.*|#.*", "");
        // Remove quotes
        taintedName = taintedName.replaceAll("[\'\"]", "");
        executeQueryAndCheckViolations(taintedName);
    }

    /* Checks that placing a tainted string from an int source into a statement results in a violation being reported on
     * the original test run, but does not result in a critical violation on the test rerun. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    @Source(method = "io/rivulet/maven/test/TestUtils.source()I")
    public void testInjectTaintedInt() throws Exception {
        int taintedInt = TestUtils.source() + 13;
        executeQueryAndCheckViolations(taintedInt + "");
    }

    /* Checks that inserting a tainted string from a char array source into a statement results in a violation on the
     * original test run and a critical violation on the test rerun. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testInjectTaintedCharArr() throws Exception {
        char[] taintedName = TestUtils.objSource(new String("Turtle").toCharArray());
        executeQueryAndCheckViolations(new String(taintedName));
    }


    /* Checks that inserting a tainted string from a char array source into a statement results in a violation on the
     * original test run and a critical violation on the test rerun. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testInjectTaintedChar2DArr() throws Exception {
        char[][] taintedNames = {new String("Turtle").toCharArray(), new String("Turtle").toCharArray()};
        TestUtils.objSource(taintedNames);
        executeQueryAndCheckViolations(new String(taintedNames[1]));
    }

    /* Checks that inserting a tainted string from a map source's value into a statement results in a violation on the
     * original test run and a critical violation on the test rerun. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testInjectTaintedMapStringValue() throws Exception {
        HashMap<Integer, String> taintedMap = new HashMap<>();
        taintedMap.put(0, new String("Turtle"));
        TestUtils.objSource(taintedMap);
        executeQueryAndCheckViolations(taintedMap.get(0));
    }

    /* Checks that inserting a tainted string from a string array source into a statement results in a violation on the
     * original test run and a critical violation on the test rerun. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testInjectTaintedStringArr() throws Exception {
        String[] taintedStrings = new String[]{new String("Turtle"), new String("Turtle")};
        TestUtils.objSource(taintedStrings);
        executeQueryAndCheckViolations(taintedStrings[1]);
    }

    /* Checks that inserting a tainted string from a string array source into a statement results in a violation on the
     * original test run and a critical violation on the test rerun. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testInjectTaintedByteStream() throws Exception {
        ByteArrayInputStream taintedStream = TestUtils.objSource(new ByteArrayInputStream((new String("Turtle")).getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while(taintedStream.available() > 0) {
            outputStream.write(taintedStream.read());
        }
        executeQueryAndCheckViolations(outputStream.toString());
    }

    /* Checks that inserting a tainted string from an ArrayList source into a statement results in a violation on the
     * original test run and a critical violation on the test rerun. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testInjectTaintedArrayList() throws Exception {
        ArrayList<String> taintedList= new ArrayList<>();
        taintedList.add(new String("Turtle"));
        TestUtils.objSource(taintedList);
        executeQueryAndCheckViolations(taintedList.get(0));
    }
}

