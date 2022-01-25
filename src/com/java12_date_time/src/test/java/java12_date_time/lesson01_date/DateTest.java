package java12_date_time.lesson01_date;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * Date
 *
 * - Sebelum membahas Date dan Time API yang baru, kita akan sekilas membahas class Date
 * - Date adalah representasi tanggal dan juga waktu di Java sejak versi awal
 * - Karena tidak ada pemisahan antara tanggal dan waktu di class Date, ini memang agak menyulitkan jika kita hanya
 *   butuh misal tanggal saja, dan waktu saja
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/Date.html
 *
 * Milisecond
 *
 * - Date menggunakan milisecond setelah UNIX epoch (January 1, 1970 00:00:00 UTC)
 * - Untuk mendapatkan milisecond saat ini, di Java kita bisa menggunakan System.currentTimeMilis()
 * - https://currentmillis.com/
 */
public class DateTest {

    @Test
    void create() {
        var date1 = new Date();
        var date2 = new Date(System.currentTimeMillis());
        var date3 = new Date(1643081710);

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
    }
}
