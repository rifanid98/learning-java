package java18_spring_dasar.lesson03_singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Singleton
 * <p>
 * - Singleton adalah salah satu Design Patterns untuk pembuatan objek, dimana sebuah object hanya dibuat satu kali saja
 * - Dan ketika kita membutuhkan object tersebut, kita hanya akan menggunakan object yang sama
 * - https://refactoring.guru/design-patterns/singleton
 * <p>
 * Membuat Singleton di Java
 * <p>
 * - Ada banyak cara membuat singleton object di Java
 * - Cara yang paling sering digunakan adalah membuat class yang berisikan static method untuk membuat object dirinya
 * sendiri
 * - Selanjutnya constructor nya dibuat private, agar tidak bisa diakses dari luar
 * - Sehingga user terpaksa menggunakan method static tersebut ketika ingin membuat object nya
 */
public class SingletonTest {

    @Test
    void singleton() {
        Database database1 = Database.getInstance();
        Database database2 = Database.getInstance();

        Assertions.assertSame(database1, database2);
    }
}
