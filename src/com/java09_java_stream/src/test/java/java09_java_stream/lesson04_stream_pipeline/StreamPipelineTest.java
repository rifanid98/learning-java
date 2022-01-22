package java09_java_stream.lesson04_stream_pipeline;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Stream Pipeline
 *
 * - Saat kita membuat Stream, biasanya kita akan melakukan banyak operasi terhadap Stream tersebut
 * - Dan biasanya kita akan membuat Stream Pipeline
 * - Stream Pipeline terdiri dari sebuah sumber stream (bisa array, collection dan lain-lain), lalu diikuti dengan
 *   kosong atau lebih stream operations dan diakhiri dengan operasi akhir, misalnya forEach
 * - Saat menggunakan Stream, hampir kebanyakan kita pasti akan membuat sebuah Stream Pipeline
 */
public class StreamPipelineTest {

    @Test
    void testStreamPipeline() {
        List.of("Adnin", "Rifandi", "Sutanto").stream()
                .map(name -> name.toUpperCase())
                .map(upper -> "Mr. " + upper)
                .forEach(mr -> System.out.println(mr));
    }
}
