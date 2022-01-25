package java12_date_time.lesson14_period;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

/**
 * Period
 *
 * - Class Period mirip dengan Duration, yang membedakan adalah Period adalah durasi untuk tanggal
 * - Cara penggunaan Period hampir mirip dengan Duration
 */
public class PeriodTest {

    @Test
    void testPeriod() {
        Period period1 = Period.ofDays(10);
        Period period2 = Period.ofWeeks(10);
        Period period3 = Period.ofMonths(10);
        Period period4 = Period.ofYears(10);
        Period period5 = Period.of(10, 10, 10);

        System.out.println(period1);
        System.out.println(period2);
        System.out.println(period3);
        System.out.println(period4);
        System.out.println(period5);
    }

    @Test
    void testPeriodeGet() {
        Period period = Period.of(10, 10, 10);

        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

    @Test
    void testPeriodCalculate() {
        Period period = Period.between(
                LocalDate.of(2020, 10, 10),
                LocalDate.of(2020, 12, 12)
        );

        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }
}
