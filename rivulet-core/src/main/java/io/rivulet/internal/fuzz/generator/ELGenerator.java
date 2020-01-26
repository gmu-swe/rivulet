package io.rivulet.internal.fuzz.generator;

import io.rivulet.internal.Violation;
import io.rivulet.internal.rerun.RerunConfigBuilder;
import io.rivulet.internal.rerun.SinglePayloadRerunConfigBuilder;

import java.util.Arrays;
import java.util.List;

public class ELGenerator extends RCEGenerator {

	@Override
	public Iterable<? extends RerunConfigBuilder> generateRerunBuilders(Violation violation, Object receiver, Object[] arguments) {
		return Arrays.asList(
				new SinglePayloadRerunConfigBuilder(
//						"${\"abcd\".getClass().forName(\"io.rivulet.ExpressionInjectionDetector\").getDeclaredMethod(\"attack\").invoke(null,\"hello\")}"
						"${\"abcd\".getClass().forName(\"io.rivulet.ExpressionInjectionDetector\").getDeclaredMethod(\"attack\",\"abcd\".getClass().forName(\"java.lang.String\")).invoke(null,\"Hello!\")}"
				));
	}

	@Override
	public List<String> getTargetedBaseSinks() {
		return Arrays.asList(
				"io/rivulet/ExpressionInjectionDetector.attack(Ljava/lang/String;)V"
		);
	}

	@Override
	public boolean isApplicable(Violation violation) {
		return Arrays.asList("org/springframework/expression/ExpressionParser.parseExpression(Ljava/lang/String;)Lorg/springframework/expression/Expression;",
				"org/springframework/expression/common/TemplateAwareExpressionParser.parseExpression(Ljava/lang/String;)Lorg/springframework/expression/Expression;",
				"org/springframework/expression/spel/standard/SpelExpressionParser.parseExpression(Ljava/lang/String;)Lorg/springframework/expression/Expression;",
				"javax/el/ExpressionFactory.createMethodExpression(Ljavax/el/ELContext;Ljava/lang/String;Ljava/lang/Class;[Ljava/lang/Class;)Ljavax/el/MethodExpression;",
				"javax/el/ExpressionFactory.createValueExpression(Ljavax/el/ELContext;Ljava/lang/String;Ljava/lang/Class;)Ljavax/el/ValueExpression;").contains(violation.getBaseSink());
	}
}
