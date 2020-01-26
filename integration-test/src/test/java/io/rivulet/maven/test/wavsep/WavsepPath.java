package io.rivulet.maven.test.wavsep;

/* Represents a path to various pages in the Wavsep application. */
public enum WavsepPath {

    SQL_GET_200_ERROR("wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-GET-200Error"),
    SQL_GET_200_ERROR_EXPERIMENTAL("wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-GET-200Error-Experimental"),
    SQL_GET_200_IDENTICAL("wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-GET-200Identical"),
    SQL_GET_200_VALID("wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-GET-200Valid"),
    SQL_GET_500_ERROR("wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-GET-500Error"),
    SQL_POST_200_ERROR("wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-POST-200Error"),
    SQL_POST_200_ERROR_EXPERIMENTAL("wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-POST-200Error-Experimental"),
    SQL_POST_200_IDENTICAL("wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-POST-200Identical"),
    SQL_POST_200_VALID("wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-POST-200Valid"),
    SQL_POST_500_ERROR("wavsep/active/SQL-Injection/SInjection-Detection-Evaluation-POST-500Error"),
    SQL_FALSE_POSITIVES("wavsep/active/SQL-Injection/SInjection-FalsePositives-GET"),
    RXSS_COOKIE("wavsep/active/Reflected-XSS/RXSS-Detection-Evaluation-COOKIE-Experimental"),
    RXSS_GET("wavsep/active/Reflected-XSS/RXSS-Detection-Evaluation-GET"),
    RXSS_GET_EXPERIMENTAL("wavsep/active/Reflected-XSS/RXSS-Detection-Evaluation-GET-Experimental"),
    RXSS_POST("wavsep/active/Reflected-XSS/RXSS-Detection-Evaluation-POST"),
    RXSS_POST_EXPERIMENTAL("wavsep/active/Reflected-XSS/RXSS-Detection-Evaluation-POST-Experimental"),
    RXSS_FALSE_POSITIVES("wavsep/active/Reflected-XSS/RXSS-FalsePositives-GET");

    private final String value;

    WavsepPath(String value) {
        this.value = value;
    }

    public String getPagePath(String pageName) {
        return value + "/" + pageName;
    }
}
