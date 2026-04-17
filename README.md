Design and Implementation of an OOO Driver Transformation Simulator in Java
Nama Anggota Kelompok:

Andra Ilham Triadi Mijaya 
2086022510016 
IMT - AI                     
Bryant 
2086022510003
IMT - FSD 
Christian Farrel Tanmel 
2086022510011 
IMT - FSD
Richardo Wilsen Mathana Radha 
2086022510035
IMT - FSD

Cara compile
Buka terminal lalu ketik javac "di tanda kutip ini paste relative path file yang ingin di compile" lalu tekan enter. lakukan sampai semua file telah di compile

Cara run
Buka terminal lalu ketik java "di tanda kutip ini paste relative path file Main.java" lalu tekan enter. yang di run adalah file Main.java karena konsol simulasinya berada pada file ini

Key Feature
- menyimpan objek CoreMedal yang tersedia di MedalRepository
- memungkinkan user memasukkan medal ke Belt dengan tiga slot khusus: HEAD, ARMS, dan LEGS
- melacak status Belt di OOODriver, termasuk apakah Belt sedang di-tilt dan medal mana yang terpasang
- mendefinisikan kombinasi valid di ComboCatalogue dan ComboRule
- memindai Belt di TransformationEngine untuk menentukan apakah kombinasi medal saat ini adalah COMBO, MIXED, atau CHARGE
- menampilkan menu konsol di Main untuk memasukkan medal, men-tilt sabuk, scan, remove medal, dan exit

Collections
Program ini menggunakan collection berupa ArrayList untuk menyimpan data yang bersifat dinamis. Class MedalRepository menggunakan ArrayList untuk menyimpan seluruh CoreMedal yang tersedia. Selain itu, class ComboCatalogue juga menggunakan ArrayList untuk menyimpan kumpulan ComboRule. Penggunaan collection ini memungkinkan data medal dan combo dikelola secara fleksibel, mudah diakses, dan dapat ditambahkan atau diubah sesuai kebutuhan.

Generic
Generics digunakan pada class MedalRepository<T> untuk membuat penyimpanan data yang lebih fleksibel dan aman. Dengan menggunakan generics, class ini dapat digunakan untuk menyimpan berbagai tipe objek tanpa perlu membuat class baru untuk setiap tipe data. Dalam implementasi ini, MedalRepository<CoreMedal> digunakan untuk menyimpan objek medal. Penggunaan generics juga membantu mengurangi kesalahan tipe data (type safety) saat proses penyimpanan dan pengambilan data.

Exception
Program ini menggunakan exception handling untuk menangani kondisi error yang mungkin terjadi selama eksekusi. Contohnya, pada method insert() di class OOODriver, akan dilempar exception jika slot yang ingin diisi sudah terisi sebelumnya. Selain itu, pada proses scanning di TransformationEngine, exception juga digunakan ketika slot belum lengkap namun user mencoba melakukan scan. Dengan adanya exception handling, program dapat memberikan pesan error yang jelas tanpa menyebabkan program berhenti secara tiba-tiba. 