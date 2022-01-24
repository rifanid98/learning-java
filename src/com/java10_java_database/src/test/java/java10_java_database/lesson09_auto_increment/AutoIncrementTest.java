package java10_java_database.lesson09_auto_increment;

import java10_java_database.lesson03_data_source.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * AutoIncrement
 *
 * - Kadang setelah melakukan INSERT data ke database yang memiliki primary key auto increment, kita ingin mendapatkan
 *   data id terbarunya
 * - Di MySQL sebenarnya kita bisa melakukan query SELECT LAST_INSERT_ID(), namun berarti kita harus melakukan query
 *   ulang dengan Statement dan melakukan iterasi lagi dengan ResultSet
 * - Untungnya di JDBC, ada kemampuan untuk mendapatkan auto generate data seperti auto increment dengan method
 *   getGenerateKeys() yang mengembalikan ResultSet
 * - Selanjutnya kita bisa melakukan iterasi terhadap ResultSet tersebut
 *
 * Mendapatkan Auto Generated Key
 *
 * - Secara default, Statement ataupun PreparedStatement tidak mengerti untuk mengambil auto generate key
 * - Kita perlu memberi tahunya agar Statement ataupun PreparedStatement mengambil auto generate id secara otomatis
 * - Untuk Statement, kita perlu memberi tahu ketika memanggil method executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)
 * - Sedangkan untuk PreparedStatement, kita perlu memberi tahu ketika membuat prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
 * - Setelah itu, untuk mendapatkan auto generate key, kita bisa menggunakan method getGeneratedKeys(), method ini akan
 *   error jika kita lupa mengirim parameter generated keys
 */
public class AutoIncrementTest {

    @Test
    void testAutoIncrement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO comments(email, comment) VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, "user@email.com");
        preparedStatement.setString(2, "comment");

        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
            System.out.println("Last inserted Id :  " + resultSet.getInt(1));
        }
        preparedStatement.close();
        connection.close();
    }
}
