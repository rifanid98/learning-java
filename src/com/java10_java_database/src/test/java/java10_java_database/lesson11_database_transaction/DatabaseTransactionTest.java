package java10_java_database.lesson11_database_transaction;

import java10_java_database.lesson03_data_source.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Database Transaction
 *
 * - Fitur paling bermanfaat di database salah satu nya adalah database transaction
 * - Fitur database transaction pun bisa kita jalankan menggunakan JDBC
 * - Jika belum mengerti apa itu database transaction, silahkan tonton course saya tentang database MySQL, disana saya
 *   jelaskan secara terperinci
 *
 * Auto Commit
 *
 * - Secara default, Connection yang kita buat menggunakan JDBC memiliki sifat auto commit
 * - Auto commit artinya setiap perintah SQL yang kita kirim akan langsung di commit secara otomatis
 * - Karena dalam database transaction, kita biasanya melakukan commit transaction setelah semua proses selesai, maka
 *   kita perlu mematikan auto commit di JDBC
 * - Untuk mematikan fitur auto commit di JDBC, kita bisa menggunakan method di Connection bernama setAutoCommit(false)
 * - Setelah selesai melakukan proses , kita bisa melakukan commit transaction dengan menggunakan method commit() milik
 *   Connection
 * - Untuk membatalkan proses transaksi (rollback), kita bisa menggunakan method rollback() milik Connection
 */
public class DatabaseTransactionTest {

    @Test
    void testTransaction() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        connection.setAutoCommit(false);

        String sql = "INSERT INTO comments(email, comment) VALUES(?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "email@email.com");
        preparedStatement.setString(2, "comment");
        preparedStatement.executeUpdate();

        connection.commit();
        // connection.rollback(); // rollback
        preparedStatement.close();
        connection.close();
    }
}
