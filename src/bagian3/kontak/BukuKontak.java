package bagian3.kontak;

import java.io.*;
import java.util.ArrayList;

public class BukuKontak {
    private ArrayList<Kontak> daftarKontak;
    private final String namaBerkas = "kontak.txt";

    public BukuKontak() {
        daftarKontak = new ArrayList<>();
        muatDariBerkas();
    }

    public void cariKontak(String nama) {
        boolean ditemukan = false;
        for (Kontak k : daftarKontak) {
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Kontak Ditemukan -> " + k.getInfo());
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Pesan: Kontak dengan nama '" + nama + "' tidak ditemukan.");
        }
    }

    public void hapusKontak(String nama) {
        boolean berhasilHapus = false;
        for (int i = 0; i < daftarKontak.size(); i++) {
            if (daftarKontak.get(i).getNama().equalsIgnoreCase(nama)) {
                daftarKontak.remove(i);
                berhasilHapus = true;
                System.out.println("Berhasil menghapus kontak bernama: " + nama);
                break;
            }
        }
        
        if (berhasilHapus) {
            simpanKeBerkas();
        } else {
            System.out.println("Gagal menghapus: Kontak '" + nama + "' tidak ditemukan.");
        }
    }

    public void tambahKontak(Kontak kontak) {
        daftarKontak.add(kontak);
        simpanKeBerkas();
    }

    public void tampilkanSemua() {
        if (daftarKontak.isEmpty()) {
            System.out.println("Buku kontak masih kosong.");
        } else {
            for (Kontak k : daftarKontak) {
                System.out.println(k.getInfo());
            }
        }
    }

    public void simpanKeBerkas() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaBerkas))) {
            for (Kontak k : daftarKontak) {
                writer.write(k.keBaris());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan ke berkas: " + e.getMessage());
        }
    }

    private void muatDariBerkas() {
        File file = new File(namaBerkas);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String baris;
            daftarKontak.clear();
            while ((baris = reader.readLine()) != null) {
                String[] bagian = baris.split(",");
                if (bagian.length == 3) {
                    daftarKontak.add(new Kontak(bagian[0], bagian[1], bagian[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal memuat data berkas: " + e.getMessage());
        }
    }
} 
