package io.rivulet.maven.test;

import io.rivulet.RemoteTaintServerFacade;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.maven.shared.utils.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;

import java.io.*;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.junit.Assert.assertEquals;

public abstract class TomcatBaseTest extends ViolationCheckingBaseTest {

    // Embedded tomcat instance
    private static Tomcat tomcat = null;
    // Path of the base directory used by Tomcat
    private static final String tomcatBaseDir = System.getProperty("tomcat.base.directory", "tomcat");
    // Path of the directory to which web application files are extracted
    private static final String webAppsBaseDir = System.getProperty("webapps.base.directory", "webapps");
    // Path of the directory containing war files for the web applications
    private static final String webAppsWarDir = ".." + File.separator + "experiments" + File.separator + "apache-tomcat-8.0.47" + File.separator + "webapps";
    // Set of names of the web applications already added to tomcat
    private static final HashSet<String> addedWebApps = new HashSet<>();
    // Port of remote embedded tomcat instance, if set
    private static final int remoteTomcatPort = Integer.parseInt(System.getProperty("tomcat.port", "-1"));
    private static final int remoteAdminPort = Integer.parseInt(System.getProperty("ifc.port", "-1"));
    private static RemoteTaintServerFacade remoteTaintServerFacade;
    private static final int INSTALL_TIMEOUT = 1000 * 60; // 1 minute

