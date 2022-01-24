package java10_java_database.lesson10_date_time_timestamp;

import java10_java_database.lesson03_data_source.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * Date, Time dan Timestamp
 *
 * - Seperti kita ketahui, tipe tanggal dan waktu di database biasanya banyak, ada Date, Time ada juga Timestamp
 * - Sedangkan di Java hanya terdapat tipe data java.util.Date
 * - Agar bisa menghandle hal ini, terdapat class-class turunan java.util.Date di package java.sql yang bernama Date,
 *   Time dan Timestamp
 * - Sesuai dengan namanya, class-class tersebut digunakan sebagai representasi di Java
 * - Secara otomatis JDBC bisa melakukan konversi tipe data tersebut dari database menjadi object di Java
 */
public class DateTimeTimestampTest {

    @Test
    void testDate() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO sample_time(sample_time, sample_date, sample_timestamp) VALUES(?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setTime(1, new Time(System.currentTimeMillis()));
        preparedStatement.setDate(2, new Date(System.currentTimeMillis()));
        preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

    }

    @Test
    void testDateQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "SELECT * FROM sample_time";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Time time = resultSet.getTime("sample_time");
            Date date = resultSet.getDate("sample_date");
            Timestamp timestamp = resultSet.getTimestamp("sample_timestamp");

            System.out.println(time);
            System.out.println(date);
            System.out.println(timestamp);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
