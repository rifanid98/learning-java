package java10_java_database.lesson02_connection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection
 *
 * - Setelah melakukan registrasi Driver ke JDBC, kita sekarang bisa mulai melakukan koneksi ke database
 * - Untuk melakukan koneksi ke database, kita harus memberi tahu jenis database, host, port, username dan password
 *   untuk terkoneksi ke database
 * - Semua itu biasanya digabungkan dalam sebuah string yang biasa disebut JDBC URL
 * - Koneksi ke database direpresentasikan oleh interface java.sql.Connection
 * - https://docs.oracle.com/en/java/javase/15/docs/api/java.sql/java/sql/Connection.html
 *
 * MySQL JDBC URL
 *
 * - Tiap database biasanya punya format jdbc url sendiri-sendiri
 * - Contohnya di MySQL, kita bisa menggunakan format seperti ini :
 * - jdbc:mysql://host:port/namadatabase
 *
 * Membuat Connection
 *
 * - Untuk membuat Connection ke database, kita bisa menggunakan static method getConnection() di class java.sql.DriverManager
 * - Semua method di JDBC rata-rata selalu akan menghasilkan SQLException
 *
 * Menutup Connection
 *
 * - Saat kita selesai menggunakan Connection, disarankan untuk selalu menutup Connection tersebut.
 * - Jika sebuah Connection tidak kita tutup, maka selama aplikasi kita berjalan, koneksi ke datatabase akan selalu
 *   terbuka
 * - Jika Connection yang terbuka ke database terlalu banyak, ditakutkan nanti kita tidak bisa membuka koneksi lagi ke
 *   database dikarenakan sudah menyentuh nilai maksimam koneksi yang bisa di tangani oleh database nya
 * - Contohnya, maksimum Connection di MySQL adalah 151
 * - https://dev.mysql.com/doc/refman/8.0/en/server-system-variables.html#sysvar_max_connections
 */
public class ConnectionTest {

    @BeforeAll
    static void beforeAll() {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database?serverTimezone=Asia/Jakarta";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connected");
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testConnectionClose() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database?serverTimezone=Asia/Jakarta";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connected");
            connection.close();
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testConnectionAutoClose() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database?serverTimezone=Asia/Jakarta";
        String username = "root";
        String password = "root";

        // using try with resource
        try(Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Database connected");
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }
}
