package tugas;

import java.io.*;
import java.util.ArrayList;

public class Gudang {
    private ArrayList<Barang> daftarBarang;
    private final String namaBerkas = "barang.txt";
    private String[] kategori = {"Elektronik", "Pakaian", "Makanan"};

    public Gudang() {
        daftarBarang = new ArrayList<>();
        muatDariBerkas();
    }

    public void tampilkanKategori() {
        System.out.println("--- Daftar Kategori Toko ---");
        for (String kat : kategori) {
            System.out.println("- " + kat);
        }
        System.out.println();
    }

    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
        simpanKeBerkas();
    }

    public void tampilkanSemua() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Gudang masih kosong.");
        } else {
            for (Barang b : daftarBarang) {
                System.out.println(b.info());
            }
        }
    }

    public double totalNilai() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total += b.getHarga() * b.getStok();
        }
        return total;
    }

    public void simpanKeBerkas() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaBerkas))) {
            for (Barang b : daftarBarang) {
                writer.write(b.keBaris());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan ke berkas: " + e.getMessage());
        }
    }

    public void muatDariBerkas() {
        File file = new File(namaBerkas);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String baris;
            daftarBarang.clear();
            while ((baris = reader.readLine()) != null) {
                String[] bagian = baris.split(",");
                if (bagian.length == 3) {
                    String nama = bagian[0];
                    double harga = Double.parseDouble(bagian[1]);
                    int stok = Integer.parseInt(bagian[2]);
                    daftarBarang.add(new Barang(nama, harga, stok));
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal memuat data berkas: " + e.getMessage());
        }
    }
}
