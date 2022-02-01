package java13_java_thread.lesson24_concurrent_map;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ConcurrentMap
 *
 * - ConcurrentMap merupakan turunan dari Map yang thread safe, dan cocok jika memang diakses oleh lebih dari satu thread
 * - Tidak ada hal yang spesial dari ConcurrentMap, semua operasi method nya sama seperti Map, yang membedakan adalah
 *   pada ConcurrentMap, dijamin thread safe
 * - Implementasi dari interface ConcurrentMap adalah class ConcurrentHashMap
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ConcurrentMap.html
 */
public class ConcurrentMapTest {

    @Test
    void concurrentMap() throws InterruptedException {
        var countdown = new CountDownLatch(100);
        var map = new ConcurrentHashMap<Integer, String>();
        var executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            final var key = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    map.putIfAbsent(key, "Data : " + key);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countdown.countDown();
                }
            });
        }

        executor.execute(() -> {
            try {
                countdown.await();
                map.forEach((integer, s) -> System.out.println(integer + " : " + s));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    /**
     * Konversi dari Java Collection
     *
     * - Pada kasus tertentu, kadang kita tetap butuh menggunakan Java Collection, namun butuh menggunakan multiple
     *   thread
     * - Untuk kasus seperti itu, disarankan merubah Java Collection menjadi synchronized menggunakan helper method
     *   Collections.synchronized…(collection)
     */
    @Test
    void conversionFromJavaCollection() {
        List<String> list = List.of("Adnin", "Rifandi", "Sutanto");
        List<String> synchronizedList = Collections.synchronizedList(list);
    }
}
