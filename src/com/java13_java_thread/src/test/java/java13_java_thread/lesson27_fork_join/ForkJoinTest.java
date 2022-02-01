package java13_java_thread.lesson27_fork_join;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Fork/Join
 * <p>
 * - Fork/Join merupakan fitur yang mulai kenalkan di Java 7 untuk membantu mempercepat proses secara parallel
 * memanfaatkan semua cpu processor. Proses ini dicapai menggunakan teknik Devide and Conquer
 * - Secara sederhana, Fork/Join akan melakukan FORK, memecah pekerjaan menjadi pekerjaan yang lebih kecil dan dieksekusi
 * secara asynchronous
 * - Setelah proses FORK selesai, proses JOIN akan dilakukan, yaitu menggabungkan hasil semua pekerjaan yang telah
 * selesai menjadi satu hasil
 * - Fork/Join menggunakan thread pool bernama ForkJoinPool dan menggunakan thread ForkJoinWorkerThread
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ForkJoinPool.html
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ForkJoinWorkerThread.html
 * <p>
 * Work Stealing Algorithm
 * <p>
 * - Fork/Join Thread menggunakan algoritma work stealing (mencuri), artinya jika Fork/Join akan secara maksimal
 * menjalankan pekerjaan di semua thread, dan jika ada thread yang sudah selesai, maka thread tersebut akan coba
 * mencuri pekerjaan dari queue thread lain
 * - Algoritma ini memastikan bahwa semua thread akan bekerja dan pekerjaan diselesaikan secepatnya
 */
public class ForkJoinTest {

    @Test
    void forkJoinPool() {
        ForkJoinPool pool1 = ForkJoinPool.commonPool(); // using all cpu core
        ForkJoinPool pool2 = new ForkJoinPool(5);

        ExecutorService executor1 = Executors.newWorkStealingPool();
        ExecutorService executor2 = Executors.newWorkStealingPool(5); // using all cpu core
    }

    /**
     * ForkJoinTask
     * <p>
     * - ForkJoinPool merupakan turunan dari ExecutorService, jadi cara penggunaannya sama dengan ExecutorService
     * sebelumnya yang sudah kita bahas
     * - Namun agar tujuan dari ForkJoinPool tercapai, baiknya kita menggunakan ForkJoinTask sebagai task yang kita
     * submit ke ForkJoinPool
     * - ForkJoinTask adalah turunan dari Callable, sehingga kita bisa menggunakan method execute() atau submit() untuk
     * mengirim task ke ForkJoinPool
     * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ForkJoinTask.html
     * <p>
     * RecursiveAction dan RecursiveTask
     * <p>
     * - ForkJoinTask adalah abstract class, dan terdapat 2 abstract class turunannya yang bisa kita gunakan agar lebih
     * mudah membuat ForkJoinTask
     * - RecursiveAction, merupakan class yang bisa kita gunakan untuk task yang tidak mengembalikan result seperti Runnable
     * - RecursiveTask, merupakan class yang bisa kita gunakan untuk task yang mengembalikan result seperti Callable
     * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/RecursiveAction.html
     * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/RecursiveTask.html
     */
    @Test
    void recursiveAction() throws InterruptedException {
        var pool = ForkJoinPool.commonPool();
        List<Integer> integers = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

        pool.execute(new SimpleForkJoinTask(integers));
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void recursiveTask() throws InterruptedException {
        var pool = ForkJoinPool.commonPool();
        List<Integer> integers = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

        TotalForkJoinTask task = new TotalForkJoinTask(integers);
        pool.submit(task);
        Long total = task.join();
        System.out.println(total);
    }
}
