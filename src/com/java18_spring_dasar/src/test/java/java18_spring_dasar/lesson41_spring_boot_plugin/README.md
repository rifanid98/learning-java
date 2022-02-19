# Spring Boot Plugin

- Saat kita membuat project Spring Boot, secara otomatis terdapat spring-boot-plugin di project maven kita
- Plugin ini bisa digunakan untuk mempermudah saat kita menjalankan aplikasi Spring kita
- Kita bisa gunakan perintah :
- mvn spring-boot:run

# Distribution File

- Spring Boot plugin juga sudah menyediakan cara membuat distribution file aplikasi kita
- Plugin ini akan mendeteksi main class di project kita, lalu membundle aplikasi kita beserta dependency yang dibutuhkan
  dalam satu file jar
- Pastikan hanya terdapat satu main class, karena jika lebih dari satu, maka spring boot plugin akan melakukan komplen
- Kita cukup gunakan perintah :
- mvn package 
