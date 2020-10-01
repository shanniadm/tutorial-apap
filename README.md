# Tutorial APAP
## Authors
* **Shannia Dwi Melianti** - *1806191332* - *A*
---
## **Tutorial 1**
### What I have learn today

### **Github**
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
###
Issue tracker adalah aplikasi yang digunakan oleh melacak masalah yang dialami oleh user dalam suatu software dan memungkinkan developer untuk melacak masalah tersebut sampai berhasil diselesaikan. Issue tracker ini dapat menyelesaikan masalah apa saja yang terkait dengan penyelesaian bug dan peningkatan server. Bug tidak hanya terkait pada kode tetapi mungkin juga pada desain dan spesifikasi produk. Dengan adanya quality check maka memungkinkan kita dapat menangani masalah sebelum terjadi. 
###
2. Apa perbedaan dari git merge dan git merge --squash? 
###
Git Merge adalah command dalam Git yang ditujukan untuk membuat branch yang bercabang menjadi satu kembali atau mengintegrasikan branch menjadi satu. Pada git merge --squash, kita dapat membuat commit tunggal diatas branch yang efeknya sama seperti menggabungkan branch lain, tetapi tidak akan menghasilkan rekaman merge. 
###
3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu
aplikasi?
###
Version control system adalah sebuah sistem yang mencatat perubahan pada suatu file sehingga suatu saat kita bisa kembali ke versi lain dari file tersebut. Keunggulan Version Control System yang disediakan Git ialah repository syncing, dapat bekerja secara offline, cheap local branching, staging area yang nyaman, serta dapat mengangani proyek yang besar sekalipun dan efektif dalam hal kecepatan dan ukuran data. 
### **Spring**
1.  Apa itu library & dependency?
###
Library adalah kode kompilasi yang memiliki fungsionalitas yang tersedia untuk digunakan dalam program yang ditentukan secara manual oleh programmer. Sedangkan, dependency adalah ketergantungan atau hubungan antara dua bagian kode. Sebuah kode library akan menjadi dependensi ketika project lain menggunakannya dan ini menjadi dependensi antara project tersebut dengan yang lainnya.
### 
2. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
###
Ketika kita bekerja dalam suatu tim maka perlu memperhatikan struktur folder, penggunaan library, dan workflow. Dengan maven, kita tidak perlu membuat aturan sendiri dan hanya perlu mempelajari aturan yang sudah Maven terapkan. Apapun jenis aplikasi yang dibuat maka strukturnya akan sama. Aturan yang dibuat oleh Maven adalah mengenai konfigurasi project, struktur folder, dan juga bagaimana cara menjalankannya. Ada alternatif lain yang dapat menggantikan Maven yaitu **ant+ivy** dan **graddle**.
###
3. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
###
Spring Framework dapat digunakan juga untuk membaut aplikasi terkait keamanan dan big data. Aplikasi yang dikembangkan pun dapat berjalan pada JVM manapun. 
### 
4. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?
###
@PathVariable digunakan untuk data yang diteruskan di URI sedangkan @RequestParam digunakan untuk mengekstrak data yang ditemukan pada parameter query. @PathVariable baiknya digunakan ketika kita ingin mengidentifikasi dari pola resource yang ada, sedangkan @RequestParam ketika ingin mencari resource.  

-------
###
Referensi :
https://www.zendesk.com/blog/issue-tracker/
https://blog.ezofficeinventory.com/issue-tracking-software/
https://medium.com/scrum-ai/git-merge-and-stuff-24080128754e
https://techarea.co.id/7-version-control-system-yang-perlu-anda-ketahui/
https://softwareengineering.stackexchange.com/questions/408739/what-is-the-difference-between-a-library-and-a-dependency
https://software.endy.muhardin.com/java/apache-maven/
https://medium.com/1developer/spring-requestparam-vs-queryparam-vs-pathvariable-vs-pathparam-7c5655e541ad 

## **Tutorial 2**
### **Pertanyaan**
###
1.  Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut: http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom&noTelepon=081xxx. Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
###
**Jawab** : Terjadi Internal Server Error (500), hal ini dikarenakan template add-hotel yang tidak tersedia. 
###
###
2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat.
###
**Jawab** : @Autowired merupakan implementasi dari Dependency Injection yang mampu merapikan aplikasi yang kita buat sehingga lebih mudah dipahami dan dikelola. Cara kerja dari Autowired adalah mencari referensi bean yang tipe/classnya sama dengan parameter setter, constructor atau field. Untuk annotation, @Autowired akan melakukan dependency checking pada referensi bean, jika tidak ditemukan, maka akan melemparkan exception. 
###
3. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut: http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
###
**Jawab** : Terjadi Bad Request (400) dikarenakan tidak terdapat parameter noTelepon sehingga tidak dapat menginisiasi objek HotelModel. 
###
4. Pertanyaan 4: Jika Papa APAP ingin melihat Hotel dengan nama Papa APAP, link apa yang harus diakses?
### 
**Jawab** : Dikarenakan dalam tutorial PAPA Apap memiliki idHotel berjumlah 1, maka untuk menampilkan hotel dengan Papa APAP harus melalui link http://localhost:8080/hotel/view?idHotel=1
###
5. Pertanyaan 5: Tambahkan 1 contoh Hotel lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/hotel/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
###
**Jawab** : Yang ditampilkan adalah semua hotel yang berada di list yaitu hotel Papa APAP dan hotel yang baru saya tambahkan. 

![ScreenShot](https://i.ibb.co/S7K0Zk3/Hotel-Screen-Shot.jpg)

Atau bisa dilihat melalui tautan berikut : https://drive.google.com/file/d/1W162xmfb5kyIeTlb6nglJjJnrMffXbMp/view?usp=sharing







