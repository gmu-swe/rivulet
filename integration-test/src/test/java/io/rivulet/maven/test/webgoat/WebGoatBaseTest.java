package io.rivulet.maven.test.webgoat;

import com.google.gson.Gson;
import edu.columbia.cs.psl.phosphor.PreMain;
import io.rivulet.maven.test.TomcatBaseTest;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.junit.Rule;
import org.junit.rules.ExternalResource;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.fail;

public abstract class WebGoatBaseTest extends TomcatBaseTest {

    private Header cookieHeader = null;
    private HashMap<String, String> linkMap = null;

    // Field for used by WebGoat to cache user progress
    private static Field userProgressCacheField = null;

    @Rule
    public final ExternalResource webGoatResource = new ExternalResource() {
        /* Ensures that the WebGoat application has been added to Tomcat. Logs in to WebGoat with default credentials and
         * stores the value the cookie header should be set to after logging in. */
        @Override
        protected void before() {
            try {
                // Add WebGoat application to Tomcat
                addWebApp("WebGoat");
                cleanLessonStateFiles();
                resetCaches();
                refreshDatabase();
                login();
                loadWelcomePage();
                linkMap = getLessonLinkMap();
            } catch(Exception e) {
                if(!methodTaintRule.isRivuletRerun()) {
                    fail();
                }
            }
        }

        @Override
        protected void after() {
            logout();
        }
    };

    /* Resets the database used by WebGoat. */
    private void refreshDatabase() {
        try {
            // Login as an admin
            login("webgoat", "webgoat");
            loadWelcomePage();
            linkMap = getLessonLinkMap();
            URIBuilder builder = getBaseURIBuilderForLesson("Refresh Database").addParameter("Refresh", "true");
            get(builder.build());
            logout();
        } catch(Exception e) {
            //
        }
    }

    /* Resets the user session cache used by WebGoat. */
    private void resetCaches() {
        try {
            if(userProgressCacheField == null) {
                Class<?> clazz = findUserTrackerClass();
                if(clazz != null) {
                    userProgressCacheField = clazz.getDeclaredField("storage");
                    userProgressCacheField.setAccessible(true);
                }
            }
            ((Map) userProgressCacheField.get(null)).clear();
        } catch(Exception e) {
            //
        }
    }

    /* Returns WebGoat's user tracker class or null if the user tracker class cannot be found. */
    private Class<?> findUserTrackerClass() {
        for(Class<?> clazz : PreMain.getInstrumentation().getAllLoadedClasses()) {
            if("org.owasp.webgoat.session.UserTracker".equals(clazz.getName())) {
                return clazz;
            }
        }
        return null;
    }

    /* Deletes user-specific lesson state files. */
    private void cleanLessonStateFiles() {
        try {
            File userDir = new File(getBaseWebAppDir() + File.separator + "WebGoat", "users");
            if(userDir.isDirectory()) {
                File[] files = userDir.listFiles();
                if(files != null) {
                    for(File file : files) {
                        if(file.getName().endsWith(".props")) {
                            if(!file.delete()) {
                                System.err.println("Failed to delete: " + file);
                            }
                        }
                    }
                } else {
                    System.err.println("Couldn't find WebGoat users folder. ");
                }
            } else {
                System.err.println("Couldn't find WebGoat users folder. ");
            }
        } catch(Exception e) {
            System.err.println("Failed to deletes user-specific lesson state files for WebGoat.");
        }
    }

    /* Logs out of WebGoat and cleans up user-specific lesson state files. */
    private void logout() {
        try {
            if(cookieHeader != null) {
                URIBuilder builder = getBaseURIBuilder().setPath("WebGoat/j_spring_security_logout");
                HttpGet get = new HttpGet(builder.build());
                get.setHeader(cookieHeader);
                makeRequest(get);
            }
        } catch(Throwable t) {
            if(!methodTaintRule.isRivuletRerun()) {
                fail();
            }
        } finally {
            cleanLessonStateFiles();
            cookieHeader = null;
            linkMap = null;
        }
    }

    /* Login to WebGoat with the specified credentials. */
    private void login(String username, String password) throws Exception {
        URIBuilder builder = getBaseURIBuilder().setPath("WebGoat/j_spring_security_check");
        HttpPost post = new HttpPost(builder.build());
        String form = String.format("username=%s&password=%s", username, password);
        StringEntity entity = new StringEntity(form, ContentType.APPLICATION_FORM_URLENCODED);
        post.setEntity(entity);
        HttpResponse response = makeRequestAndGetResponse(post, 302);
        Header setCookieHeader = response.getFirstHeader("Set-Cookie");
        // Set the Cookie header
        String cookieVal = setCookieHeader.getValue().contains(";") ?
                setCookieHeader.getValue().substring(0, setCookieHeader.getValue().indexOf(';')) : setCookieHeader.getValue();
        cookieHeader = new BasicHeader("Cookie", cookieVal);
    }

    /* Login to WebGoat with the guest credentials. */
    private void login() throws Exception {
        login("guest", "guest");
    }

    private void loadWelcomePage() throws Exception {
        URIBuilder builder = getBaseURIBuilder().setPath("WebGoat/welcome.mvc");
        HttpGet get= new HttpGet(builder.build());
        get.setHeader(cookieHeader);
        makeRequest(get);
    }

    @SuppressWarnings("unchecked")
    private void addLinks(Map map, HashMap<String, String> linkMap) {
        if(map.getOrDefault("name", null) != null && map.getOrDefault("link", null) != null ) {
            linkMap.put(map.get("name").toString(), map.get("link").toString());
        }
        if(map.getOrDefault("children", null) != null) {
            Iterable<? extends Map> children = (Iterable<? extends Map>)map.get("children");
            for(Map child : children) {
                addLinks(child, linkMap);
            }
        }
    }

    /* Returns a map from lesson names to links for the lesson. */
    private HashMap<String, String> getLessonLinkMap() throws Exception {
        URIBuilder builder = getBaseURIBuilder().setPath("WebGoat/service/lessonmenu.mvc");
        HttpGet get = new HttpGet(builder.build());
        get.setHeader(cookieHeader);
        String body = makeRequest(get);
        HashMap<String, String> linkMap = new HashMap<>();
        Map[] maps = new Gson().fromJson(body, Map[].class);
        for(Map map : maps) {
            addLinks(map, linkMap);
        }
        return linkMap;
    }

    /* Returns URIBuilder set to make a request for the lesson with the specified name. */
    public URIBuilder getBaseURIBuilderForLesson(String lessonName) {
        String link = linkMap.get(lessonName);
        if(link.contains("?")) {
            int index = link.indexOf('?');
            String query = link.substring(index + 1);
            return getBaseURIBuilder().setPath("WebGoat/" + link.substring(0, index)).setQuery(query);
        } else {
            return getBaseURIBuilder().setPath("WebGoat/" + link);
        }
    }

    public String postWithForm(URI uri, String form) throws Exception {
        HttpPost post = new HttpPost(uri);
        post.addHeader(cookieHeader);
        StringEntity entity = new StringEntity(form, ContentType.APPLICATION_FORM_URLENCODED);
        post.setEntity(entity);
        return makeRequest(post);
    }

    public String get(URI uri) throws Exception {
        HttpGet get = new HttpGet(uri);
        get.addHeader(cookieHeader);
        return makeRequest(get);
    }
}