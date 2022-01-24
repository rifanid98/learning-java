package java10_java_database.lesson08_batch_proses;

import java10_java_database.lesson03_data_source.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Request dan Response
 *
 * - Secara default, komunikasi antara database dan aplikasi Java kita adalah request dan response
 * - Artinya, setiap kali kita mengirim perintah SQL, maka aplikasi kita akan menunggu sampai database melakukan response
 *   dari perintah SQL tersebut
 * - Proses tersebut kadang terlalu chatty kalo tujuan kita misal ingin mengirim data secara banyak ke database
 *
 * Batch Proses
 *
 * - Batch process adalah proses mengirim perintah secara banyak sekaligus.
 * - Biasanya batch process dilakukan dalam kasus tertentu saja, misal ketika kita ingin mengirim import data dari file
 *   excel ke database yang jumlahnya jutaan.
 * - Biasanya dalam batch process, yang diutamakan adalah kecepatan, karena jika perintah SQL nya di execute satu satu
 *   dan menunggu response satu satu, maka sudah pasti akan sangat lambat sekali
 *
 * Batch Proses di JDBC
 *
 * - JDBC mendukung proses eksekusi perintah SQL secara batch di Statement ataupun di PreparedStatement
 * - Di Statement, terdapat method addBatch(sql) untuk menambahkan perintah ke proses batch
 * - Sedangkan di PreparedStatement terdapat method addBatch() untuk menambahkan proses ke batch, lalu bisa gunakan
 *   method clearParameters() untuk menghapus parameter input user sebelumnya.
 * - Setelah proses batch selesai, untuk mengeksekusinya, kita bisa gunakan perintah executeBatch()
 *
 * Peringatan!
 *
 * - Proses batch akan disimpan di memory sebelum dikirim ke database
 * - Oleh karena itu, bijaklah membuat proses batch, jangan terlalu banyak menambahkan ke batch, misal per 100 atau per
 *   1000
 * - Jika sudah mencapai 100 atau 1000, kita bisa mengirim batch tersebut menggunakan perintah executeBatch()
 */
public class BatchProsesTest {

    @Test
    void testBatchProses() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        String sql = "INSERT INTO customers(id, name, email) VALUES(?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < 1; i++) {
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "rifandi");
            preparedStatement.setString(2, "Rifandi");
            preparedStatement.setString(3, "rifandi@email.com");
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();

        preparedStatement.close();
        connection.close();
    }
}
