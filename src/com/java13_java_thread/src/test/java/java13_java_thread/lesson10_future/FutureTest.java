package java13_java_thread.lesson10_future;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Callable<T>
 *
 * - Sebelumnya kita selalu menggunakan Runnable untuk mengirim perintah ke thread, namun pada Runnable, setelah
 *   pekerjaan selesai, tidak ada data yang dikembalikan sama sekali, karena method nya return void
 * - Callable mirip dengan Runnable, namun Callable mengembalikan data
 * - Selain itu Callable merupakan generic type, sehingga kita bisa tentukan tipe return data nya
 *
 * Future<T>
 *
 * - Jika kita ingin mengeksekusi callable, kita bisa menggunakan method submit(Callable) pada ExecutorService, method
 *   submit(Callable) tersebut akan mengembalikan Future<T>
 * - Future merupakan representasi data yang akan dikembalikan oleh proses asynchronous
 * - Menggunakan Future, kita bisa mengecek apakah pekerjaan Callable sudah selesai atau belum, dan juga mendapat data
 *   hasil dari Callable
 */
public class FutureTest {

    @Test
    void createFuture() throws InterruptedException, ExecutionException {
        var executor = Executors.newSingleThreadExecutor();
        var future = executor.submit(() -> {
            Thread.sleep(5000);
            return "Hi";
        });

        while (!future.isDone()) {
            System.out.println("Waiting Result");
            Thread.sleep(1000);
        }

        System.out.println(future.get());
    }

    @Test
    void cancelFuture() throws ExecutionException, InterruptedException {
        var executor = Executors.newSingleThreadExecutor();
        var future = executor.submit(() -> {
            Thread.sleep(5000);
            return "Hi";
        });
        Thread.sleep(2000);
        future.cancel(true);
        System.out.println(future.get());
    }

    /**
     * Invoke All
     *
     * - ExecutorService memiliki method bernama  invokeAll(Collection<Callable<T>>) untuk mengeksekusi banyak Callable
     *   secara sekaligus
     * - Ini cocok ketika ada kasus kita ingin menjalankan proses asynchronous secara parallel sebanyak jumlah thread di
     *   threadpool
     * - Hal ini bisa mempercepat proses dibanding kita eksekusi satu persatu
     */
    @Test
    void invokeAll() throws InterruptedException, ExecutionException {
        var executor = Executors.newFixedThreadPool(10);
        List<Callable<String>> callables = IntStream.range(1, 11).mapToObj(operand -> (Callable<String>) () -> {
            Thread.sleep(operand * 500L);
            return String.valueOf(operand);
        }).collect(Collectors.toList());

        List<Future<String>> futures = executor.invokeAll(callables);
        for (Future<String> stringFuture : futures) {
            System.out.println(stringFuture.get());
        }
    }

    /**
     * Invoke Any
     *
     * - Kadang ada kasus dimana kita ingin mengeksekusi beberapa proses secara asynchronous, namun ingin mendapatkan
     *   hasil yang paling cepat
     * - Hal ini bisa dilakukan dengan menggunakan method invokeAny(Collection<Callable<T>>)
     * - invokeAny() akan mengembalikan result data dari Callable yang paling cepat mengembalikan result
     */
    @Test
    void invokeAny() throws ExecutionException, InterruptedException {
        var executor = Executors.newFixedThreadPool(10);
        List<Callable<String>> callables = IntStream.range(1, 11).mapToObj(operand -> (Callable<String>) () -> {
            Thread.sleep(operand * 500L);
            return String.valueOf(operand);
        }).collect(Collectors.toList());

        var value = executor.invokeAny(callables);
        System.out.println(value);
    }
}
