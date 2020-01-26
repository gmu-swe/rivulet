package io.rivulet.internal.fuzz.generator;

import edu.columbia.cs.psl.phosphor.runtime.Taint;
import io.rivulet.internal.ParseUtils;
import io.rivulet.internal.Violation;
import io.rivulet.internal.rerun.TestRerunConfiguration;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.relational.LikeExpression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;

import java.util.*;

public class SqlInjectionGenerator extends RerunGeneratorWrapper {

	// Base sink methods targeted by this type of generator
	private static final List<String> targetedSinks = Arrays.asList(
			"java/sql/Statement.executeQuery(Ljava/lang/String;)Ljava/sql/ResultSet;",
			"java/sql/Statement.execute(Ljava/lang/String;)Z",
			"java/sql/Statement.execute(Ljava/lang/String;I)Z",
			"java/sql/Statement.execute(Ljava/lang/String;[I)Z",
			"java/sql/Statement.execute(Ljava/lang/String;[Ljava/lang/String;)Z",
			"java/sql/Statement.executeUpdate(Ljava/lang/String;)I",
			"java/sql/Statement.executeUpdate(Ljava/lang/String;I)I",
			"java/sql/Statement.executeUpdate(Ljava/lang/String;[I)I",
			"java/sql/Statement.executeUpdate(Ljava/lang/String;[Ljava/lang/String;)I",
			"java/sql/Statement.executeLargeUpdate(Ljava/lang/String;)J",
			"java/sql/Statement.executeLargeUpdate(Ljava/lang/String;I)J",
			"java/sql/Statement.executeLargeUpdate(Ljava/lang/String;[I)J",
			"java/sql/Statement.executeLargeUpdate(Ljava/lang/String;[Ljava/lang/String;)J",
			"java/sql/Statement.addBatch(Ljava/lang/String;)V",
			"java/sql/Connection.prepareCall(Ljava/lang/String;)Ljava/sql/CallableStatement;",
			"java/sql/Connection.prepareCall(Ljava/lang/String;II)Ljava/sql/CallableStatement;",
			"java/sql/Connection.prepareCall(Ljava/lang/String;III)Ljava/sql/CallableStatement;",
			"java/sql/Connection.prepareStatement(Ljava/lang/String;)Ljava/sql/PreparedStatement;",
			"java/sql/Connection.prepareStatement(Ljava/lang/String;I)Ljava/sql/PreparedStatement;",
			"java/sql/Connection.prepareStatement(Ljava/lang/String;II)Ljava/sql/PreparedStatement;",
			"java/sql/Connection.prepareStatement(Ljava/lang/String;III)Ljava/sql/PreparedStatement;",
			"java/sql/Connection.prepareStatement(Ljava/lang/String;[I)Ljava/sql/PreparedStatement;",
			"java/sql/Connection.prepareStatement(Ljava/lang/String;[Ljava/lang/String;)Ljava/sql/PreparedStatement;",
			"java/sql/Connection.nativeSQL(Ljava/lang/String;)Ljava/lang/String;"
	);
	// Common SQL keywords
	private static final List<String> sqlKeywords = Arrays.asList("ADD", "ALTER", "ALL", "AND", "ANY", "AS", "ASC",
			"BACKUP", "BETWEEN", "BULK", "CASE", "CHECK", "COLUMN", "CONSTRAINT", "CREATE", "DATABASE", "DEFAULT",
			"DELETE", "DESC", "DISTINCT", "DROP", "EXEC", "EXISTS", "GROUP", "HAVING", "IN", "INDEX", "INNER", "INSERT",
			"INTO", "IS", "JOIN", "KEY", "LIKE", "LIMIT", "NOT", "NULL", "OR", "ORDER", "OUTER", "PROCEDURE", "ROWNUM",
			"SELECT", "SET", "TABLE", "TOP", "TRUNCATE", "UNION", "UNIQUE", "UPDATE", "VALUES", "VIEW", "WHERE"
	);
	// Regex for parts of original values that should be removed before adding the original value into a payload
	private static final String REMOVE_REGEX = "['\"`#]|(--)|(/\\*)|(\\*/)";

	/* Returns builders with SQL injection payloads inspired by
	 * https://www.owasp.org/index.php/Testing_for_SQL_Injection_(OTG-INPVAL-005) that leverage information about the
	 * context of the tainted values in the SQL statement. */
	@Override
	public Collection<TestRerunConfiguration> generateReruns(Violation violation, Object receiver, Object[] arguments)  {
		if(arguments == null || arguments.length == 0 || !(arguments[0] instanceof String)) {
			return new LinkedList<>();
		}
		LinkedHashSet<TestRerunConfiguration> configs = new LinkedHashSet<>();
		String sql = (String) arguments[0];
		List<LinkedList<String>> parts = ParseUtils.parseSQL(sql);
		for(String codeChunk : parts.get(0)) {
			generateRerunsForUncommentedChunk(codeChunk, violation, configs, "");
		}
		for(String commentedChunk : parts.get(1)) {
			generateRerunsForCommentedChunk(commentedChunk, violation, configs);
		}
		for(String quotedChunk : parts.get(2)) {
			generateRerunsForUncommentedChunk(quotedChunk, violation, configs, quotedChunk.charAt(0) + "");
		}
		try {
			for(LikeExpression expression : findLikeExpressions(sql)) {
				generateRerunsForLikeExpression(expression, violation, configs);
			}
		} catch(JSQLParserException e) {
			// Couldn't parse to check LIKE expressions; SQL is probably malformed. Replace tainted section with
			// stand-in values and retry parsing.
			String retrySql = replaceTaintedChunksWithStandIns(sql);
			try {
				for(LikeExpression expression : findLikeExpressions(retrySql)) {
					generateRerunsForLikeExpression(expression, violation, configs);
				}
			} catch(JSQLParserException ex) {
				// SQL is still malformed
			}
		}
		return configs;
	}

