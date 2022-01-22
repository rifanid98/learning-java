package java09_java_stream.lesson02_stream_builder;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * Stream Builder
 * <p>
 * - Kadang kita ingin membuat Stream secara manual, seperti menambah datanya ke Stream secara manual misalnya
 * - Java menyediakan Stream Builder untuk membuat Stream secara manual, dan kita bisa menggunakannya seperti Collection, kita bisa membuat Stream Builder, menambahkan data ke Stream Builder, setelah selesai, baru kita buat Stream nya
 * - https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/stream/Stream.Builder.html
 */
public class StreamBuilderTest {

    @Test
    void testCreateStreamBuilder() {
        Stream.Builder<String> streamBuilder = Stream.builder();
        streamBuilder.accept("Adnin");
        streamBuilder.add("Rifandi").add("Sutanto");

        Stream<String> stringStream = streamBuilder.build();
        stringStream.forEach(System.out::println);
    }

    @Test
    void testCreateStreamBuilderSimple() {
        Stream<Object> stream = Stream.builder().add("Adnin").add("Rifandi").add("Sutanto").build();
        stream.forEach(System.out::println);
    }
}
