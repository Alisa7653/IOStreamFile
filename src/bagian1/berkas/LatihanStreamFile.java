
package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanStreamFile {
    public static void main(String[] args) {
        
        // --- SOAL 1: Mengecek laporan.txt dan ukurannya ---
        File fileLaporan = new File("laporan.txt");
        System.out.println("=== SOAL 1 ===");
        if (fileLaporan.exists()) {
            System.out.println("Berkas laporan.txt ditemukan.");
            System.out.println("Ukuran berkas: " + fileLaporan.length() + " bytes");
        } else {
            System.out.println("Berkas laporan.txt TIDAK ditemukan.");
        }
        System.out.println();

        
        // --- SOAL 2: Membuat folder 'arsip' ---
        File folderArsip = new File("arsip");
        System.out.println("=== SOAL 2 ===");
        if (folderArsip.mkdir()) {
            System.out.println("Folder 'arsip' berhasil dibuat.");
        } else {
            System.out.println("Folder 'arsip' gagal dibuat (atau sudah ada sebelumnya).");
        }
        System.out.println();

        
        // --- SOAL 3: Membuat file sementara, lalu menghapusnya ---
        File fileSementara = new File("sementara.txt");
        System.out.println("=== SOAL 3 ===");
        try {
            // Cek sebelum dibuat
            System.out.println("Apakah file sementara ada sebelum dibuat? " + fileSementara.exists());
            
            // Buat berkasnya
            if (fileSementara.createNewFile()) {
                System.out.println("Berkas sementara.txt berhasil dibuat.");
            }
            
            // Cek setelah dibuat
            System.out.println("Apakah file sementara ada setelah dibuat? " + fileSementara.exists());
            
            // Hapus kembali berkasnya
            if (fileSementara.delete()) {
                System.out.println("Berkas sementara.txt berhasil dihapus kembali.");
            }
            
            // Cek sesudah dihapus
            System.out.println("Apakah file sementara ada sesudah dihapus? " + fileSementara.exists());
            
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan pada Soal 3: " + e.getMessage());
        }
    }
}
   


