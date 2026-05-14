class LayananEkspedisi {
    // Menggunakan access modifier 'protected'  dari pada 'private' supaya agar dapat diturunkan ke subclass 
    protected String nomorResi;
    protected double beratAktualKg;
    protected double panjang;
    protected double lebar;
    protected double tinggi;

    // Konstruktor untuk menginisialisasi atribut 
    public LayananEkspedisi(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi) {
        this.nomorResi = nomorResi;
        this.beratAktualKg = beratAktualKg;
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    // Metode mengembalikan nilai tertinggi antara berat aktual dan volumetrik
    public double hitungBeratEfektif() {
        double beratVolumetrik = (panjang * lebar * tinggi) / 6000;
        return Math.max(beratAktualKg, beratVolumetrik); // Digunakan untuk mengembalikan nilai tertinggi seusai soal THT diminta, dan juga agar kita tidak perlu if else if untuk pemborosan memory kalau pakai math.max
    }

    // Metode mencetak nomor resi dan Berat Efektif 
    public void cetakResi() {
        System.out.println("Resi: " + nomorResi + " | Berat Efektif: " + hitungBeratEfektif() + " kg");
    }

    // Metode polymorphic yang nantinya akan ditimpa override oleh subclass 
    public double hitungOngkir() {
        return 0.0;
    }
}