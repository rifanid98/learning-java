package java10_java_database.lesson04_statement;

import java10_java_database.lesson03_data_source.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * # Mengirim Perintah SQL
 *
 * - Saat kita terkoneksi ke database via Connection, sudah pasti kita ingin mengirim perintah SQL ke database
 * - Connection adalah object yang bertugas sebagai jembatan koneksi dari aplikasi kita ke database, untuk mengirim
 *   perintah SQL, kita bisa menggunakan beberapa object lain, salah satunya yang akan kita bahas sekarang, yaitu Statement
 *
 * Statement
 *
 * - java.sql.Statement adalah interface yang bisa kita gunakan untuk mengirim SQL ke database, sekaligus menerima
 *   response data dari database
 * - Ada banyak method yang bisa kita gunakan di Statement untuk mengirim perintah SQL, kita akan bahas satu persatu
 * - https://docs.oracle.com/en/java/javase/15/docs/api/java.sql/java/sql/Statement.html
 * - Untuk membuat statement kita bisa menggunakan method createStatement() milik Connection
 *
 * Statement.executeUpdate(sql)
 *
 * - Method pertama yang akan kita bahas adalah executeUpdate(sql)
 * - Method ini digunakan untuk mengirim perintah SQL INSERT, UPDATE, DELETE atau apapun yang tidak membutuhkan result
 * - Bahkan bisa perintah SQL DDL (create table, create index, dan lain-lain), walaupun best practice nya, perintah DDL
 *   lebih baik dilakukan langsung di database, atau menggunakan migration script, tidak dari aplikasi
 * - executeUpdate(sql) mengembalikan return int, dimana ini biasanya mengembalikan berapa banyak record di database
 *   yang terkena impact perintah SQL kita, misal ketika mengirim perintah UPDATE, berapa banyak record yang ter-update misalnya
 *
 * Statement.executeQuery(sql)
 *
 * - Jika kita ingin mengirim perintah SQL yang mengembalikan data, maka kita bisa menggunakan method executeQuery(sql)
 * - Method ini akan mengembalikan object java.sql.ResultSet, yaitu berisikan data-data hasil query SQL yang kita kirimkan
 * - Pembahasan interface ResultSet akan kita bahas lebih detail lagi nanti di chapter tersendiri
 */
public class StatementTest {

    @Test
    void testCreateStatement() throws SQLException  {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        statement.close();
        connection.close();
    }

    @Test
    void testExecuteUpdate() throws SQLException  {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                INSERT INTO customers(id, name, email)
                VALUES ('adnin', 'Adnin', 'adninsijawa@gmail.com')
                """.trim();

        int affectedRows = statement.executeUpdate(sql);
        System.out.println(affectedRows);

        statement.close();
        connection.close();
    }

    @Test
    void testExecuteDelete() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                DELETE FROM customers;
                """.trim();

        int affectedRows = statement.executeUpdate(sql);
        System.out.println(affectedRows);

        statement.close();
        connection.close();
    }

    @Test
    void testExecuteQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM customers";

        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println(resultSet);

        resultSet.close();
        statement.close();
        connection.close();
    }
}
