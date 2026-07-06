package bagian2.bacatulis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LatihanBacaTulis {
    public static void main(String[] args) {
        String namaBerkas = "hari.txt";

        // --- SOAL 1: Tulis 5 nama hari ke dalam hari.txt dan tampilkan ke layar ---
        System.out.println("=== SOAL 1: Menulis 5 Hari ===");
        String[] hariAwal = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaBerkas))) {
            for (String hari : hariAwal) {
                writer.write(hari);
                writer.newLine();
            }
            System.out.println("Berhasil menulis 5 nama hari ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis berkas: " + e.getMessage());
        }

        // Baca kembali untuk ditampilkan ke layar
        bacaDanTampilkanFile(namaBerkas);
        System.out.println();


        // --- SOAL 2: Tambahkan (append) 2 nama hari lagi dan tampilkan seluruh isinya ---
        System.out.println("=== SOAL 2: Menambahkan 2 Hari (Append) ===");
        String[] hariTambahan = {"Sabtu", "Minggu"};
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaBerkas, true))) {
            for (String hari : hariTambahan) {
                writer.write(hari);
                writer.newLine();
            }
            System.out.println("Berhasil menambahkan 2 nama hari lagi.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menambah berkas: " + e.getMessage());
        }

        // Baca kembali seluruh isinya untuk ditampilkan ke layar
        bacaDanTampilkanFile(namaBerkas);
        System.out.println();


        // --- SOAL 3: Hitung dan tampilkan berapa banyak baris yang ada di dalamnya ---
        System.out.println("=== SOAL 3: Menghitung Jumlah Baris ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(namaBerkas))) {
            int jumlahBaris = 0;
            while (reader.readLine() != null) {
                jumlahBaris++;
            }
            System.out.println("Jumlah baris yang ada di dalam berkas " + namaBerkas + " adalah: " + jumlahBaris + " baris.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menghitung baris: " + e.getMessage());
        }
    }

    // Fungsi bantuan untuk membaca dan menampilkan isi file ke layar
    private static void bacaDanTampilkanFile(String namaFile) {
        System.out.println("--- Isi berkas " + namaFile + " saat ini ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            String baris;
            while ((baris = reader.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca berkas: " + e.getMessage());
        }
    }
}
