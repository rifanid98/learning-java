package java15_validation.lesson02_contraint;

/**
 * Manual Validation
 *
 * - Sebelum menggunakan Bean Validation, untuk melakukan validasi di Java, biasanya kita lakukan secara manual
 * - Biasanya kita menggunakan if else untuk melakukan pengecekan
 * - Dan jika terjadi validasi error, biasanya kita akan buat exception terjadi
 * - Pada Bean Validation, cara kerjanya berbeda, kita tidak butuh melakukan validasi secara manual lagi, validasi di
 *   Bean Validation menggunakan Annotation yang bisa kita simpan pada Field, Method, Parameter dan lain-lain
 *
 * Constraint
 *
 * - Constraint merupakan Annotation yang digunakan sebagai penanda untuk target yang kita tambahkan (misal Field,
 *   Method, dan lain-lain)
 * - Bean Validation sudah menyediakan banyak sekali Constraint yang bisa langsung kita  gunakan
 * - Jika kita butuh validasi yang berbeda, kita juga bisa membuat constraint secara manual, yang akan kita bahas nanti
 *   di chapter tersendiri
 * - Semua Constraint di Bean Validation terdapat di package jakarta.validation.constrains
 * - https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraints/package-summary.html
 */
public class ContraintTest {
}
