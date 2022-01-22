package java09_java_stream.lesson15_grouping_by;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Grouping By
 * <p>
 * - Collectors juga bisa digunakan untuk melakukan grouping by sebuah Stream
 * - Hasil dari grouping by adalah Map<Group, List<Value>>
 * <p>
 * Partitioning By
 * <p>
 * - Selain grouping by, Collectors juga bisa digunakan untuk partitioning by
 * - Hanya saja hasil dari partitioning by hanyalah 2 buah group boolean (true, false)
 */
public class GroupingByTest {

    @Test
    void testGroupingBy() {
        Map<String, List<Integer>> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(Collectors.groupingBy(number -> {
                    if (number > 5) {
                        return "Besar";
                    } else {
                        return "Kecil";
                    }
                }));

        System.out.println(collect);
    }

    @Test
    void testPartitioningBy() {
        Map<Boolean, List<Integer>> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(Collectors.partitioningBy(number -> number > 5));

        System.out.println(collect);
    }
}
