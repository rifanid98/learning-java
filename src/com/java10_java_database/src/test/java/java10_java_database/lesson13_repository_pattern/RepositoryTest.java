package java10_java_database.lesson13_repository_pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository Pattern
 *
 * - Dalam buku Domain-Driven Design, Eric Evans menjelaskan bahwa “repository is a mechanism for encapsulating storage,
 *   retrieval, and search behavior, which emulates a collection of objects”
 * - Pattern Repository ini biasanya digunakan sebagai jembatan antar business logic aplikasi kita dengan semua perintah
 *   SQL ke database
 * - Jadi semua perintah SQL akan ditulis di Repository, sedangkan business logic kode program kita hanya cukup
 *   menggunakan Repository tersebut
 *
 * Repository vs DAO (Data Access Object)
 *
 * - Jika teman-teman cari tutorial tentang Java Database, banyak juga yang menggunakan Data Access Object
 * - Secara garis besar, konsep Repository dan DAO hampir sama, yang membedakan Repository tidak menganggap bahwa storage
 *   itu hanya database, sedangkan biasanya kalo di DAO storage nya berupa database
 * - Jadi untuk kasus database, sebenarnya DAO lebih cocok, namun karena sekarang lebih populer nama Repository Pattern,
 *   jadi sekarang kita akan gunakan Repository Pattern
 * - Jika berdebat dengan programmer lain, tentang Repository dan DAO, sebenarnya gak terlalu berguna, karena tujuan dua
 *   pattern itu sama, mengenkapsulasi cara mengakses data
 *
 * Entity / Model
 *
 * - Dalam pemrograman berorientasi object, biasanya sebuah tabel di database akan selalu dibuat representasinya sebagai
 *   class Entity atau Model
 * - Ini bisa mempermudah ketika membuat kode program
 * - Misal ketika kita query ke Repository, dibanding mengembalikan ResultSet, alangkah baiknya Repository melakukan
 *   konversi terlebih dahulu ke class Entity / Model, sehingga kita tinggal menggunakan objectnya saja
 */
public class RepositoryTest {

    private CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepositoryImpl();
    }

    @Test
    void testInsert() {
        Comment comment = new Comment("email@email.com", "email");
        commentRepository.insert(comment);
        Assertions.assertNotNull(comment.getId());
        System.out.println(comment);
    }

    @Test
    void testFindById() {
        Comment comment = commentRepository.findById(1);
        Assertions.assertNotNull(comment);
        System.out.println(comment.getId());
        System.out.println(comment.getEmail());
        System.out.println(comment.getComment());
    }

    @Test
    void testFindAll() {
        List<Comment> comments = commentRepository.findAll();
        Assertions.assertNotNull(comments);
        Assertions.assertEquals(true, comments.size() > 0);
    }
}
