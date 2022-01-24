package java10_java_database.lesson07_prepared_statement;

import java10_java_database.lesson03_data_source.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PreparedStatement
 *
 * - PreparedStatement adalah turunan dari Statement, jadi apapun yang bisa dilakukan Statement, bisa dilakukan juga
 *   oleh PreparedStatement
 * - Yang membedakan PreparedStatement dari Statement adalah, PreparedStatement memiliki kemampuan untuk mengamankan
 *   input dari user sehingga aman dari serangan SQL Injection
 *
 * Membuat PreparedStatement
 *
 * - Berbeda dengan Statement, pada PreparedStatement, ketika pembuatannya, sudah ditentukan SQL apa yang akan kita gunakan
 * - Oleh karena itu, PreparedStatement biasanya digunakan untuk sekali mengirim perintah SQL, jika ingin mengirim
 *   perintah SQL lagi, kita harus membuat PreparedStatement baru
 * - Untuk membuat PreparedStatement, kita bisa menggunakan method prepareStatement(sql) milik Connection
 *
 * Menerima Input User
 *
 * - Sekarang pertanyaannya, bagaimana cara menerima input user menggunakan PreparedStatement?
 * - Untuk menerima input dari user, SQL yang kita buat harus diubah juga
 * - Input dari user, perlu kita ubah menjadi ? (tanda tanya)
 * - Nanti ketika pembuatan object, kita bisa subtitusi datanya menggunakan setXxx(index, value) sesuai dengan tipe
 *   datanya, misal setString(), setInt() dan lain-lain
 */
public class PreparedStatementTest {

    @Test
    void testPreparedStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        String name = "Adnin";
        String sql = "SELECT * FROM customers WHERE name = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("Sukses login");
        } else {
            System.out.println("Gagal login");
        }

        preparedStatement.close();
        connection.close();
    }
}
