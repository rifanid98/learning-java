package java10_java_database.lesson12_metadata;

import java10_java_database.lesson03_data_source.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * MetaData
 *
 * - Kadang kita ingin mendapat informasi seputar database yang kita gunakan
 * - Informasi tersebut bernama MetaData
 * - Ada banyak jenis metadata, seperti DatabaseMetaData, ParameterMetaData, ResultSetMetaData
 * - https://docs.oracle.com/en/java/javase/15/docs/api/java.sql/java/sql/DatabaseMetaData.html
 * - https://docs.oracle.com/en/java/javase/15/docs/api/java.sql/java/sql/ParameterMetaData.html
 * - https://docs.oracle.com/en/java/javase/15/docs/api/java.sql/java/sql/ResultSetMetaData.html
 *
 * Database MetaData
 *
 * DatabaseMetaData adalah informasi seputar seluruh database yang kita gunakan, seperti misal :
 * - Nama database
 * - Versi database
 * - Table yang ada di database
 * - dan lain-lain
 * Untuk membuat DatabaseMetaData, kita bisa menggunakan method getMetaData() dari object Collection
 *
 * Parameter MetaData
 *
 * - ParameterMetadata adalah informasi seputar parameter yang terdapat di PreparedStatement
 * - Dengan ParameterMetadata, kita bisa mendapat banyak informasi parameter yang bisa digunakan untuk input di
 *   PreparedStatement, seperti berapa banyak parameter, tipe data parameter, dan lain-lain
 * - Namun perlu diperhatikan, beberapa Driver mungkin tidak mendukung untuk mendapatkan jenis tipe parameter di
 *   ParameterMetadata
 *
 * ResultSet MetaData
 *
 * - ResultSetMetaData adalah informasi seputar hasil ResultSet
 * - Dengan ResultSetMetaData, kita bisa mendapatkan informasi tentang jumlah kolom, nama kolom, tipe data tiap kolom
 *   nya, dan lain-lain
 */
public class MetaDataTest {

    @Test
    void testDatabaseMetaData() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        System.out.println(databaseMetaData.getDatabaseProductName());
        System.out.println(databaseMetaData.getDatabaseProductVersion());

        ResultSet resultSet = databaseMetaData.getTables("belajar_java_database", null, null, null);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("TABLE_NAME"));
        }

        connection.close();
    }

    @Test
    void testParameterMetaData() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        String sql = "INSERT INTO comments(email, comment) VALUES(?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "email@email.com");
        preparedStatement.setString(2, "comment");

        ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
        System.out.println(parameterMetaData.getParameterCount());
        // System.out.println(parameterMetaData.getParameterTypeName(1));

        preparedStatement.close();
        connection.close();
    }

    @Test
    void testResultSetMetaData() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM comments");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        System.out.println(resultSetMetaData.getColumnCount());

        for (int i = 1; i <= resultSetMetaData.getColumnCount() ; i++) {
            System.out.println("Name : " + resultSetMetaData.getColumnName(i));
            System.out.println("Type : " + resultSetMetaData.getColumnType(i));
            System.out.println("TypeName : " + resultSetMetaData.getColumnTypeName(i));

            if (resultSetMetaData.getColumnType(i) == Types.INTEGER) {
                System.out.println("ini Integer");
            }
        }

        statement.close();
        connection.close();
    }
}
