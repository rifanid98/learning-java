package java13_java_thread.lesson06_timer;

import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer
 *
 * - Timer merupakan class untuk memfasilitasi eksekusi job secara asynchronous di masa depan
 * - Timer bisa di schedule untuk berjalan satu kali (delayed job), atau bisa berjalan berulang kali (repeated job)
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/Timer.html
 */
public class TimerTest {

    @Test
    void delayedJob() throws InterruptedException {
        var task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Delayed Job");
            }
        };

        var timer = new Timer();
        timer.schedule(task, 1000);
        Thread.sleep(2000);
    }

    @Test
    void periodicJob() throws InterruptedException {
        var task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Periodic Job");
            }
        };

        var timer = new Timer();
        timer.schedule(task, 1000, 1000);
        Thread.sleep(5000);
    }
}
