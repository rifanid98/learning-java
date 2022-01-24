package java10_java_database.lesson01_driver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Driver
 *
 * - Driver adalah jembatan penghubung antara JDBC dan Database Management System yang akan kita gunakan
 * - Sebenarnya Driver itu berisikan class-class implementasi dari interface yang terdapat di JDBC
 * - Tanpa menggunakan Driver, kita JDBC tidak bisa terkoneksi ke DBMS
 * - Driver di JDBC direpresentasikan oleh interface java.sql.Driver
 * - https://docs.oracle.com/en/java/javase/15/docs/api/java.sql/java/sql/Driver.html
 *
 * MySQL Driver
 *
 * - MySQL sudah menyediakan driver untuk JDBC
 * - Kita bisa cari MySQL Driver dengan menggunakan kata kunci mysql-connector-java di https://search.maven.org/
 * - Lalu tambahkan ke dependency project kita
 *
 * Registrasi Driver ke JDBC
 *
 * - Setelah menambah dependency MySQL Driver ke project kita
 * - Kita perlu melakukan registrasi Driver terlebih dahulu
 * - Untuk melakukan registrasi driver, kita bisa menggunakan static method registerDriver milik class
 *   java.sql.DriverManager
 */
public class DriverTest {

    @Test
    void testDriver() {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }
}
