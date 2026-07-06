
package tugas;

public class MainTugas {
    // Nama: Nuralisawardani 
// NPM: 2410010329

    public static void main(String[] args) {
        Gudang toko = new Gudang();

        // 1. Menampilkan daftar kategori toko
        toko.tampilkanKategori();

        System.out.println("=== MEMASUKKAN 5 OBJEK BARANG BARU ===");
        // 2. Menambah 5 objek Barang ke dalam Gudang
        toko.tambahBarang(new Barang("Laptop Asus", 7500000, 5));
        toko.tambahBarang(new Barang("Smartphone Samsung", 3500000, 10));
        toko.tambahBarang(new Barang("Kemeja Flanel", 150000, 20));
        toko.tambahBarang(new Barang("Sepatu Sneaker", 450000, 8));
        toko.tambahBarang(new Barang("Cokelat Batangan", 15000, 50));
        
        // Menampilkan seluruh data barang setelah diinput
        toko.tampilkanSemua();
        System.out.println("Total Nilai Persediaan: Rp" + toko.totalNilai());
        System.out.println();

        System.out.println("=== MEMBUAT OBJEK GUDANG BARU (BUKTI TERFORMAT) ===");
        // 3. Membuat objek gudang baru untuk membuktikan data tersimpan dan memuat kembali dari berkas teks
        Gudang tokoBaru = new Gudang();
        System.out.println("--- Hasil Memuat Ulang dari Berkas barang.txt ---");
        tokoBaru.tampilkanSemua();
        System.out.println("Total Nilai Persediaan Gudang Baru: Rp" + tokoBaru.totalNilai());
    }
}

