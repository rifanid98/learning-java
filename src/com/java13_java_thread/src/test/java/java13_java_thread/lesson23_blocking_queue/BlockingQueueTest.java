package java13_java_thread.lesson23_blocking_queue;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.concurrent.*;

/**
 * Blocking Queue
 *
 * - BlockingQueue merupakan turunan dari Queue, dari namanya kita tahu bahwa ini adalah collection dengan tipe antrian,
 *   yang membedakan sifat dari BlockingQueue adalah dia aman diakses oleh beberapa thread, baik itu yang memasukkan data, atau mengambil data
 * - BlockingQueue mendukung method wait ketika mengambil data, dan juga wait ketika menyimpan data
 * - Jika queue kosong, thread yang mengambil data akan diminta untuk menunggu sampai data ada
 * - Dan jika queue penuh, thread yang mengambil data akan diminta untuk menunggu sampai ada tempat kosong
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/BlockingQueue.html
 *
 * Implementasi Blocking Queue
 *
 * - ArrayBlockingQueue, implementasi BlockingQueue dengan ukuran fix
 * - LinkedBlockingQueue, implementasi BlockingQueue dengan ukuran bisa berkembang
 * - PriorityBlockingQueue, implementasi BlockingQueue dengan otomatis berurut berdasarkan prioritas
 * - DelayQueue, implementasi BlockingQueue untuk tipe data Delayed, dimana data tidak bisa diambil sebelum waktu delay
 *   yang telah ditentukan
 * - SynchronousQueue, implementasi BlockingQueue dimana thread yang menambah data harus menunggu sampai ada thread yang
 *   mengambil data, begitu juga kebalikannya
 */
public class BlockingQueueTest {

    @Test
    void arrayBlockingQueue() throws InterruptedException {
        var queue = new ArrayBlockingQueue<String>(5);
        var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    queue.put("Data");
                    System.out.println("Success put data");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    String data = queue.take();
                    System.out.println("Receive : " + data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void linkedBlockingQueue() throws InterruptedException {
        var queue = new LinkedBlockingDeque<String>();
        var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    queue.put("Data");
                    System.out.println("Success put data");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    String data = queue.take();
                    System.out.println("Receive : " + data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void priorityBlockingQueue() throws InterruptedException {
        var queue = new PriorityBlockingQueue<Integer>(5, Comparator.reverseOrder());
        var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            final var index = i;
            executor.execute(() -> {
                queue.put(index);
                System.out.println("Success put data : " + index);
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    Integer data = queue.take();
                    System.out.println("Receive : " + data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void delayBlockingQueue() throws InterruptedException {
        var queue = new DelayQueue<ScheduledFuture<String>>();
        var executor = Executors.newScheduledThreadPool(10);

        for (int i = 0; i < 10; i++) {
            queue.put(executor.schedule(() -> "Delayed ", i, TimeUnit.SECONDS));
        }

        executor.execute(() -> {
            while (true) {
                try {
                    var data = queue.take();
                    System.out.println("Receive : " + data.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void synchronousBlockingQueue() throws InterruptedException {
        var queue = new SynchronousQueue<String>();
        var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    queue.put("Data");
                    System.out.println("Success put data");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var data = queue.take();
                    System.out.println("Receive : " + data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    /**
     * BlockingDeque
     *
     * - BlockingDeque merupakan turunan dari BlockingQueue
     * - BlockingDeque tidak hanya mendukung FIFO (first in first out), tapi juga LIFO (last in last out)
     * - Implementasi BlockingDeque hanyalan LinkedBlockingDeque
     * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/BlockingDeque.html
     */
    @Test
    void blockingDeque() throws InterruptedException {
        var queue = new LinkedBlockingDeque<String>();
        var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            try {
                queue.putLast("Data : " + i);
                System.out.println("Success put data " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var data = queue.takeFirst();
                    System.out.println("Receive : " + data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    /**
     * Transfe Queue
     *
     * - TransferQueue Merupakan turunan dari BlockingQueue yang membolehkan pengirim data ke queue menunggu sampai data
     *   ada yang menerima
     * - Implementasi TransferQueue hanyalah LinkedTransferQueue
     * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/TransferQueue.html
     */
    @Test
    void transferQueue() throws InterruptedException {
        var queue = new LinkedTransferQueue<String>();
        var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final var index = i;
            executor.execute(() -> {
                try {
                    queue.transfer("Data : " + index);
                    System.out.println("Success put data " + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var data = queue.take();
                    System.out.println("Receive : " + data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
