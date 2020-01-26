package io.rivulet.internal.rerun.test;

import io.rivulet.internal.fuzz.generator.SqlInjectionGenerator;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class GenerateSqlInjectionRerunsTest extends GenerateRerunsBaseTest {

    public GenerateSqlInjectionRerunsTest(String template, String originalValue) {
        super(new SqlInjectionGenerator(), template, originalValue);
    }

    @Parameterized.Parameters
    public static Collection sql() {
        return Arrays.asList(new Object[][] {
                {"SELECT * FROM users ORDER BY %s;", "name"}, // Tainted element unquoted and uncommented
                {"SELECT * FROM users WHERE name = '%s';", "Tom"}, // Tainted element single quoted
                {"SELECT * FROM users WHERE name = \"%s\";", "Tom"}, // Tainted element double quoted
                {"SELECT * FROM `%s`;", "movies"}, // Tainted element backtick quoted
                {"SELECT * FROM users WHERE name = Tom -- %s;", "hello"}, // Tainted element single line -- commented
                {"SELECT * FROM users WHERE name = Tom # %s;", "hello"}, // Tainted element single line # commented
                {"SELECT * FROM users /* %s */ WHERE name = Tom;", "hello"}, // Tainted element multiline commented
                {"SELECT * FROM user WHERE name LIKE '%s'", "Tom"} // Tainted element in LIKE clause
        });
    }
}
