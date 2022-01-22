package java09_java_stream.lesson14_collectors;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Collect Operation
 *
 * - Stream memiliki sebuah operator bernama collect(Collector), function ini biasanya digunakan untuk meng-collect
 *   data Stream dan kita ubah menjadi struktur data yang kita inginkan, biasanya kebanyakan developer menggunakan
 *   operator collect() untuk mengubah Stream menjadi Collection
 * - Operator collect() membutuhkan parameter Collector, namun biasanya kita jarang sekali membuat implementasi
 *   interface Collector, karena terlalu kompleks
 * - https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/stream/Collector.html
 * - Untungnya Java Stream sudah menyediakan sebuah class helper untuk membuat Collector, bernama Collectors
 *
 * Collectors
 *
 * - Collectors adalah class helper yang bisa digunakan untuk membuat Collector
 * - Ini mempermudah kita ketika ingin melakukan operasi collect terhadap sebuah Stream
 * - Ada banyak sekali static method yang terdapat di class Collectors, dan nanti kita akan coba bahas beberapa method
 *   yang sering digunakan
 * - https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/stream/Collectors.html
 *
 * Membuat map dengan Collectors
 *
 * - Selain Collection, Collectors juga bisa digunakan untuk membuat Map dari String
 * - Yang membedakan dengan List atau Set, kita harus tentukan function untuk membentuk Key dan Value nya jika ingin
 *   membuat Map
 * - Ada banyak function yang bisa kita gunakan, seperti Collectors.toMap(...), Collectors.toConcurrentMap(...) dan
 *   Collectors.toUnmodifiableMap(...)
 */
public class CollectorsTest {

    Stream<String> getStream() {
        return Stream.of("Adnin", "Rifandi", "Sutanto");
    }

    @Test
    void testCollection() {
        Set<String> set = getStream().collect(Collectors.toSet());
        Set<String> immutableSet = getStream().collect(Collectors.toUnmodifiableSet());

        System.out.println(set);
        System.out.println(immutableSet);

        List<String> list = getStream().collect(Collectors.toList());
        List<String> immutableList = getStream().collect(Collectors.toUnmodifiableList());

        System.out.println(list);
        System.out.println(immutableList);
    }

    @Test
    void testMap() {
        Map<String, Integer> map = getStream().collect(Collectors.toMap(
                name-> name,
                name -> name.length()
        ));
        System.out.println(map);
    }
}
