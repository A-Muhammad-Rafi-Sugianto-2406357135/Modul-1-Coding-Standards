Muhammad Rafi Sugianto/ A /2406357135

<details>
<Summary><b>Modul 1</b></Summary>

Modul 1

Refleksi 1
1. Setelah saya mengerjakan latihan pada Exercises 1, beberapa prinsip Clean Code yang menurut saya telah saya implementasikan diantaranya adalah:
   - Membuat fungsi yang pendek, memiliki nama yang jelas, dan terorganized dengan baik
     Saya akan mengambil contoh fungsi create di ProductRepository

     public Product create (Product product) {
         productData.add(product);
         return product;
     }

     FUngsi ini jelas pendek, dan memiliki nama yang jelas, yaitu fungsi untuk crete produk

   = Melakukan satu hal spesifik
     JIka kita mengambil contoh pada fungsi create di atas, fungsi tsb telah menerapkan prinsip ini, karena fungsi tersebut jelas hanya melakukan satu fungsi spesifik, yaitumenambahkan sebuah produk ke dalam productData dan mereturn produk tsb.

   - Pemisahan antara command dan query
     Pemisahan command dan query terlihat pada implementasi class product menggunakan lombok getter dan setter, sehingga ada pemisahan yang jelas antara command (setter), dan query (getter)

   Sebagai kesimpulan saya rasa saya telah mengimplementasikan prinsip2 clean code dnegna baik dn benar.

   Selanjutnya mengenai secure coding, saya telah mengimplementasikan pada form html pembuatan produk, dimana pada kolom quantity input dijamis sebuah angka. Hal tsb terlihat pada potongan kode berikut:
    
   <div class="form-group">
            <label for="quantityInput">Quantity</label>
            <input th:field="*{productQuantity}" type="number" class="form-control mb-4 col-4" id="quantityInput" placeholder="Enter product' name">
    </div>
   
Refleksi 2
1. Perasaan saya setelah membuat unit test amatlah senang :D, saya rasa saya masih perlu belajar lebih dlam tentang hal ini. 

   "How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program?"

   Saya pikir, banyaknya unit test tidak menjamin bahwa suatu program kita terverify dengan baik. Asalkan unit test kita dibuat dengan intent untuk mengetes semua fungsi dan berbgai perilakunya,dan coveragenya mendekati 100%, saya rasa hal tsb cukup untuk memverifikasi program yang kita tulis. Namun 100% code coverage tidak berarti bahwa code tsb bebas dari bug dan error. Perlu diketahui bahwa code coverage hanya menilai dari unit test yg kita buat, sedangkan unit test yang kita buat tsb belum tentu bahwa keseluruhan code kita berjalan dgn benar.
2. salah satu prinsip utama dari clean code adalah DOn't Repeat Yourself yang bermaksud agar kita mengurangi redundansi pada code. Jika kita membuat sebuah functional test yang baru, namun dengan setup dan instances variabel yg sama, ada baiknya test tersebut digabung saja dengan tes sebelumnya. Mungkin bisa berupa penambahan fungsi baru yang khusus mengetes jumlah items di product list, namun dilakukan tanpa membuat java class baru dengan setup procedure yang sama dengan  functional test sebelumnya. Hal ini tentunya akan mengurangi redundansi code dan menerapkan prnsip clean code dengan baik.

</details>

<details>
<Summary><b>Modul 2</b></Summary>

Refleksi 1
1. List the code quality issue(s) that you fixed during the exercise and explain your strategy
   on fixing them.


   Berikut adalah code quality issue(s) yg terdeteksi oleh SonarCloud dan strategi bagaimana saya memperbaikinya:
    
   - Commented-out code di `ProductRepositoryTest.java`, strategi memperbaikinya adalah saya menghapus baris kode yg dicomment karena kode tsb tidak diperlukan dan hanya membuat kode lebih sulit dibaca
   - Modifier `public` yg tidak perlu di `CreateProductFunctionalTest.java`, Saya menghapus modifier `public` pada class test karena JUnit 5 tidak memerlukan modifier `public` pada class test, strategi saya adalah mengikuti rekomendasi SonarCloud dan best practice JUnit 5


2. Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current
   implementation has met the definition of Continuous Integration and Continuous
   Deployment? Explain the reasons (minimum 3 sentences)


   Ya, menurut saya implementasi CI/CD yg saya buat sudah memenuhi definisi Continuous Integration dan Continuous Deployment. Untuk Continuous Integration, setiap push ke semua branch akan otomatis menjalankan unit test dan analisis kode menggunakan SonarCloud, sehingga setiap perubahan kode selalu diverifikasi secara otomatis. Untuk Continuous Deployment, setiap push ke branch `main` akan otomatis men-trigger deployment ke Koyeb, sehingga perubahan kode yg sudah diverifikasi akan langsung dideploy ke production. Dengan demikian, pipeline yg saya buat sudah mencakup seluruh siklus dari code quality check hingga deployment secara otomatis

</details>

<details>
<Summary><b>Modul 3</b></Summary>

1. Principle yang saya terapkan pada project saya di antaranya adalah:

   - Single Responsibility, disini saya menerapkan prinsip ini dengan memisahkan class CarController dan ProductController menjadi 2 file yang berbeda (awalnya kedua class tsb digabung di 1 file), karena 1 unit (file, class, method, dst) harus memiliki 1 tanggung jawab saja. Selanjutnya, saya juga menghapus Hapus CarController extends ProductController, karena setiap controller harus punya tanggung jawab sendiri dan tidak boleh mewarisi logika yang tidak relevan.

   - Open Closed, saya menerapkan prinsip ini dengan mengubah CarRepository menjadi sebuah interface, dengan ebgitu kita bisa menambahkan implementasi baru misal menggunakan JPA, MongoDB, dst tanpa mengubah kode yg sudah ada.

   - Liskov Substitution, saya menerapkan prinsip ini dengan menhapus CarController extends ProductController karena tidak ada relasi is-a, karena Car bukan jenis Product dalam konteks controller, CarController tidak seharusnya mewarisi ProductController

   - Dependency Inversion, saya menerapkan prinsip ini dengan membuat interface CarRepository dan CarService di setiap layer, sehingga layer atas tidak bergantung pada implementasi konkret. Saya juga mengubah field injection menjadi constructor injection di CarServiceImpl dan CarController, karena dependency harus inject dari luar, bukan dibuat sendiri di dalam class.
   
2. Beberapa keuntungan menerapkan SOLID diantaranya adalah:

   - Mudah melakukan migrasi ke database, karena CarRepository adalah interface, jika ingin migrasi ke JPA maka kita cukup membuat implementasi baru, misal seperti di bawah ini:

      @Repository
      public class JpaCarRepository implements CarRepository {
         // implementasi JPA
      }
      
      Hal ini bisa dilakukan tanpa memodifikasi service dan controller sama sekali.

   - Mudah ditest,  krn menggunakan constructor injection dan interface, dependency bisa dimock saat unit testing dan tidak perlu         database asli

      CarRepository mockRepo = mock(CarRepository.class);
      CarServiceImpl service = new CarServiceImpl(mockRepo);

   - Mudah dimaintain, karena CarController dan ProductController dipisah menjadi file berbeda, ketika ada bug di fitur Car, developer langsung tahu harus buka file mana tanpa takut tidak sengaja merusak logika Product dst

3. Beberapa kerugian tidak menerapkan SOLID diantaranya adalah:

   - Perubahan kecil bisa merusak banyak hal, krn sebelumnya CarController extends ProductController, perubahan di ProductController bisa    tidak sengaja merusak behavior CarController meski tidak ada hubungannya sama sekali.

   - Sulit ditest, karena field injection @Autowired menyembunyikan dependency, untuk test Controller kita terpaksa harus menjalankan Service dan Repository yang asli juga.
   
   - Kode sulit dibaca dan dipahami, karena dua class CarController dan ProductController digabung dalam satu file, developer yang baru bergabung ke project harus membaca seluruh file hanya untuk memahami satu fitur saja, sehingga membuang waktu dan bisa sjaa salah edit.


</details>

