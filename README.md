Muhammad Rafi Sugianto/ A /2406357135

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