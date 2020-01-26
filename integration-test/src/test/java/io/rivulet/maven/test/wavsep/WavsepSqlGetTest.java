package io.rivulet.maven.test.wavsep;

import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;

import static io.rivulet.maven.test.wavsep.WavsepPath.*;

@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
@Sink(method = "java/sql/Statement.executeQuery(Ljava/lang/String;)Ljava/sql/ResultSet;")
@Sink(method = "java/sql/Statement.executeUpdate(Ljava/lang/String;)I")
@Sink(method = "java/sql/Connection.prepareStatement(Ljava/lang/String;)Ljava/sql/PreparedStatement;")
public class WavsepSqlGetTest extends WavsepSqlGenericTest {

    public WavsepSqlGetTest() {
        super(SQL_GET_200_ERROR, SQL_GET_200_ERROR_EXPERIMENTAL, SQL_GET_200_IDENTICAL, SQL_GET_200_VALID,
                SQL_GET_500_ERROR, false);
    }
}

