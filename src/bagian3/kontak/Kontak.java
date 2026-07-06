
package bagian3.kontak;

public class Kontak {

    private String nama;
    private String telepon;
    private String email; // Tambahan Soal 2

    // Constructor dengan 3 atribut (Soal 2)
    public Kontak(String nama, String telepon, String email) {
        this.nama = nama;
        this.telepon = telepon;
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public String getEmail() {
        return email;
    }

    // Mengubah objek menjadi format baris teks CSV untuk disimpan ke berkas (Soal 2)
    public String keBaris() {
        return nama + "," + telepon + "," + email;
    }

    // Mengembalikan informasi lengkap kontak (Soal 2)
    public String getInfo() {
        return "Nama: " + nama + " | Telp: " + telepon + " | Email: " + email;
    }
}

