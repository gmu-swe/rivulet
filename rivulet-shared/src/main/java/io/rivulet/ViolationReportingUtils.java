package io.rivulet;

/* Utility class for formatting information printed to the command for the user about violations and test reruns. */
public class ViolationReportingUtils {

    /* Whether or not ansi escape sequences can be used to color and bold violation messages. */
    public static boolean noAnsiEscapeSeqs = Boolean.parseBoolean(System.getProperty("ifc.noAnsiEscape","false"));

    /* Represents some color used to emphasize parts of messages. */
    public enum RivuletColor {
        VIOLATION(95),
        INFO(96),
        FAILURE(31),
        SUCCESS(92);

        private int foregroundCode;

        private RivuletColor(int foregroundCode) {
            this.foregroundCode = foregroundCode;
        }

        public int getForegroundCode() {
            return foregroundCode;
        }
    }

    /* Surrounds the specified text with the needed ANSI escape sequences to color the text's foreground  the specified
     * color. */
    public static String colorText(String text, RivuletColor color) {
        return noAnsiEscapeSeqs ? text: String.format("%c[%dm%s%c[0m", (char)27, color.getForegroundCode(), text, (char)27) ;
    }

    /* Surrounds the specified text with the needed ANSI escape sequences to bold it. */
    public static String boldText(String text) {
        return noAnsiEscapeSeqs ? text : String.format("%c[1m%s%c[0m", (char)27, text, (char)27);
    }

    /* Returns a well formatted test name for printing to standard out. */
    public static String formatTestName(String className, String methodName) {
        if(className == null || methodName == null) {
            return "";
        }
        int splitPoint =className.lastIndexOf(".");
        String temp = ViolationReportingUtils.boldText(String.format("%s#%s", className.substring(splitPoint+1), methodName));
        return String.format("in %s.%s", className.substring(0, splitPoint), temp);
    }

}