	/* Adds rerun configurations to the specified set for the specified chunk of uncommented SQL. */
	private void generateRerunsForUncommentedChunk(String chunk, Violation originalViolation,
												   LinkedHashSet<TestRerunConfiguration> configs, String quote) {
		if(containsTaintedChar(chunk)) {
			List<String> payloads = Arrays.asList(
					String.format("%s%s; DROP TABLE users; --", "%s", quote),
					String.format("%s%s UNION SELECT table_name, 's', '1' FROM information_scheme.tables --", "%s", quote),
					String.format("%s%s/**/OR/**/true--", "%s", quote)
			);
			configs.addAll(generateRerunsUsingTaintedChunks(originalViolation, chunk, payloads,0, REMOVE_REGEX));
		}
	}

	/* Adds rerun configurations to the specified set for the specified tainted chunk of commented SQL. */
	private void generateRerunsForCommentedChunk(String chunk, Violation originalViolation, LinkedHashSet<TestRerunConfiguration> configs) {
		if(containsTaintedChar(chunk)) {
			String commentExit = chunk.startsWith("/*") ? "*/" : "\n";
			String commentStart = (chunk.startsWith("#") || chunk.length() < 2) ? "#" : chunk.substring(0, 2);
			List<String> payloads = Arrays.asList(
					String.format("%s %s DROP TABLE users %s", "%s", commentExit, commentStart),
					String.format("%s %s ; DROP TABLE users; %s", "%s", commentExit, commentStart)
			);
			configs.addAll(generateRerunsUsingTaintedChunks(originalViolation, chunk, payloads,0, REMOVE_REGEX));
		}
	}

	/* Adds rerun configurations to the specified set for the specified tainted like expression. */
	private void generateRerunsForLikeExpression(LikeExpression expression, Violation originalViolation, LinkedHashSet<TestRerunConfiguration> configs) {
		List<String> payloads = Arrays.asList(
				"%s%%a%%%%%%%%",
				"%sa_____a"
		);
		configs.addAll(generateRerunsUsingTaintedChunks(originalViolation, expression.getRightExpression().toString(),
				payloads,0, REMOVE_REGEX));
	}

	/* Reports a violation if a tainted, unescaped, uncommented SQL keyword reached a targeted SQL sink. */
	@Override
	public void checkTaint(Object obj, int argIndex, Violation violation) {
		if(obj instanceof String) {
			String sql = (String) obj;
			List<String> code = ParseUtils.parseSQL(sql).get(0);
			// Check for unquoted and and uncommented tainted SQL keywords
			for(String chunk : code) {
				String[] tokens = chunk.toUpperCase().split("\\s+");
				for(String token : tokens) {
					if(sqlKeywords.contains(token) && containsTaintedChar(token)) {
						super.checkTaint(sql, argIndex, violation, false);
						return;
					}
				}
			}
			// Check for tainted, unescaped wildcards in LIKE clauses
			try {
				for(LikeExpression expression : findLikeExpressions(sql)) {
					if(checkLikeExpression(expression)) {
						super.checkTaint(sql, argIndex, violation, false);
						return;
					}
				}
			} catch(JSQLParserException e) {
				// Couldn't parse to check LIKE expressions; SQL is probably malformed.
			}
		}
	}

	/* Returns whether the specified LIKE clause contains a tainted, unescaped wildcard. */
	private boolean checkLikeExpression(LikeExpression expression) {
		String value = expression.getRightExpression().toString();
		if(containsTaintedChar(value)) {
			String escape = expression.getEscape();
			if(escape == null || escape.length() == 0) {
				// Use default escape character
				escape = "\\";
			}
			// Removed escaped characters from the value
			while(value.contains(escape)) {
				int index = value.indexOf(escape);
				int end = index + escape.length();
				if(end < value.length()) {
					end ++;
				}
				value = value.substring(0, index) + value.substring(end);
			}
			Taint[] tags = getStringValueTaints(value);
			if(tags != null) {
				for(int i = 0; i < tags.length; i++) {
					if((value.charAt(i) == '%' || value.charAt(i) == '_') && tags[i] != null && !tags[i].isEmpty()) {
						// Tainted, unescaped wildcard found
						return true;
					}
				}
			}
		}
		return false;
	}

	/* Adds any like expressions found in the specified SELECT body to the specified list. */
	private void findLikeExpressions(SelectBody body, List<LikeExpression> expressions) {
		if(body instanceof PlainSelect) {
			PlainSelect select = (PlainSelect) body;
			Expression where = select.getWhere();
			if(where instanceof LikeExpression) {
				expressions.add((LikeExpression) where);
			}
		} else if(body instanceof SetOperationList) {
			SetOperationList setOpList = (SetOperationList) body;
			for(SelectBody el : setOpList.getSelects()) {
				findLikeExpressions(el, expressions);
			}
		}
	}

	/* Returns a list containing all of the LIKE expressions in the specified SQL String. */
	private List<LikeExpression> findLikeExpressions(String sql) throws JSQLParserException {
		List<LikeExpression> expressions = new LinkedList<>();
		// Check for SELECT statements with WHERE clauses with tainted LIKE expression
		List<Statement> statements = CCJSqlParserUtil.parseStatements(sql).getStatements();
		for(Statement statement : statements) {
			if(statement instanceof Select) {
				SelectBody body = ((Select)statement).getSelectBody();
				findLikeExpressions(body, expressions);
			}
		}
		return expressions;
	}

	@Override
	public List<String> getTargetedBaseSinks() {
		return targetedSinks;
	}
}
