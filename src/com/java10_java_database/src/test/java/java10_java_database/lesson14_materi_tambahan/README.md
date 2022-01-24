# Materi yang Tidak Dibahas

- Sebenarnya ada fitur di JDBC yang tidak saya bahas di course ini, namanya adalah CallableStatement
- CallableStatement adalah fitur JDBC untuk memanggil STORE PROCEDURE di database 
- Jika teman-teman masih menggunakan STORE PROCEDURE di database ketika membuat aplikasi, maka disarankan mempelajari CallableStatement 

# Kenapa Tidak Dibahas?

- STORE PROCEDURE adalah fitur yang sangat canggih di database
- Namun saat ini, penggunaan STORE PROCEDURE sudah jarang sekali digunakan 
- Problem nya karena pembuatan logic aplikasi di database menggunakan STORE PROCEDURE akan membuat script database semakin besar, dan sulit untuk di maintain. Terutama ketika terjadi perubahan logic 
- Tidak ada proses deployment aplikasi kalo logic nya disimpan semuanya di STORE PROCEDURE 
- Dan yang paling sulit adalah melakukan proses rollback kode jika terjadi masalah di STORE PROCEDURE 
