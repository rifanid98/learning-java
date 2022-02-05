package java16_logging.lesson07_mapped_diagnostic_context;

import org.junit.jupiter.api.Test;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * Mapped Diagnostic Context
 *
 * - Saat kita membuat aplikasi, biasanya aplikasi kita akan diakses oleh banyak sekali user, dan artinya mungkin bisa
 *   diakses oleh banyak thread
 * - MDC merupakan fitur seperti thread local, dimana kita bisa memberi informasi tambahkan kepada logger, tanpa harus
 *   kita kirim data tersebut secara manual ke class atau method
 * - Agar lebih dapat gambaran besarnya, kita akan coba sebuah kasus
 *
 * Contoh Aplikasi
 *
 * - Saat membuat aplikasi, kadang kita ingin melakukan log seperti request-id
 * - Dan di semua log, kita akan tambahkan request-id, agar tahu, log ini muncul dari request siapa
 * - Biasanya yang kita lakukan adalah, kita akan mengirim request-id dari class pertama sampai class terakhir, biasanya
 *   via parameter
 *
 * Tugas
 *
 * - Buat class Controller, Service dan Repository
 * - Controller akan memanggil Service, dan Service akan memanggil Repository
 * - Di tiap method tambahkan parameter requestId, dan di tiap method, log informasi requestId tersebut
 */
public class MappedDiagnosticContextTest {

    @Test
    void noMappedDiagnosticContext() {
        String requestId = UUID.randomUUID().toString();
        MyController controller = new MyController(new MyService(new MyRepository()));
        controller.save(requestId);
    }

    /**
     * Menggunakan Mapped Diagnostic Context
     *
     * - MDC mirip dengan Map, dimana kita bisa menambahkan data dengan key, dan juga menghapusnya
     * - Saat kita menggunakan MDC, secara otomatis data di MDC bisa kita akses di logger
     * - http://www.slf4j.org/apidocs/org/slf4j/MDC.html
     */
    @Test
    void withMappedDiagnosticContext() {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        MyController controller = new MyController(new MyService(new MyRepository()));
        controller.save(requestId);
    }

    /**
     * Multi Thread
     *
     * - Data MDC disimpan dalam ThreadLocal, artinya selama didalam thread yang sama, kita bisa mengakses data di MDC
     * - Oleh karena itu jika kita membuat aplikasi berbasis multithread, selama satu user mendapat satu thread, kita
     *   bisa menggunakan MDC
     * - Namun jika aplikasi kita sudah reactive, yang tidak jelas thread mana yang memproses method mana, kita tidak
     *   bisa menggunakan fitur MDC lagi
     */
    @Test
    void mappedDiagnosticContextWithMultiThread() throws InterruptedException {
        MyController controller = new MyController(new MyService(new MyRepository()));

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                String requestId = UUID.randomUUID().toString();
                MDC.put("requestId", requestId);

                controller.save(requestId);

                MDC.remove("requestId");
            }).start();
        }

        Thread.sleep(1000L);
    }
}
