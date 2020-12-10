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
**Jawab** : Yang ditampilkan adalah semua hotel yang berada di list yaitu hotel Papa APAP dan hotel yang baru saya tambahkan yaitu bernama Hotel Shannia. 

![ScreenShot](https://i.ibb.co/S7K0Zk3/Hotel-Screen-Shot.jpg)

Atau bisa dilihat melalui tautan berikut : https://drive.google.com/file/d/1W162xmfb5kyIeTlb6nglJjJnrMffXbMp/view?usp=sharing

-----
## **Tutorial 3**
### **Pertanyaan**
###
1. Pada class KamarDb, terdapat method findAllByHotelId, apakah kegunaan dari method tersebut?
##
Method findAllByHotelId berfungsi untuk mengambil beberapa entitas KamarModel sekaligus berdasarkan HotelId yang diberikan yang akan dikembalikan dalam bentuk List. 
##
2. Pada class HotelController, jelaskan perbedaan method addHotelFormPage dan addHotelSubmit?
##
Method AddHotelFormPage ditujukan untuk mencetak form untuk menambahkan Hotel dengan menjalankan html "form-add-hotel", sedangkan AddHotelSubmit untuk mengambil nilai/value dari form yang sudah dicetak dari AddHotelFormPage kemudian menginisiasi hotel baru.  
##
3. Jelaskan kegunaan dari JPA Repository!
##
Kegunaan dari JPA Repository adalah mempermudah user untuk membuat repositori tanpa kode, dimana menyembunyikan detail implementasi khusus penyimpanan data serta memungkinkan untuk menerapkan kode pada tingkat abstraksi yang lebih tinggi. Selain itu, JPA Repository juga mempermudah dalam pembuatan query database berdasarkan nama metode yang ada, dimana apabila tidak terlalu rumit maka hanya perlu untuk menentukan kode pada interface repository. 
##
4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara HotelModel dan KamarModel dibuat?
##
Pada HotelModel terdapat relasi OneToMany dengan Kamar Model pada kodingan tersebut :
@OneToMany(mappedBy="hotel", fetch= FetchType.LAZY, cascade= CascadeType.ALL)
    private List< KamarModel > listKamar;
Kode tersebut untuk membuat relasi bahwa 1 Hotel dapat memiliki banyak kamar sekaligus. 
##
5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER!
##
FetchType.LAZY : Mengambil entitas anak dengan malas, yaitu saat mengambil entitas parents, maka hanya mengambil proxy saja dari entitas anak. Ketika kita mengakses properti dari entitas child maka sebenarnya diambil dengan hibernate. 
##
CascadeType.ALL : Mewariskan semua operasi entity manager seperti persist, remove, refresh, merge dan detach ke etitas yang terkait. 
##
FetchType.EAGER : Untuk mengambil entitas child bersama dengan parentnya. 
##
Referensi :
##
https://www.java2novice.com/hibernate/eager-vs-lazy-fetch-type/
##
https://thorben-janssen.com/what-is-spring-data-jpa-and-why-should-you-use-it/#3_reasons_to_use_Spring_Data_JPA
##
https://stackoverflow.com/questions/13027214/what-is-the-meaning-of-the-cascadetype-all-for-a-manytoone-jpa-association
##

-----------
## **Tutorial 4**
### **Pertanyaan**
###
1. Jelaskan perbedaan th:include dan th:replace!
##
th:replace ditujukan untuk menggantikan tag host dengan tag yang didefinisikan di fragment, sedangkan th:include ditujukan untuk memasukan fragment yang ditentukan sebagai badan dari tag hostnya, tetapi mengecualikan tag dari fragment. 
##
2. Jelaskan apa fungsi dari th:object!
##
th:object digunakan untuk mendefinisikan dari object mana suatu field di referensikan. Misalnya, pada suatu form terdapat th:object, maka di dalam form tersebut *{field} direferensikan oleh object tersebut. 
##
3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
##
${} adalah variable expressions atau ekspresi standar. *{} adalah selection variable expressions, hampir sama seperti variable expressions, namun ekspresi tersebut bisa dikombinasikan dengan atribut th:object. Misalnya, kita memiliki < form th:objects="${form}">, maka ekspresi *{field} sama seperti ${form.field} dimana hal ini sering digunakan untuk membuat formulir saat atribut th:field digunakan. 
##
4. Bagaimana kamu menyelesaikan latihan nomor 3?
##
Saya menyelesaikan nomor 3 dengan memberikan parameter ke html terkait mengenai informasi halaman sehingga ketika menjalankan navbar, html akan memanggil ${halaman} yang merupakan nama halaman tersebut. Misalnya, pada Controller, di fungsi Add Hotel maka akan ditambahkan parameter bernama halaman yang akan bisa diakses di HTML yang berisi string "Add Hotel". Hal tersebut saya lakukan untuk setiap page yang ada. 
##

----------------

## **Tutorial 5**
### **Pertanyaan**
##
1. Apa itu Postman? Apa kegunaannya?
##
Postman adalah aplikasi yang digunakan untuk uji coba Rest API dimana berfungsi sebagai rest client. Fungsi utamanya tentunya untuk GUI API Caller, namun saat ini Postman juga memiliki banyak fitur lainnya seperti Testing API, Sharing Collection API for Documentation, dan lainnya. 
##
2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
##
@JsonIgnoreProperties digunakan di tingkat suatu kelas untuk menandakan properti mana atau bahkan daftar properti yang nantinya akan diabaikan. Sedangkan @JsonProperty untuk mendefinisikan logical property yang digunakan dalam serialisasi dan deserialisasi JSON. @JsonProperti dapat mengubah visibilitas logical property menggunakan access elementnya selama serialisasi dan deserialisasi JSON.
##
3. Apa kegunaan atribut WebClient?
##
WebClient digunakan untuk mengirim data/menerima data baik ke local, intranet, atau internet yang diidentifikasi oleh URI, dimana webclient menggunakan WebRequest untuk menyediakan akses ke sumber yang dituju. 
##
4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
##
ResponseEntity adalah fungsi yang merepresentasikan seluruh respons HTTP baik status code, header, dan juga isinya. Kegunaannya adalah kita dapat menggunakan ResponseEntity untuk mengkonfigurasikan respons HTTP dimana kita dapat mengembalikan informasi ketika error atau informasi yang related. Sedangkan, BindingResult adalah objek spring yang digunakan untuk menyimpan hasil validasi, binding, dan juga error yang terjadi. Dengan BindingResult, kita dapat melihat apakah objek model tersebut valid atau tidak, jika gagal maka akan mengeluarkan *exception*. 
#
Referensi :
##
https://medium.com/skyshidigital/documentation-testing-api-dengan-postman-part-1-5d33e430dca7
##
https://www.concretepage.com/jackson-api/jackson-jsonignore-jsonignoreproperties-and-jsonignoretype
##
https://www.concretepage.com/jackson-api/jackson-jsonproperty-and-jsonalias-example
##
https://stackoverflow.com/questions/10413886/what-is-the-use-of-bindingresult-interface-in-spring-mvc


----------------

## **Tutorial 6**
### **Pertanyaan**
##
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?
##
Jawab : Otentikasi adalah suatu proses untuk memverifikasi siapa kita, misalnya dengan login. Sedangkan otorisasi adalah proses memverifikasi apakah kita memiliki akses ke sesuatu, misalnya hanya admin yang bisa menambah user. Contoh implementasi kode dalam kedua hal tersebut adalah : (1) Penerapan otentikasi ketika melakukan login yaitu authenticated() ketika configure. (2) Penerapan otorisasi adalah pada WebSecurityConfig terdapat fungsi configure dimana terdapat antMatchers dan hasAuthority, jadi untuk url tertentu hanya bisa diakses oleh role tertentu saja. 
##
2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.
## 
Jawab : BCryptPasswordEncoder adalah suatu fungsi yang digunakan untuk melakukan enkripsi hash untuk password. Cara kerjanya adalah melakukan inisiasi dengan membuat object BCrypt kemudian dapat menggunakan fungsi-fungsi yang ada seperti menggunakan fungsi encode() untuk mengubah password menjadi hashPassword, kemudian untuk memverifikasi password yang ada menggunakan fungsi matches(). 
##
3. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
##
Jawab : UUID atau Universally Unique Identifier adalah kumpulan 36 karakter string yang dibuat secara acak serta unik menggunakan teknik khusus. Penggunaannya adalah untuk sebagai Primary Key, dikarenakan karakter UUID yang unik maka kecil kemungkinan karakter UUID sama bahkan jika digenerate dalam 1 detik sekalipun. Selain itu, penggunaan UUID ditujukan untuk menghindari konflik primary key, serta untuk mengamankan data dikarenakan pengguna iseng tidak dapat mengetahui data profile orang lain dengan ID profile apabila menggunakan UUID. 
##
4. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?
##
Jawab : Kegunaan class tersebut adalah untuk mengembalikan grantedAuthorities yang diperlukan. Dimana UserDetailsServiceImpl adalah tempat pemetaan otoritas dilakukan, dimana setelah pengguna melakukan otentikasi dan menggunakan getAuthorities() untuk mengumpulkan dan mengembalikan objek UserDetails. Sedangkan Role sendiri digunakan untuk sebagai wadah otoritas tersebut. 
##
-----------------------
Referensi :
##
https://qastack.id/server/57077/what-is-the-difference-between-authentication-and-authorization
##
https://www.eplusgo.com/menggunakan-uuid-di-php/
##
https://www.baeldung.com/spring-security-granted-authority-vs-role


--------------------------------------

## **TUTORIAL 7**
### ***Pertanyaan***
##
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi
dari apa yang Anda jelaskan.
##
Jawab : 
##
![Screenshot 1](https://i.ibb.co/nDXHPGj/1.jpg)
Di soal yang pertama, saya melakukan modifikasi agar *checkbox* yang ada tidak terlihat, dengan menambahkan *condition* dimana apabila 
checkednya true maka akan menjadi checkbox, sedangkan jika tidak maka akan jadi hidden. Sehingga, pada sisi kiri tidak akan ditampilkan checkbox sedangkan di sisi kanan akan ditampilkan. 
##
![Screenshot 2](https://i.ibb.co/yfqWd4S/hehe.jpg)
![Screenshot 2b](https://i.ibb.co/gwrDZ4b/2b.jpg)
Kemudian, di soal kedua, saya membuat suatu tombol yang hanya akan muncul apabila sudah terdapat item di dalam list, dimana sama seperti pada nomor 1. Di typenya, saya berikan *condition* apabila panjang list melebihi 0 maka akan ditambilkan sebagai button, dan jika tidak maka akan di *hidden*. Kemudian, saya membuat suatu fungsi untuk menghapus list dengan melakukan set FavItems menjadi sebuah array kosong.
##
![Screenshot 3](https://i.ibb.co/JCMcPFV/3.jpg)
Di soal ketiga, saya membuat agar sisi kiri apabila di klik maka akan melakukan penghapusan di sisi favorite, maka saya menduplikasi fungsi handleItemClick dan handleFavItemClick, dimana perbedaan kedua fungsi tersebut adalah pada elsenya yaitu pada handleItemClick akan digunakan di list untuk listMovies yang tidak memiliki pilihan untuk splice, sedangkan handleFavItemClick untuk list FavItems.
##
![Screeenshot 4](https://i.ibb.co/WVr49Lq/4.jpg)
![Screeenshot 4b](https://i.ibb.co/jTd7fLf/Capture.jpg)
Di soal keempat, saya membuat toggle dengan menggunakan react-toggle. Kemudian, saya membuat handleToggle untuk mengganti value dari toggle ketika diganti (onChange). Apabila show bernilai true, maka akan menampilkan daftar favorite yang ada dimana hal ini dilakukan dengan *conditional*, apabila show true dan item di list FavItems lebih dari 0 maka akan menampilkan daftar favorit. 
##
![Screenshot 5](https://i.ibb.co/yfqWd4S/hehe.jpg)
##
Di soal kelima, sama seperti soal keempat namun mengatasi kondisi apabila item di list FavItems adalah nol dan akan menampilkan sebagai berikut. Untuk menampilkan ini, maka saya membuat Empty State untuk mencetak keterangan bahwa belum ada item yang dipilih oleh pengguna.
##
2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?
##
Jawab : Props adalah variabel yang berasal dari luar kelas atau class parent, dimana props ini biasanya digunakan untuk komunikasi data dari parent ke child component. Sedangkan state adalah variabel yang dibuat dalam suatu class, dan tidak dapat di akses dari component lainnya. 
##
3. Apa keuntungan menggunakan component (e.g. List, Item) di React? Berikan contohnya!
##
Jawab : Keuntungan menggunakan komponen ialah kode yang dihasilkan tidak akan terlalu kompleks/panjang dikarenakan dapat dipecah-pecah menggunakan komponen-komponen tersebut, selain itu komponen tersebut dapat digunakan kembali dimanapun kita membutuhkannya dan membuat tampilan yang lebih konsisten. 
##
4. Menurut kamu, apa saja kelebihan menggunakan React dalam pengembangan web?
##
Jawab : Dengan React, maka akan lebih mudah untuk menulis komponen dikarenakan memungkinkan untuk mengkombinasikan antara HTML dengan javascript dan aturan yang ada lebih sedikit. Selain itu, proses rendering akan jauh lebih cepat dikarenakan adanya virtual DOM dan dapat menghostingnya ke dalam memori, apabila terjadi perubahan, maka virtual DOM dan actual DOM akan berubah seketika karena terletak dalam memori dan tidak diperlukan pembaharuan secara keseluruhan dan rutin sehingga kinerja aplikasi tidak akan terganggu. Selain itu, komponen juga akan dapat digunakan kembali dimanapun kita membutuhkannya. 
##
5. Menurut kamu, apa saja kekurangan menggunakan React dalam pengembangan web?
##
Jawab : Dokumentasi yang buruk dikarenakan react memperbaharui dengan sangat cepat maka tidak ada waktu untuk membuat dokumentasi yang tepat. Selain itu, browser dengan versi lama tidak mendukung untuk proses reactJS ini. 
##
##
Referensi : 
##
https://www.techfor.id/10-keuntungan-menggunakan-react-js-pada-desain-website/
##
https://belajarreactjs.com/kelemahan-dari-reactjs/
##