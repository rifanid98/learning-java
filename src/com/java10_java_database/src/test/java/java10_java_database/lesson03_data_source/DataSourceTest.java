package java10_java_database.lesson03_data_source;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Masalah Dengan Connection
 *
 * - Connection adalah sebuah resource yang sangat mahal
 * - Jika aplikasi kita sangat ketergantungan dengan database, maka membuka tutup koneksi setiap ada request sangatlah
 *   mahal harganya
 * - Connection itu sangat lambat ketika pertama kali dibuat, dan sangat mahal memakan memory
 * - Oleh karena itu, melakukan manajemen Connection secara manual sangatlah tidak direkomendasikan saat nanti kita
 *   membuat aplikasi
 *
 * Connection Pool
 *
 * - Connection Pool adalah konsep dimana dibanding kita membuat koneksi baru setiap ada request ke yang membutuhkan
 *   database
 * - Lebih baik diawal kita buatkan banyak Connection terlebih dahulu, sehingga hanya lambat diawal ketika aplikasi
 *   berjalan
 * - Selanjutnya ketika ada request yang butuh koneksi, kita hanya cukup menggunakan salah satu Connection, dan setelah
 *   selesai, kita kembalikan lagi Connection nya
 * - Jika semua Connection sedang terpakai semua, ketika ada request yang butuh koneksi lagi, request tersebut diminta
 *   untuk menunggu terlebih dahulu, dengan demikian penggunaan memory untuk Connection tidak akan terlalu bengkak
 * - Connection Pool di JDBC direpresentasikan dengan interface javax.sql.DataSource
 *
 * HikariCP
 *
 * - Membuat connection pool secara manual bukanlah hal bijak, lebih baik kita menggunakan library connection pool yang
 *   sudah terbukti bekerja dengan baik.
 * - HikariCP adalah salah satu connection pool library yang paling populer saat ini di Java
 * - Kita bisa menggunakan HikariCP ini untuk melakukan connection pool terhadap koneksi database di aplikasi kita
 * - https://github.com/brettwooldridge/HikariCP
 */
public class DataSourceTest {

    @Test
    void testHikariCP() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_java_database?serverTimezone=Asia/Jakarta");
        config.setUsername("root");
        config.setPassword("root");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(10 * 60_000);

        try {
            HikariDataSource dataSource = new HikariDataSource(config);
            Connection connection = dataSource.getConnection();
            connection.close();
            dataSource.close();
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }
}
