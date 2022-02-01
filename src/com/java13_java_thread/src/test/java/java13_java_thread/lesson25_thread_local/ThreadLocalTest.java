package java13_java_thread.lesson25_thread_local;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal
 *
 * - ThreadLocal merupakan fitur di Java untuk menyimpan data
 * - ThreadLocal memberi kita kemampuan untuk menyimpan data yang hanya bisa digunakan di thread tersebut
 * - Tiap thread akan memiliki data yang berbeda dan tidak saling terhubung antar thread
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/ThreadLocal.html
 */
public class ThreadLocalTest {

    @Test
    void threadLocal() throws InterruptedException {
        var random = new Random();
        var userService = new UserService();
        var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 50; i++) {
            final var index = i;
            executor.execute(() -> {
                try {
                    userService.setUser("User " + index);
                    Thread.sleep(1000 + random.nextInt(3000));
                    userService.doAction();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
