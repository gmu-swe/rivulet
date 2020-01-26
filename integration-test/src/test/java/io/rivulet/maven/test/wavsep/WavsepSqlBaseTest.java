package io.rivulet.maven.test.wavsep;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;

public abstract class WavsepSqlBaseTest extends WavsepBaseTest {
    private static final String MYSQL_PORT = System.getProperty("mysql.port");
    private static final String MYSQL_HOST = System.getProperty("mysql.host");
    private static final String MYSQL_USERNAME = System.getProperty("mysql.username");
    private static final String MYSQL_PASSWORD = System.getProperty("mysql.password");

    private static boolean initializedDatabase = false;

    public static final ExternalResource databaseResource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            if(!initializedDatabase) {
                initializedDatabase = true;
                // Make a POST request the to install page to setup the databases
                URIBuilder builder = getBaseURIBuilder().setPath("wavsep/wavsep-install/install.jsp");
                HttpPost post = new HttpPost(builder.build());
                String form = String.format("username=%s&password=%s&host=%s&port=%s&wavsep_username=&wavsep_password=",
                        MYSQL_USERNAME, MYSQL_PASSWORD, MYSQL_HOST, MYSQL_PORT);
                post.setEntity(new StringEntity(form, ContentType.APPLICATION_FORM_URLENCODED));
                makeRequest(post);
            }
        }
    };

    // That the Wavsep databases are not started until after the Wavsep application is added to Tomcat.
    @ClassRule
    public static final RuleChain chain = RuleChain
            .outerRule(webAppResource)
            .around(databaseResource);
}
