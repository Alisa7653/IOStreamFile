
package bagian3.kontak;

public class LatihanMultiClass {
 
    public static void main(String[] args) {
        BukuKontak buku = new BukuKontak();

        System.out.println("=== 1. MENAMPILKAN DATA AWAL ===");
        buku.tampilkanSemua();
        System.out.println();

        System.out.println("=== 2. MENAMBAH KONTAK BARU ===");
        buku.tambahKontak(new Kontak("Budi", "0812345", "budi@mail.com"));
        buku.tambahKontak(new Kontak("Andi", "0856789", "andi@mail.com"));
        buku.tampilkanSemua();
        System.out.println();

        System.out.println("=== 3. MENGUJI PENCARIAN KONTAK ===");
        buku.cariKontak("Budi");
        buku.cariKontak("Chandra");
        System.out.println();

        System.out.println("=== 4. MENGUJI PENGHAPUSAN KONTAK ===");
        buku.hapusKontak("Andi");
        System.out.println("\n--- Isi Buku Kontak Akhir ---");
        buku.tampilkanSemua();
    }
}

