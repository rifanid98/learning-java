package java12_date_time.lesson15_temporal;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Temporal
 *
 * - Di dalam package java.time, sebenarnya ada package java.time.temporal
 * - Di dalam package java.time.temporal terdapat banyak sekali interface yang merupakan kontrak dari Java Date & Time API
 * - Hampir semua tipe data tanggal dan waktu di Java Date & Time adalah implementasi dari interface Temporal
 * - Maka dari itu, jika diperhatikan, hampir semua tipe data nya memiliki method-method yang hampir sama
 */
public class TemporalTest {

    @Test
    void testTemporal() {
        Temporal temporal1 = LocalTime.now();
        Temporal temporal2 = LocalDate.now();
        Temporal temporal3 = LocalDateTime.now();
        Temporal temporal4 = ZonedDateTime.now();
        Temporal temporal5 = Year.now();
        Temporal temporal6 = YearMonth.now();
        Temporal temporal7 = Instant.now();

        System.out.println(temporal1);
        System.out.println(temporal2);
        System.out.println(temporal3);
        System.out.println(temporal4);
        System.out.println(temporal5);
        System.out.println(temporal6);
        System.out.println(temporal7);
    }

    /**
     * TemporalAmount
     *
     * - Duration dan Period adalah implementasi dari interface TemporalAmount
     * - Salah satu method yang menggunakan TemporalAmount di Temporal adalah plus() da minus()
     * - Artinya, dengan ini kita bisa meggunakan object TemporalAmount untuk melakukan penambahan/pengurangan tanggal
     *   dan waktu
     */
    @Test
    void testTemporalAmount() {
        Temporal temporal1 = LocalDateTime.now();
        Temporal temporal2 = temporal1.plus(Duration.ofHours(10));
        Temporal temporal3 = temporal1.plus(Period.ofDays(10));

        System.out.println(temporal1);
        System.out.println(temporal2);
        System.out.println(temporal3);
    }

    /**
     * TemporalUnit
     *
     * - TemporalUnit adalah implementasi dari unit satuan waktu
     * - Implementasi TemporalUnit adalah sebuah enum ChronoUnit
     * - TemporalUnit selain sebagai informasi satuan waktu, bisa juga digunakan untun menghitung durasi waktu
     */
    @Test
    void testTemporalUnit() {
        long temporalUnit1 = ChronoUnit.SECONDS.between(LocalTime.now(), LocalTime.now().plusHours(10));
        long temporalUnit2 = ChronoUnit.MINUTES.between(LocalTime.now(), LocalTime.now().plusHours(10));
        long temporalUnit3 = ChronoUnit.DAYS.between(LocalTime.now(), LocalTime.now().plusHours(10));

        System.out.println(temporalUnit1);
        System.out.println(temporalUnit2);
        System.out.println(temporalUnit3);
    }

    /**
     * TempralField
     *
     * - TemporalField adalah informasi field yang terdapat dalam sebuah tipe data
     * - Semua object Temporal memiliki method bernama get(TemporalField) atau getLong(TemporalField) untuk mendapatkan
     *   info seputar field pada object tersebut, sesuai dengan Field yang kita inginkan
     * - Implementasi TemporalField adalah enum bernama ChronoField
     */
    @Test
    void testTemporalField() {
        Temporal temporal = LocalDateTime.now();
        System.out.println(temporal.get(ChronoField.YEAR));
        System.out.println(temporal.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(temporal.get(ChronoField.DAY_OF_MONTH));
        System.out.println(temporal.get(ChronoField.HOUR_OF_DAY));
        System.out.println(temporal.get(ChronoField.MINUTE_OF_HOUR));
        System.out.println(temporal.get(ChronoField.SECOND_OF_MINUTE));
        System.out.println(temporal.get(ChronoField.MILLI_OF_SECOND));
        System.out.println(temporal.get(ChronoField.NANO_OF_SECOND));
    }

    /**
     * TemporalQuery
     *
     * - TemporalQuery merupakan lambda interface yang bisa kita gunakan untuk mengambil informasi dari data
     *   TemporalAccessor
     * - TemporalQuery adalah generic type, jadi kita bisa mengembalikan tipe data apapun pada hasil query yang kita
     *   lakukan di TemporalAccessor
     */
    @Test
    void testTemporalQuery() {
        LocalDateTime localDateTime = LocalDateTime.now();

        List<Integer> integers = localDateTime.query(temporal -> {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(temporal.get(ChronoField.YEAR));
            list.add(temporal.get(ChronoField.MONTH_OF_YEAR));
            list.add(temporal.get(ChronoField.DAY_OF_MONTH));
            return list;
        });

        System.out.println(integers);
    }

    /**
     * TemporalAdjuster
     *
     * - TemporalAdjuster adalah strategi untuk menyesuaikan objek temporal.
     * - Kita bisa melakukan implementasi penyesuaian object sendiri, atau kita juga bisa menggunakan helper class
     *   bernama TemporalAdjusters
     * - Terdapat banyak static method di TemporalAdjusters yang bisa kita gunakan untuk mempermudah melakukan
     *   penyesuaian objek temporal
     */
    @Test
    void testTemporalAdjuster() {
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = localDate1.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate localDate3 = localDate1.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate localDate4 = localDate1.with(TemporalAdjusters.firstDayOfYear());
        LocalDate localDate5 = localDate1.with(TemporalAdjusters.lastDayOfYear());

        System.out.println(localDate1);
        System.out.println(localDate2);
        System.out.println(localDate3);
        System.out.println(localDate4);
        System.out.println(localDate5);
    }
}
