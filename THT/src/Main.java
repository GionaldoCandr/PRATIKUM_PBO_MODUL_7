import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        // Deklarasi ArrayList bertipe Superclass (Upcasting) 
        ArrayList<LayananEkspedisi> daftarPaket = new ArrayList<>();

        // Menambahkan data objek "sebenernye upcasting tu otomatis" 
        daftarPaket.add(new LayananReguler("REG-11", 2, 50, 50, 50));
        daftarPaket.add(new LayananExpress("EXP-22", 5, 10, 10, 10));
        daftarPaket.add(new LayananInternasional("INT-33", 3, 20, 20, 20, "Korea", 100));

        // Variabel penampung total pendapatan dasar 
        double totalPendapatanPerusahaan = 0.0;

        // Perulangan untuk menelusuri koleksi (Runtime Polymorphism)
        for (LayananEkspedisi paket : daftarPaket) {
            
            // 1. Panggil cetakResi() bawaan induk
            paket.cetakResi();

            // 2. Tambahkan ongkir dasar menggunakan Polimorfisme Dinamis
            totalPendapatanPerusahaan += paket.hitungOngkir();

            // 3. Gunakan instanceof untuk Downcasting demi mengakses metode unik/spesifik 
            if (paket instanceof LayananReguler) {
                LayananReguler reguler = (LayananReguler) paket; // Downcasting
                // Panggil metode overloading khusus (Member=true, Jarak=25)
                System.out.println("Ongkir Akhir (Member, Jarak 25km): Rp " + reguler.hitungOngkir(true, 25));
                
            } else if (paket instanceof LayananExpress) {
                LayananExpress express = (LayananExpress) paket; // Downcasting
                // Panggil metode unik
                express.klaimAsuransi(1500000);
                
            } else if (paket instanceof LayananInternasional) {
                LayananInternasional internasional = (LayananInternasional) paket; // Downcasting
                // Panggil metode unik
                internasional.cetakManifest();
            }
            
            System.out.println("-------------------------------------------------");
        }
        // Cetak total pendapatan akhir keseluruhan dari ongkir dasar 
        System.out.println("TOTAL PENDAPATAN PERUSAHAAN (Ongkir Dasar) : Rp " + totalPendapatanPerusahaan);
    }
}