    @ClassRule
    public static final ExternalResource tomcatResource = new ExternalResource() {

        @Override
        protected void before() throws Throwable {
            if(remoteAdminPort > 0) {
                remoteTaintServerFacade = new RemoteTaintServerFacade(remoteAdminPort);
                Runnable shutdown = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            remoteTaintServerFacade.close();
                        } catch(IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                Runtime.getRuntime().addShutdownHook(new Thread(shutdown));
            } else if(tomcat == null) {
                // Setup the embedded server
                Class<?> c = Class.forName("org.apache.tomcat.util.http.parser.HttpParser");
                Field f = c.getDeclaredField("IS_RELAXABLE");
                f.setAccessible(true);
                boolean[] ar = (boolean[]) f.get(null);
                ar['\''] = true;

                f = c.getDeclaredField("IS_SUBDELIM");
                f.setAccessible(true);
                ar = (boolean[]) f.get(null);
                ar['\''] = false;

                f = c.getDeclaredField("IS_USERINFO");
                f.setAccessible(true);
                ar = (boolean[]) f.get(null);
                ar['\''] = false;


                tomcat = new Tomcat();
                tomcat.setBaseDir(tomcatBaseDir);
                tomcat.getHost().setAppBase(tomcatBaseDir);
                String protocol = Http11NioProtocol.class.getName();
                Connector connector = new Connector(protocol);
                // Listen on localhost
                connector.setAttribute("address", InetAddress.getByName("localhost").getHostAddress());
                // Use a random free port
                connector.setPort(0);

                connector.setProperty("relaxedPathChars","<>`'");
                connector.setProperty("relaxedQueryChars","<>`'");
                tomcat.getService().addConnector(connector);
                tomcat.setConnector(connector);
                tomcat.setSilent(true);
                tomcat.getHost().setDeployOnStartup(true);
                tomcat.getHost().setAutoDeploy(true);
                // Reduce logging
                System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
                replaceRootLoggerHandlers();


                //Set up a response for /, used by some tests in juliet
                File docBaseDir= new File(tomcatBaseDir, "doc-base");
                if(!docBaseDir.exists()) {
                    docBaseDir.mkdirs();
                    FileWriter fw = new FileWriter(new File(docBaseDir, "index.html"));
                    fw.write("Hi!\n");
                    fw.close();

                }

                Context rootContext = tomcat.addContext("/", "doc-base/");
                Tomcat.initWebappDefaults(rootContext);
                tomcat.init();
                tomcat.start();
                waitForTomcat();

                // Used by Julia, doesn't hurt to set for everyone
                System.setProperty("juliet.remoteURL","http://127.0.0.1:"+getPort()+"/");

                // Add the shutdown hook to stop the embedded server
                Runnable shutdown = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            try {
                                // Stop and destroy the server
                                if(tomcat.getServer() != null && tomcat.getServer().getState() != LifecycleState.DESTROYED) {
                                    if(tomcat.getServer().getState() != LifecycleState.STOPPED) {
                                        tomcat.stop();
                                    }
                                    tomcat.destroy();
                                    tomcat = null;
                                }
                            } finally {
                                // Delete tomcat's temporary working directory
                                FileUtils.deleteDirectory(new File(tomcatBaseDir));
                            }
                        } catch(Throwable t) {
                            t.printStackTrace();
                        }
                    }
                };
                Runtime.getRuntime().addShutdownHook(new Thread(shutdown));
                if(System.getenv("CI") != null){
                    Timer timer = new Timer(true);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            System.out.println("Travis keep-alive");
                        }
                    }, 0, 1000 * 60 * 5);

                }
            }
        }
    };

    /* Makes a request to get the value for the anti-CSRF token. Makes a second request at the specified path with the
     * specified token name parameter's value set to the value of the token that was received. Checks the
     * response status and that at least one violation was reported. */
    protected String testPathWithAntiCSRFToken(URIBuilder builderWithRequestParamsReady, String tokenName) throws Exception {
        // Get the token
        URIBuilder builder = getBaseURIBuilder().setPath(builderWithRequestParamsReady.getPath());
        String tokenValue = null;
        Header cookieHeader = new BasicHeader("Cookie", null);
        try {
            HttpResponse response = makeRequestAndGetResponse(new HttpGet(builder.build()), 200);
            // Get the Set-Cookie header and use it to make a cookies header for the next response
            Header setCookieHeader = response.getFirstHeader("Set-Cookie");
            String cookieVal = setCookieHeader.getValue().contains(";") ?
                    setCookieHeader.getValue().substring(0, setCookieHeader.getValue().indexOf(';')) : setCookieHeader.getValue();
            cookieHeader = new BasicHeader("Cookie", cookieVal);
            tokenValue = getAntiCSRFToken(EntityUtils.toString(response.getEntity()), tokenName);
            EntityUtils.consume(response.getEntity());
        } catch(Exception e) {
            if(!classTaintRule.isRivuletRerun()) {
                throw e;
            }
        }
        // Make a request with the token
        builderWithRequestParamsReady.addParameter(tokenName, tokenValue);
        HttpPost post = new HttpPost(builderWithRequestParamsReady.build());
        post.addHeader(cookieHeader);
        String ret = makeRequest(post, 200);
        checkViolationsIncreased();
        return ret;
    }

    private static void waitForTomcat(){
        long start = System.currentTimeMillis();
        while(true){
            long now = System.currentTimeMillis();
            String status = pingTomcat();
            if(status.contains("Hi!"))
                return;
            try {
                if(now - start > INSTALL_TIMEOUT) {
                    System.err.println(status);
                    throw new IllegalStateException("Application failed to start within timeout, see current status above");
                }
                Thread.sleep(1000 * 60);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* Returns a newly created file handler with the specified logging level that logs to a file in the base tomcat directory. */
    private static Handler createFileHandler() throws IOException {
        // Ensure that the base directory exists
        File baseDirFile = new File(tomcatBaseDir);
        if(!baseDirFile.isDirectory() && !baseDirFile.mkdirs()) {
            System.err.println("Failed to make base directory for embedded tomcat.");
        }
        Handler fileHandler = new FileHandler(tomcatBaseDir + File.separator + "catalina.out", true);
        fileHandler.setFormatter(new SimpleFormatter());
        fileHandler.setLevel(Level.INFO);
        fileHandler.setEncoding("UTF-8");
        return fileHandler;
    }

    /* Removes any existing handlers for the specified logger and adds the specified handler. */
    private static void replaceRootLoggerHandlers() throws IOException {
        Logger rootLogger = LogManager.getLogManager().getLogger("");
        rootLogger.setUseParentHandlers(false);
        // Change the level of any existing handlers to OFF
        for(Handler h : rootLogger.getHandlers()) {
            h.setLevel(Level.OFF);
        }
        // Add a file handler for INFO level logging
        rootLogger.addHandler(createFileHandler());
    }

    /* If the directory for the web-app with the specified name does not exists creates it by unzipping the war for the
     * web-app. */
    private static void unzipWar(String name) throws IOException {
        File dir = new File(webAppsBaseDir, name);
        if(!dir.isDirectory()) {
            // Unzip war into the directory only if it does not already exists
            File webAppWar = new File(webAppsWarDir, name + ".war");
            if(!webAppWar.isFile()) {
                throw new RuntimeException("Could not find war file for: " + name);
            }
            try(ZipFile zipFile = new ZipFile(webAppWar)) {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while(entries.hasMoreElements()) {
                    ZipEntry entry = entries.nextElement();
                    File entryDestination = new File(dir, entry.getName());
                    if(entry.isDirectory()) {
                        if(!entryDestination.isDirectory() && !entryDestination.mkdirs()) {
                            throw new RuntimeException("Failed to make directory for: " + entryDestination);
                        }
                        // Add velocity.properties file
                        File velocityPropFile = new File(entryDestination, "velocity.properties");
                        try {
                            org.apache.commons.io.FileUtils.writeStringToFile(velocityPropFile,
                                    "runtime.log.logsystem.class=org.apache.velocity.runtime.log.NullLogChute", Consts.UTF_8, false);
                        } catch(Exception e) {
                            //
                        }
                    } else {
                        if(!entryDestination.getParentFile().isDirectory() && !entryDestination.getParentFile().mkdirs()) {
                            throw new RuntimeException("Failed to make directory for: " + entryDestination.getParentFile());
                        }
                        if(entry.getName().endsWith("log4j.properties")) {
                            // Write different logging properties
                            writeLog4JProperties(entryDestination);
                        } else {
                            InputStream in = zipFile.getInputStream(entry);
                            OutputStream out = new FileOutputStream(entryDestination);
                            IOUtils.copy(in, out);
                            IOUtils.closeQuietly(in);
                            out.close();
                        }
                    }
                }
            }
        }
    }

    /* Writes log4j properties to disable logging to the specified file. */
    private static void writeLog4JProperties(File file) throws IOException {
        String content =
                "log4j.rootLogger=OFF, stdout\n" +
                "log4j.appender.stdout=org.apache.log4j.ConsoleAppender\n" +
                "log4j.appender.stdout.layout=org.apache.log4j.SimpleLayout\n";
        org.apache.commons.io.FileUtils.writeStringToFile(file,
                content, Consts.UTF_8, false);
    }

    /* Adds the webapp with the specified name if has not already been added to the embedded server. */
    public static void addWebApp(String name) throws Exception  {
        if(addedWebApps.add(name)) {
            if(remoteTomcatPort != -1){
                remoteTaintServerFacade.addWebApp(name, new File(webAppsWarDir, name).getCanonicalPath() + ".war");
            }
            else {
                unzipWar(name);
                tomcat.addWebapp("/" + name, new File(webAppsBaseDir, name).getCanonicalPath());
            }
        }
    }

    /* Returns the port of the embedded tomcat server. */
    public static int getPort() {
        if(remoteTomcatPort != -1)
            return remoteTomcatPort;
        return tomcat.getConnector().getLocalPort();
    }

    /* Returns the host name of the embedded tomcat server. */
    public static String getHostName() {
        if(remoteTomcatPort != -1)
            return "localhost";
        return tomcat.getHost().getName();
    }

    /* Returns the path of the directory to which web application files are extracted. */
    public static String getBaseWebAppDir() {
        return webAppsBaseDir;
    }

    /* Returns a URIBuilder with the base components for making requests to the embedded server set. */
    public static URIBuilder getBaseURIBuilder() {
        return new URIBuilder()
                .setScheme("http")
                .setHost(getHostName())
                .setPort(getPort());
    }

    /* Executes the specified request and returns the contents of the response. */
    public static String makeRequest(HttpUriRequest request) throws Exception {
        return makeRequest(request, -1, false);
    }

    /* Executes the specified request and asserts that the resulting response has the specified status code. Returns the
     * contents of the response. */
    public static String makeRequest(HttpUriRequest request, int statusCode) throws Exception {
        return makeRequest(request, statusCode, true);
    }

    /* Executes the specified request and asserts that the resulting response has the specified status code if checkStatus
     * is true. Returns the contents of the response. */
    protected static String makeRequest(HttpUriRequest request, int statusCode, boolean checkStatus) throws Exception {
        String result = null;
        try(CloseableHttpClient client = HttpClientBuilder.create().build(); CloseableHttpResponse response = client.execute(request)) {
            HttpEntity entity = response.getEntity();
            if(entity != null) {
                if(entity.getContentLength() != -1 || entity.isChunked()) {
                    result = EntityUtils.toString(entity);
                }
            }
            if(checkStatus && !classTaintRule.isRivuletRerun()) {
                // Reruns may fail status check
                assertEquals(statusCode, response.getStatusLine().getStatusCode());
            }
            EntityUtils.consume(entity);
        } catch(Exception e) {
            // Exceptions may occur on test reruns
            if(!classTaintRule.isRivuletRerun()) {
                throw e;
            }
        }
        return result;
    }

    private static String pingTomcat() {
        String result = null;
        URIBuilder builder = new URIBuilder()
                .setScheme("http")
                .setHost(tomcat.getHost().getName())
                .setPort(tomcat.getConnector().getLocalPort()).setPath("/");
        CloseableHttpClient client = HttpClientBuilder.create().build();
        try(CloseableHttpResponse response = client.execute(new HttpGet(builder.build()))) {
            HttpEntity entity = response.getEntity();
            if(entity != null) {
                if(entity.getContentLength() != -1 || entity.isChunked()) {
                    result = EntityUtils.toString(entity);
                }
            }
            EntityUtils.consume(entity);
        } catch(Exception e) {
            //
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /* Executes the specified request and returns the response. */
    public static HttpResponse makeRequestAndGetResponse(HttpUriRequest request) throws Exception {
        return makeRequestAndGetResponse(request, -1, false);
    }

    /* Executes the specified request and asserts that the resulting response has the specified status code. Returns the
     * response. */
    public static HttpResponse makeRequestAndGetResponse(HttpUriRequest request, int statusCode) throws Exception {
        return makeRequestAndGetResponse(request, statusCode, true);
    }

    /* Executes the specified request and asserts that the resulting response has the specified status code if checkStatus
     * is true. Returns the response. */
    protected static HttpResponse makeRequestAndGetResponse(HttpUriRequest request, int statusCode, boolean checkStatus) throws Exception {
        try(CloseableHttpClient client = HttpClientBuilder.create().build()) {
            CloseableHttpResponse response = client.execute(request);
            if(checkStatus && !classTaintRule.isRivuletRerun()) {
                // Reruns may fail status check
                assertEquals(statusCode, response.getStatusLine().getStatusCode());
            }
            return consumeResponse(response);
        } catch(Exception e) {
            // Exceptions may occur on test reruns
            if(!classTaintRule.isRivuletRerun()) {
                throw e;
            }
            return null;
        }
    }

    /* Returns the Anti-CSRF token from the specified html response body. */
    private static String getAntiCSRFToken(String html, String fieldName) {
        Document doc = Jsoup.parse(html);
        for(Element element : doc.getElementsByAttributeValue("type", "hidden")) {
            if(element.hasAttr("name") && element.attr("name").equals(fieldName) && element.hasAttr("value")) {
                return element.attr("value");
            }
        }
        return null;
    }

    private static HttpResponse consumeResponse(CloseableHttpResponse response) throws IOException {
        BasicHttpResponse basicResponse = new BasicHttpResponse(response.getStatusLine(), null, response.getLocale());
        basicResponse.setHeaders(response.getAllHeaders());
        HttpEntity entity = response.getEntity();
        if(entity != null) {
            if(entity.getContentLength() != -1 || entity.isChunked()) {
                entity = new StringEntity(EntityUtils.toString(entity));
            }
        }
        EntityUtils.consume(response.getEntity());
        basicResponse.setEntity(entity);
        response.close();
        return basicResponse;
    }
}